package br.com.controle.Acesso.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.Acesso.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    
}
