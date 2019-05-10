package album.apialbum.services;

import album.apialbum.apiService.AlbumServiceAPI;
import album.apialbum.apiService.PostServiceAPI;
import album.apialbum.models.Album;
import album.apialbum.models.Post;
import album.apialbum.repositories.AlbumsRepository;
import album.apialbum.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;


    public List<Post> getPosts(){

        List<Post> postList = PostServiceAPI.getPosts();

        postsRepository.saveAll(postList);

        return postList;
    }
}
