package album.apialbum.controllers;

import album.apialbum.models.Album;
import album.apialbum.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AlbumController {

    @Autowired
    private AlbumService albumService;


    @RequestMapping(value = "/albums", method = RequestMethod.GET)
    public ResponseEntity<List<Album>> findAll(@RequestParam(name = "userId", required = false) Integer userId){

        List<Album> result = new ArrayList<Album>();
        if(userId != null){
            result = albumService.findByUserId(userId);
        }else{
            result = albumService.getAlbums();
        }
        if(result.isEmpty()){
            return new ResponseEntity<List<Album>>(result, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Album>>(result, HttpStatus.OK);
    }
}
