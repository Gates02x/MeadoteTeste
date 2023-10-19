package com.pet.Meadote.Repository;

import com.pet.Meadote.Models.PetPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PetPost,Long> {
    List<PetPost> findByUsuarioLoginIdUsuario(Long idUsuario);
}