package album.apialbum.services;

import album.apialbum.apiService.AlbumServiceAPI;
import album.apialbum.models.Album;
import album.apialbum.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;


    public List<Album> getAlbums(){
        return AlbumServiceAPI.getAlbums();
    }

    public List<Album> findByUserId(Integer userId){
        return AlbumServiceAPI.findByUserId(userId);
    }
}
