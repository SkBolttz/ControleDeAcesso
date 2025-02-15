package br.com.controle.Acesso.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.Acesso.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByName(String username);
    
}
