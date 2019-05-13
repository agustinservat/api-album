package album.apialbum.apiService;

import album.apialbum.models.Photo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoServiceAPI {

    private static final String uri = "https://my-json-server.typicode.com/agustinservat/api-album/photos";

    public static List<Photo> getPhotos(){
        List<Photo> photos = makeGet("");

        return photos;
    }

    public static List<Photo> getPhotosByUser(Integer userId){
        String byUserId = "?userId=" + userId;
        List<Photo> photos = makeGet(byUserId);

        return photos;
    }

    public static List<Photo> getPhotosById(Integer id){
        String byId = "?id=" + id;
        List<Photo> photos = makeGet(byId);

        return photos;
    }

    private static List<Photo> makeGet(String extraUri){
        RestTemplate restTemplate = new RestTemplate();
        List<Photo> photoList = new ArrayList<Photo>();
        try {
            ResponseEntity<List<Photo>> rateResponse = restTemplate.exchange(uri + extraUri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Photo>>() {});
            photoList = rateResponse.getBody();
        }catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode());
            System.out.println(e.getResponseBodyAsString());
        }

        return photoList;
    }
}
