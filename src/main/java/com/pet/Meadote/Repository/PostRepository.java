package com.pet.Meadote.Repository;

import com.pet.Meadote.Models.PetPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PetPost,Long> {
}
