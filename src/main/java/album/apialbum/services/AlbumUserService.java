package album.apialbum.services;

import album.apialbum.apiService.AlbumServiceAPI;
import album.apialbum.models.Album;
import album.apialbum.models.AlbumUser;
import album.apialbum.repositories.AlbumUserRepository;
import album.apialbum.repositories.AlbumsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumUserService {

    @Autowired
    private AlbumUserRepository albumUserRepository;


    public List<AlbumUser> getAlbumUsers(){
        return albumUserRepository.findAll();
    }

    public AlbumUser saveAlbumUser(AlbumUser albumUser){
        return albumUserRepository.save(albumUser);
    }

    public AlbumUser findById(Integer id){
        Optional<AlbumUser> albumUserOptional = albumUserRepository.findById(id);
        return albumUserOptional.get();
    }

    public AlbumUser updatePermissions(AlbumUser albumUser){
        AlbumUser albumUserToUpdate = findById(albumUser.getId());
        albumUserToUpdate.setReadOnly(albumUser.getReadOnly());
        return albumUserRepository.save(albumUserToUpdate);
    }
}
