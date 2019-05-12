package album.apialbum.services;

import album.apialbum.apiService.UserServiceAPI;
import album.apialbum.models.User;
import album.apialbum.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getUsers(){
        return UserServiceAPI.getUsers();
    }

    public User findById(Integer id){
        return UserServiceAPI.findById(id);
    }
}
