package album.apialbum.controllers;

import album.apialbum.models.Post;
import album.apialbum.services.PostService;
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
public class PostController {

    @Autowired
    private PostService postService;


    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findAll(@RequestParam(name = "userId", required = false) Integer userId){

        List<Post> result = new ArrayList<Post>();
        if(userId != null){
            result = postService.findByUserId(userId);
        }else{
            result = postService.getPosts();
        }
        if(result.isEmpty()){
            return new ResponseEntity<List<Post>>(result, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Post>>(result, HttpStatus.OK);
    }
}
