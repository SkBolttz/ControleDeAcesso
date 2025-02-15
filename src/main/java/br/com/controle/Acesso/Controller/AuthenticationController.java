package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle.Acesso.DTO.UserDTO;
import br.com.controle.Acesso.Entity.User;
import br.com.controle.Acesso.Security.TokenService;
import br.com.controle.Acesso.Service.SecurityService;
import jakarta.validation.Valid;

@RestController
public class AuthenticationController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;
    
    @Autowired
    private SecurityService securityService;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody @Valid UserDTO user) {
    
        var tokenAutenthication = new UsernamePasswordAuthenticationToken(user.name(), user.password());
        var authentication = manager.authenticate(tokenAutenthication);
        var token = tokenService.gerarToken((UserDTO) authentication.getPrincipal());
        
        return ResponseEntity.ok().header("Authorization", token).build();
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid User user) {

        securityService.save(user);

        return ResponseEntity.ok().build();
    }
}
