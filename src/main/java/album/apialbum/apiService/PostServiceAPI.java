package album.apialbum.apiService;

import album.apialbum.models.Album;
import album.apialbum.models.Post;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostServiceAPI {

    private static final String uri = "https://my-json-server.typicode.com/agustinservat/api-album/posts";

    public static List<Post> getPosts(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Post>> rateResponse = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>() {});
        List<Post> postList = rateResponse.getBody();

        return postList;
    }
}
