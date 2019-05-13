package album.apialbum.controllers;

import album.apialbum.models.AlbumUser;
import album.apialbum.models.User;
import album.apialbum.services.AlbumUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album-user")
public class AlbumUserController {

    @Autowired
    private AlbumUserService albumUserService;


    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<List<User>> findPermissions(@RequestParam(name = "albumId", required = true) Integer albumId,
                                                      @RequestParam(name = "readOnly", required = true) Boolean readOnly){

        List<User> result = albumUserService.findUsersByPermissions(albumId, readOnly);
        if(result.isEmpty()){
            return new ResponseEntity<List<User>>(result, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<User>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<?> createAlbumUser(@RequestBody AlbumUser albumUser){
        try{
            AlbumUser newAlbumUser = albumUserService.saveAlbumUser(albumUser);
            if (newAlbumUser != null){
                return new ResponseEntity<AlbumUser>(newAlbumUser, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<String>("El album y/o el usuario al que quiere asignar permisos no existe.", HttpStatus.NOT_FOUND);
            }

        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
            HttpHeaders httpHeaders = new HttpHeaders();
            return new ResponseEntity<String>("Ya existe un permiso asociado al album ID: " + albumUser.getAlbumId() + " y el usuario con ID: " + albumUser.getUserId(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (Exception e){
            System.out.println(e.getMessage());
            HttpHeaders httpHeaders = new HttpHeaders();
            return new ResponseEntity<>(httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAlbumUser(@PathVariable Integer id, @RequestBody AlbumUser albumUserUpdate){
        if(!albumUserService.existsById(id)){
            return new ResponseEntity<String>("No se encontró el permiso asociado con ID " + id, HttpStatus.NOT_FOUND);
        }
        try {
            AlbumUser result = albumUserService.updatePermissions(id, albumUserUpdate);
            if (result != null){
                return new ResponseEntity<AlbumUser>(result, HttpStatus.OK);
            }else{
                return new ResponseEntity<String>("El album y/o el usuario que quiere actualizar no existe.", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<String>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAlbumUser(@PathVariable Integer id){
        if(!albumUserService.existsById(id)){
            return new ResponseEntity<String>("No se encontró el permiso asociado con ID " + id, HttpStatus.NOT_FOUND);
        }
        try {
            albumUserService.deleteAlbumUser(id);
            return new ResponseEntity<String>("El permiso se ha eliminado correctamente", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/album/{albumId}/user/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAlbumUser(@PathVariable Integer albumId, @PathVariable Integer userId){

        AlbumUser albumUser = albumUserService.findByAlbumUser(albumId, userId);
        if(albumUser == null){
            return new ResponseEntity<String>("No se encontró el permiso asociado con del album ID " + albumId + " user ID: " + userId, HttpStatus.NOT_FOUND);
        }
        try {
            albumUserService.deleteAlbumUser(albumUser);
            return new ResponseEntity<String>("El permiso se ha eliminado correctamente", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
