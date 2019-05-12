package album.apialbum.apiService;

import album.apialbum.models.Comment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommentServiceAPI {

    private static final String uri = "https://my-json-server.typicode.com/agustinservat/api-album/comments";

    public static List<Comment> getComments(){

        List<Comment> commentList = makeGet("");

        return commentList;
    }

    public static List<Comment> findByUserId(Integer userId){
        String byUserId = "?userId=" + userId;
        List<Comment> commentList = makeGet(byUserId);

        return commentList;
    }

    public static List<Comment> findByName(String name){
        String byName = "?name=" + name;
        List<Comment> commentList = makeGet(byName);

        return commentList;
    }

    private static List<Comment> makeGet(String extraUri){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Comment>> rateResponse = restTemplate.exchange(uri + extraUri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Comment>>() {});
        List<Comment> commentList = rateResponse.getBody();

        return commentList;
    }
}
