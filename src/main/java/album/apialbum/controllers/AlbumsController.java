package album.apialbum.controllers;

import album.apialbum.models.Album;
import album.apialbum.services.AlbumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    @Autowired
    private AlbumsService albumsService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Album>> findAll(){

        List<Album> result = albumsService.getAlbums();

        return new ResponseEntity<List<Album>>(result, HttpStatus.OK);
    }
}
