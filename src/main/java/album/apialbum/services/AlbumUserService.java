package album.apialbum.services;

import album.apialbum.apiService.AlbumServiceAPI;
import album.apialbum.apiService.UserServiceAPI;
import album.apialbum.models.Album;
import album.apialbum.models.AlbumUser;
import album.apialbum.models.User;
import album.apialbum.repositories.AlbumUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumUserService {

    @Autowired
    private AlbumUserRepository albumUserRepository;
    @Autowired
    private UserService userService;

    public List<User> findUsersByPermissions(Integer albumId, Boolean readOnly){
        List<AlbumUser> albumUserList = findPermissions(albumId, readOnly);
        List<User> result = new ArrayList<User>();
        for(AlbumUser albumUser : albumUserList){
            result.add(userService.findById(albumUser.getUserId()));
        }
        return result;
    }

    public List<AlbumUser> findPermissions(Integer albumId, Boolean readOnly){
        Album album = AlbumServiceAPI.findById(albumId);
        if(album == null){
            return null;
        }
        return albumUserRepository.findAlbumUserByAlbumIdAndReadOnly(albumId, readOnly);
    }

    public AlbumUser saveAlbumUser(AlbumUser albumUser){
        //Si el album y el usuario existe en el servicio externo
        Album album = AlbumServiceAPI.findById(albumUser.getAlbumId());
        User user = UserServiceAPI.findById(albumUser.getUserId());
        if(album != null && user != null){
            //Guardo un registro para el propietario del album
            if(album.getUserId() != albumUser.getUserId()){
                AlbumUser albumUserOwner = new AlbumUser(album.getId(), album.getUserId(), false);
                albumUserRepository.save(albumUserOwner);
            }
            try{
                return albumUserRepository.save(albumUser);
            }catch (DataIntegrityViolationException e){
                throw e;
            }
        }else{
            return null;
        }
    }

    public AlbumUser findById(Integer id){
        return albumUserRepository.findOneById(id);
    }

    public Boolean existsById(Integer id){
        return albumUserRepository.existsById(id);
    }

    public AlbumUser updatePermissions(Integer id, AlbumUser albumUser){
        AlbumUser albumUserToUpdate = findById(id);
        if(albumUserToUpdate == null){
            return null;
        }
        albumUserToUpdate.setReadOnly(albumUser.getReadOnly());
        return albumUserRepository.save(albumUserToUpdate);
    }

    public void deleteAlbumUser(Integer id){
        albumUserRepository.deleteById(id);
    }

    public void deleteAlbumUser(AlbumUser albumUser){
        albumUserRepository.delete(albumUser);
    }

    public AlbumUser findByAlbumUser(Integer albumId, Integer userId){
        return albumUserRepository.findByAlbumIdAndUserId(albumId, userId);
    }
}
