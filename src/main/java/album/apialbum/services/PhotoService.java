package album.apialbum.services;

import album.apialbum.apiService.PhotoServiceAPI;
import album.apialbum.models.Photo;
import album.apialbum.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;


    public List<Photo> getPhotos(){
        return PhotoServiceAPI.getPhotos();
    }

    public List<Photo> findById(Integer id){
        return PhotoServiceAPI.getPhotosById(id);
    }

    public List<Photo> findByUserId(Integer userId){
        return PhotoServiceAPI.getPhotosByUser(userId);
    }
}
