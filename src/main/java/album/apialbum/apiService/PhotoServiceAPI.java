package album.apialbum.apiService;

import album.apialbum.models.Photo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PhotoServiceAPI {

    private static final String uri = "https://my-json-server.typicode.com/agustinservat/api-album/photos";

    public static List<Photo> getPhotos(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Photo>> rateResponse = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Photo>>() {});
        List<Photo> photos = rateResponse.getBody();

        return photos;
    }
}
