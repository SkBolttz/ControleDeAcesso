package br.com.controle.Acesso.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.controle.Acesso.Entity.User;
import br.com.controle.Acesso.Repository.UserRepository;
import br.com.controle.Acesso.Security.SecurityConfiguration;

@Service
public class SecurityService implements UserDetailsService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByName(username);

        if(user != null){
            return user;
        }

        throw new RuntimeException("Usuário não localizado!");
    }

    public void save(User user) {
        user.setPassword(securityConfiguration.passwordEncoder().encode(user.getPassword()));

        repository.save(user);
    }   
}
