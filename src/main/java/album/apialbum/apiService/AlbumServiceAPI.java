package album.apialbum.apiService;

import album.apialbum.models.Album;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumServiceAPI {

    private static final String uri = "https://my-json-server.typicode.com/agustinservat/api-album/albums";

    // TODO agreagar el try catch
    public static List<Album> getAlbums(){

        List<Album> albums = makeGet("");
        return albums;
    }

    public static List<Album> findByUserId(Integer userId){
        String byUserId = "?userId=" + userId;
        List<Album> albumList = makeGet(byUserId);

        return albumList;
    }

    public static Album findById(Integer id){
        String byId = "?id=" + id;
        List<Album> albumList = makeGet(byId);
        if(albumList.size() == 1){
            return albumList.get(0);
        }
        return null;
    }

    private static List<Album> makeGet(String extraUri){
        RestTemplate restTemplate = new RestTemplate();
        List<Album> albumList = new ArrayList<Album>();
        try{
            ResponseEntity<List<Album>> rateResponse = restTemplate.exchange(uri + extraUri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Album>>() {});
            albumList = rateResponse.getBody();
        }catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode());
            System.out.println(e.getResponseBodyAsString());
        }

        return albumList;
    }
}
