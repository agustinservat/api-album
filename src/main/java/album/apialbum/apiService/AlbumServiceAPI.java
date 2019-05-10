package album.apialbum.apiService;

import album.apialbum.models.Album;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AlbumServiceAPI {

    private static final String uri = "https://my-json-server.typicode.com/agustinservat/api-album/albums";

    public static List<Album> getAlbums(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Album>> rateResponse = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Album>>() {});
        List<Album> albums = rateResponse.getBody();

        return albums;
    }
}
