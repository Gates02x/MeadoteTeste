package com.pet.Meadote.Service;

import com.pet.Meadote.DTO.PetPostDTO;
import com.pet.Meadote.DTO.UsuarioDTO;
import com.pet.Meadote.Mapper.PetPostMapper;
import com.pet.Meadote.Models.PetPost;
import com.pet.Meadote.Models.Usuario;
import com.pet.Meadote.Repository.PostRepository;
import com.pet.Meadote.Repository.UsuarioRepository;
import com.pet.Meadote.StorageCongif.FileStorageConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PetPostService {

    private final PostRepository postRepository;

    private final FileStorageConfig fileStorageConfig;

    private final UsuarioRepository usuarioRepository;

    private final PetPostMapper petPostMapper;


    public ResponseEntity<?> createPost(String petName, String comment, MultipartFile imageFile, Long userId) {
        Optional<Usuario> userOptional = usuarioRepository.findById(userId);
        if (!userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não encontrado.");
        }

        Usuario usuario = userOptional.get();

        PetPost post = new PetPost();
        post.setNomePet(petName);
        post.setComentario(comment);
        post.setUsuario(usuario);

        PetPost savedPost = postRepository.save(post);

        String imageName = savedPost.getIdPost() + "_" + imageFile.getOriginalFilename();
        savedPost.setImageName(imageName);
        postRepository.save(savedPost);

        fileStorageConfig.saveImage(imageName, imageFile);

        PetPostDTO petPostDTO = petPostMapper.toDTOPost(savedPost);

        return ResponseEntity.ok(petPostDTO);
    }

    public ResponseEntity<List<PetPostDTO>> getPostsByUserId(Long userId) {
        List<PetPost> userPosts = postRepository.findByUsuarioIdUsuario(userId);

        List<PetPostDTO> userPostDTOs = userPosts.stream()
                .map(petPostMapper::toDTOPost)
                .collect(Collectors.toList());

        return ResponseEntity.ok(userPostDTOs);
    }
}