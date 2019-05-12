package album.apialbum.controllers;

import album.apialbum.models.User;
import album.apialbum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(@RequestParam(name = "id", required = false) Integer id){

        List<User> result = new ArrayList<User>();
        if(id != null){
            result.add(userService.findById(id));
        }else{
            result = userService.getUsers();
        }
        if(result.isEmpty()){
            return new ResponseEntity<List<User>>(result, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<User>>(result, HttpStatus.OK);
    }
}
