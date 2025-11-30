package com.MyProjects.E_Commerce.RestController;

import com.MyProjects.E_Commerce.DTO.UserDto.LoginReq;
import com.MyProjects.E_Commerce.DTO.UserDto.UpdatedUserDto;
import com.MyProjects.E_Commerce.DTO.UserDto.CreateUserReqDto;
import com.MyProjects.E_Commerce.DTO.UserDto.UserResponseDto;
import com.MyProjects.E_Commerce.Mapper.UserMapper;
import com.MyProjects.E_Commerce.Security.JwtService;
import com.MyProjects.E_Commerce.Service.UserService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.message.Message;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserRestController {

    private UserService userService ;
    private AuthenticationManager authenticationManager ;
    private JwtService jwtService ;
    private UserMapper userMapper ;
    private static final org.slf4j.Logger logger =  LoggerFactory.getLogger(UserRestController.class);
    public UserRestController(UserService userService, AuthenticationManager authenticationManager, JwtService jwtService ,UserMapper userMapper) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userMapper = userMapper ;

    }

    @PostMapping("/register")
     ResponseEntity<String> create (@RequestBody @Valid CreateUserReqDto user)

    {
        userService.create(user);
        return ResponseEntity.ok(jwtService.generateToken(user.getEmail()));
    }
    @PatchMapping("{id}")
    ResponseEntity<String> update (@RequestBody @Valid UpdatedUserDto user ,@PathVariable int id)
    {
        userService.update(user,id);
        return ResponseEntity.ok("user updated successfully");
    }

    @GetMapping("{id}")
    ResponseEntity<UserResponseDto> getUser (@PathVariable int id)
    {
       return ResponseEntity.ok(userMapper.toDto(userService.getUser(id))) ;
    }
    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody @Valid LoginReq login)
    {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(),login.getPassword()));
        return ResponseEntity.ok(jwtService.generateToken(login.getEmail()));
    }

}
