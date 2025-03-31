package estudoLogin.springSecurity.controllers;


import estudoLogin.springSecurity.infra.TokenService;
import estudoLogin.springSecurity.model.user.AuthenticationDto;
import estudoLogin.springSecurity.model.user.LoginResponseDto;
import estudoLogin.springSecurity.model.user.User;
import estudoLogin.springSecurity.model.user.RegisterDto;
import estudoLogin.springSecurity.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDto data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping(path = "/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDto data){
        if(userRepository.findByUsername(data.username()) != null)return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        userRepository.save(new User(data.username(), encryptedPassword, data.role()));
        return ResponseEntity.ok().build();
    }



}
