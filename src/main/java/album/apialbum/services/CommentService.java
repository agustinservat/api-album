package album.apialbum.services;

import album.apialbum.apiService.CommentServiceAPI;
import album.apialbum.models.Comment;
import album.apialbum.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;


    public List<Comment> getComments(){
        return CommentServiceAPI.getComments();
    }

    public List<Comment> findByName(String name){
        return CommentServiceAPI.findByName(name);
    }
}
