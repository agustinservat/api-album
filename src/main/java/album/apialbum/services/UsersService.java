package album.apialbum.services;

import album.apialbum.apiService.UserServiceAPI;
import album.apialbum.models.User;
import album.apialbum.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;


    public List<User> getUsers(){

        List<User> userList = UserServiceAPI.getUsers();

        usersRepository.saveAll(userList);

        return userList;
    }
}
