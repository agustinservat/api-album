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

        List<User> users = makeGet("");

        return users;
    }

    public static User findById(Integer id){
        String byId = "?id=" + id;
        List<User> userList = makeGet(byId);
        if(userList.size() > 1){
            //Error
        }
        return userList.get(0);
    }

    private static List<User> makeGet(String extraUri){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<User>> rateResponse = restTemplate.exchange(uri + extraUri, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
        List<User> userList = rateResponse.getBody();

        return userList;
    }
}
