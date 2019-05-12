package album.apialbum.controllers;

import album.apialbum.models.Photo;
import album.apialbum.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PhotoController {

    @Autowired
    private PhotoService photoService;


    @RequestMapping(value = "/photos", method = RequestMethod.GET)
    public ResponseEntity<List<Photo>> findAll(@RequestParam(name = "userId", required = false) Integer userId){

        List<Photo> result = new ArrayList<Photo>();
        if(userId != null){
            result = photoService.findByUserId(userId);
        }else{
            result = photoService.getPhotos();
        }
        if(result.isEmpty()){
            return new ResponseEntity<List<Photo>>(result, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Photo>>(result, HttpStatus.OK);
    }

}
