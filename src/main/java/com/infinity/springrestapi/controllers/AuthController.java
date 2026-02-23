//package com.infinity.springrestapi.controllers;
//
//import com.infinity.springrestapi.model.User;
//import com.infinity.springrestapi.repositories.UserRepository;
//import com.infinity.springrestapi.utils.security.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//    @Autowired
//    AuthenticationManager authenticationManager;
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    PasswordEncoder encoder;
//    @Autowired
//    JwtUtil jwtUtil;
//    @PostMapping("/login")
//    public String authenticateUser(@RequestBody User user) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        user.getEmail(),
//                        user.getPassword()
//                )
//        );
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        return jwtUtil.generateToken(userDetails.getUsername());
//    }
//
//    @PostMapping("/register")
//    public String registerUser(@RequestBody User user) {
//        if (userRepository.existsByEmail(user.getEmail())) {
//            return "User already exists";
//        }
//
//        User newUser = new User(
//                null,
//                user.getName(),
//                user.getEmail(),
//                encoder.encode(user.getPassword())
//        );
//        userRepository.save(newUser);
//        return "User registered successfully!";
//    }
//}
