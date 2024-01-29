package StudentApplication.SpringJPAHibernate.Controllers;

import StudentApplication.SpringJPAHibernate.Model.User;
import StudentApplication.SpringJPAHibernate.Repository.UserRepository;
//import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepoObj;
    @PostMapping("/signup")
    public List<User> save(@RequestBody List<User> userObj){
        System.out.println(userObj);
        List<User> userResponse = userRepoObj.saveAll(userObj);

        return userResponse;
    };



    @DeleteMapping("/delete")
    public void delete(@RequestBody User userObj){
        System.out.println("DELETING "+ userObj);
        userRepoObj.delete(userObj);
    }

    @GetMapping("/getall")
    public List<User> getAll(){
        List<User> res=userRepoObj.findAll();
        System.out.println(res);
          return res;
    }

  

}

