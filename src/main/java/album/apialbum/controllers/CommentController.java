package album.apialbum.controllers;

import album.apialbum.models.Comment;
import album.apialbum.services.CommentService;
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
public class CommentController {

    @Autowired
    private CommentService commentService;


    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> findAll(@RequestParam(name = "name", required = false) String name){

        List<Comment> result = new ArrayList<Comment>();
        if(name != null){
            result = commentService.findByName(name);
        }else{
            result = commentService.getComments();
        }
        if(result.isEmpty()){
            return new ResponseEntity<List<Comment>>(result, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Comment>>(result, HttpStatus.OK);
    }
}
