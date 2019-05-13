package album.apialbum.apiService;

import album.apialbum.models.Post;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceAPI {

    private static final String uri = "https://my-json-server.typicode.com/agustinservat/api-album/posts";

    public static List<Post> getPosts(){
        List<Post> postList = makeGet("");

        return postList;
    }

    public static List<Post> findByUserId(Integer userId){
        String byUserId = "?userId=" + userId;
        List<Post> postList = makeGet(byUserId);

        return postList;
    }

    private static List<Post> makeGet(String extraUri){
        RestTemplate restTemplate = new RestTemplate();
        List<Post> postList = new ArrayList<Post>();
        try {
            ResponseEntity<List<Post>> rateResponse = restTemplate.exchange(uri + extraUri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>() {});
            postList = rateResponse.getBody();
        }catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode());
            System.out.println(e.getResponseBodyAsString());
        }

        return postList;
    }
}
