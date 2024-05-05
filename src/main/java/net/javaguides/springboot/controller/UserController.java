package net.javaguides.springboot.controller;

import java.util.*;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.response.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import org.springframework.web.server.ResponseStatusException;
//import net.javaguides.springboot.model.Employee;
//import net.javaguides.springboot.repository.EmployeeRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class UserController {

static class RegistrationBody{
    private String passportNumber;
    private String password;

    public RegistrationBody(String passportNumber, String password) {
        this.passportNumber = passportNumber;
        this.password = password;
    }
    public String getPassportNumber() {
        return passportNumber;
    }

    public String getPassword() {
        return password;
    }
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
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
    public  ResponseEntity<Object> createUser(@RequestBody User user){
        System.out.println(user.getFullname());
        try {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK );
        }catch (Error e){
        return new ResponseEntity<>(new ErrorMessage("Bruh, registration failed "+e.getMessage()), HttpStatus.BAD_GATEWAY );
     }
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
      oldUser.setFullname(user.getFullname());
      oldUser.setRole(user.getRole());
        userRepository.save(oldUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody RegistrationBody body)  {
            User user = userRepository.findByPassportNumberAndPassword(body.getPassportNumber(), body.getPassword());
            if (user==null){
                return new ResponseEntity<>(new ErrorMessage("No match for provided passport number or password"), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(user, HttpStatus.OK );
    }

    @ExceptionHandler
    public void handleException() {
        //
    }

//    @ExceptionHandler({ CustomException1.class, CustomException2.class })


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