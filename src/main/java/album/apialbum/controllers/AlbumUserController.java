package album.apialbum.controllers;

import album.apialbum.models.AlbumUser;
import album.apialbum.services.AlbumUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/album-user")
public class AlbumUserController {

    @Autowired
    private AlbumUserService albumUserService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<AlbumUser>> findAll(){

        List<AlbumUser> result = albumUserService.getAlbumUsers();

        return new ResponseEntity<List<AlbumUser>>(result, HttpStatus.OK);
    }

    // TODO mejorar las respuestas de responseEntity
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<AlbumUser> createAlbumUser(@RequestBody AlbumUser albumUser){

        try{
            AlbumUser newAlbumUser = albumUserService.saveAlbumUser(albumUser);
            return new ResponseEntity<AlbumUser>(newAlbumUser, HttpStatus.CREATED);

        }catch (Exception e){
            System.out.println(e.getMessage());
            HttpHeaders httpHeaders = new HttpHeaders();
            return new ResponseEntity<>(httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    // TODO mejorar las respuestas de responseEntity
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAlbumUser(@RequestBody AlbumUser albumUserUpdate){
        AlbumUser albumUser = albumUserService.findById(albumUserUpdate.getId());

        if(albumUser == null){
            return new ResponseEntity<String>("No se encontró el permiso asociado con ID" + albumUserUpdate.getId(), HttpStatus.NOT_FOUND);
        }

        try {
            AlbumUser restul = albumUserService.updatePermissions(albumUserUpdate);
            if (restul != null){
                return new ResponseEntity<AlbumUser>(restul, HttpStatus.OK);
            }else{
                return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<String>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
