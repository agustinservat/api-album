package album.apialbum.apiService;

import album.apialbum.models.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceAPI {

    private static final String uri = "https://my-json-server.typicode.com/agustinservat/api-album/users";

    public static List<User> getUsers(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<User>> rateResponse = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
        List<User> users = rateResponse.getBody();

        return users;
    }
}
