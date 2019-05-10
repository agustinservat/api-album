package album.apialbum.controllers;

import album.apialbum.models.Photo;
import album.apialbum.models.User;
import album.apialbum.services.PhotosService;
import album.apialbum.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/photos")
public class PhotosController {

    @Autowired
    private PhotosService photosService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Photo>> findAll(){

        List<Photo> result = photosService.getPhotos();

        return new ResponseEntity<List<Photo>>(result, HttpStatus.OK);
    }
}
