package be.abd.helbdemo.Controller;


import be.abd.helbdemo.dao.UserDAO;
import be.abd.helbdemo.Model.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

        import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/signup")
    public void addNewUser(@RequestBody User newUser)
    {
/*        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());*/
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        userDAO.save(newUser);
    }

/*
    @GetMapping("users")
    public List<User> getUsers()
    {
        return userDao.findAll();
    }

    //SecretKeyToGenJWTsSecretKeyToGenJWTs
    @ApiOperation("User login")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
            message = "Response Headers",
                    responseHeaders = {
                    @ResponseHeader(name="authorization",
                            description = "Bearer <JWT value here>"),

            })

    })
*/

    @PostMapping("/login")
    public void theFakeLogin(@RequestBody User loginRequestModel)
    {
        //System.out.println("login");
            }

/*    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody User loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }*/
}
