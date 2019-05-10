package album.apialbum.controllers;

import album.apialbum.models.Album;
import album.apialbum.models.Post;
import album.apialbum.services.AlbumsService;
import album.apialbum.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostsService postsService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findAll(){

        List<Post> result = postsService.getPosts();

        return new ResponseEntity<List<Post>>(result, HttpStatus.OK);
    }
}
