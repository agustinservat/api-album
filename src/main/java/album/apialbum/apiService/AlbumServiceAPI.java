package album.apialbum.apiService;

import album.apialbum.models.Album;
import album.apialbum.models.Photo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
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
        if(albumList.size() > 1){
            //Error
        }

        return albumList.get(0);
    }

    private static List<Album> makeGet(String extraUri){
        RestTemplate restTemplate = new RestTemplate();
        List<Album> albumList = new ArrayList<Album>();
        try{
            ResponseEntity<List<Album>> rateResponse = restTemplate.exchange(uri + extraUri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Album>>() {});
            restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
                @Override public boolean hasError(ClientHttpResponse response)
                        throws IOException {
                    try {
                        return super.hasError(response);
                    } catch (Exception e) {
                        System.out.println("Exception [" + e.getMessage() + "] occurred while trying to send the request" + e);
                        return true;
                    }
                }

                @Override public void handleError(ClientHttpResponse response)
                        throws IOException {
                    try {
                        //Do your stuff
                        super.handleError(response);
                    } catch (Exception e) {
                        System.out.println("Exception [" + e.getMessage() + "] occurred while trying to send the request" + e);
                        throw e;
                    }
                }
            });
             albumList = rateResponse.getBody();
        }catch (Exception e){
            System.out.println("Exception [" + e.getMessage() + "] occurred while trying to send the request" + e);
//            throw e;
        }

        return albumList;
    }
}
