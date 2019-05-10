package album.apialbum.controllers;

import album.apialbum.models.Album;
import album.apialbum.models.Comment;
import album.apialbum.services.AlbumsService;
import album.apialbum.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> findAll(){

        List<Comment> result = commentsService.getComments();

        return new ResponseEntity<List<Comment>>(result, HttpStatus.OK);
    }
}
