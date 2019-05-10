package album.apialbum.services;

import album.apialbum.apiService.AlbumServiceAPI;
import album.apialbum.models.Album;
import album.apialbum.repositories.AlbumsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumsService {

    @Autowired
    private AlbumsRepository albumsRepository;


    public List<Album> getAlbums(){

        List<Album> albumList = AlbumServiceAPI.getAlbums();

        albumsRepository.saveAll(albumList);

        return albumList;
    }
}
