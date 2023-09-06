package com.pet.Meadote.Service;

import com.pet.Meadote.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioService extends JpaRepository <Usuario, Long> {
}
