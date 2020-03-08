package com.ecommerce.ecommerce.controller;
import com.ecommerce.ecommerce.models.User;
import com.ecommerce.ecommerce.repository.IUserReprository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    private IUserReprository userReprository;

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userReprository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        userReprository.save(user);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable (value = "id") int id) throws NotFoundException {
     User user = userReprository.findById(id).orElseThrow(() -> new NotFoundException("User not found :: " + id ));
     return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable(value =  "id") int id) throws NotFoundException {
        User user = userReprository.findById(id).orElseThrow(() -> new NotFoundException("User not found :: " + id ));
        userReprository.deleteById(id);
        return ResponseEntity.ok().body(true);
    }

}
