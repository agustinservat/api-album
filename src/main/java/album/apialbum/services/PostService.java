package album.apialbum.services;

import album.apialbum.apiService.PostServiceAPI;
import album.apialbum.models.Post;
import album.apialbum.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public List<Post> getPosts(){
        return PostServiceAPI.getPosts();
    }

    public List<Post> findByUserId(Integer userId){
        return PostServiceAPI.findByUserId(userId);
    }
}
