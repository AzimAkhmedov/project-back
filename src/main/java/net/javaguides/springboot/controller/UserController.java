package net.javaguides.springboot.controller;

import java.util.*;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
//import net.javaguides.springboot.model.Employee;
//import net.javaguides.springboot.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

static class RegistrationBody{
    private String fullName;
    private String password;

    public RegistrationBody(String userName, String password) {
        this.fullName = userName;
        this.password = password;
    }
    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

    @Autowired
    private UserRepository userRepository;

    // get all employees
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @PostMapping("/registration")
    public  User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
    @DeleteMapping("/user/{id}")
    public  void  deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }
    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable Long id,@RequestBody User user ){
      User oldUser = userRepository.findById(id).get();
        // crush the variables of the object found
      oldUser.setPassword(user.getPassword());
      oldUser.setFullName(user.getFullName());
      oldUser.setRole(user.getRole());
        userRepository.save(oldUser);
    }
    @PostMapping("/login")

    public Optional<User> login(@RequestBody RegistrationBody body){
        Optional<User> found = Optional.empty();
        for(User i : userRepository.findAll()){
            if(Objects.equals(i.getFullName(), body.getFullName()) && Objects.equals(i.getPassword(), body.getPassword())){
                found = Optional.of(i);
            }
        }
        return found;
    }

//    @PostMapping("/registration")
    public void registration(String fullName, String password, String role, String passportNumber, String citizenship){
        User newUser = new User(fullName, password, role, passportNumber,citizenship);
        userRepository.save(newUser);
    }

//    // create employee rest api
//    @PostMapping("/employees")
//    public User createEmployee(@RequestBody Employee employee) {
//        return employeeRepository.save(employee);
//    }

    // get employee by id rest api
//    @GetMapping("/employees/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//        Employee employee = employeeRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//        return ResponseEntity.ok(employee);
//    }

    // update employee rest api

    // delete employee rest api

}