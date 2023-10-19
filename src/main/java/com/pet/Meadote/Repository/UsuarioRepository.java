package com.pet.Meadote.Repository;

import com.pet.Meadote.Models.UsuarioLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioLogin, Long> {
}
