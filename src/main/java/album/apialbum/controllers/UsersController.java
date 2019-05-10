package album.apialbum.controllers;

import album.apialbum.models.User;
import album.apialbum.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ResponseEntity<List<UrlManager>> findAll(HttpServletRequest request){
//
//        String userAgentInfo = request.getHeader("User-Agent");
//        System.out.println(request.getRemoteAddr());
//        System.out.println(userAgentInfo);
//
//        return new ResponseEntity<List<UrlManager>>(urlService.getAll(), HttpStatus.OK);
//    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){

        List<User> result = usersService.getUsers();

        return new ResponseEntity<List<User>>(result, HttpStatus.OK);
    }
}
