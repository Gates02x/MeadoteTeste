package com.pet.Meadote.Service;

import com.pet.Meadote.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostService extends JpaRepository<Post,Long> {
}
