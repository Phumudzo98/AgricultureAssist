package com.agriculture.project.controller;


import com.agriculture.project.config.JwtUtil;
import com.agriculture.project.dto.AuthRequest;
import com.agriculture.project.dto.AuthResponse;
import com.agriculture.project.dto.RegisterDto;
import com.agriculture.project.model.User;
import com.agriculture.project.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserRepository userRepo, PasswordEncoder encoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        String token = jwtUtil.generateToken(request.getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto request) {
        if (userRepo.findByEmail(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        User user = new User();

        user.setEmail(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole("USER");
        user.setFirstName(request.getFirstName());
        user.setCity(request.getCity());
        user.setProvince(request.getProvince());
        user.setPostalCode(request.getPostalCode());

        userRepo.save(user);
        return ResponseEntity.ok("User registered");
    }
}
