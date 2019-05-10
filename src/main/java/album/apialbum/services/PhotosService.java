package album.apialbum.services;

import album.apialbum.apiService.PhotoServiceAPI;
import album.apialbum.apiService.UserServiceAPI;
import album.apialbum.models.Photo;
import album.apialbum.models.User;
import album.apialbum.repositories.PhotosRepository;
import album.apialbum.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotosService {

    @Autowired
    private PhotosRepository photosRepository;


    public List<Photo> getPhotos(){

        List<Photo> photoList = PhotoServiceAPI.getPhotos();

        photosRepository.saveAll(photoList);

        return photoList;
    }
}
