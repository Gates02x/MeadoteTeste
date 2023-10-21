package com.pet.Meadote.Service;

import com.pet.Meadote.DTO.PetPostDTO;
import com.pet.Meadote.Exceptions.MessageNotFoundException;
import com.pet.Meadote.Mapper.PetPostMapper;
import com.pet.Meadote.Models.PetPost;
import com.pet.Meadote.Models.UsuarioLogin;
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


    public ResponseEntity<?> createPost(String petName, String comment, Long idadePet, String tamanhoPet, String cidadePet, MultipartFile imageFile, Long userId) {
        Optional<UsuarioLogin> userOptional = usuarioRepository.findById(userId);
        if (!userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não encontrado.");
        }

        UsuarioLogin usuarioLogin = userOptional.get();

        PetPost post = petPostMapper.toEntity(petName, comment, idadePet, tamanhoPet, cidadePet, usuarioLogin);

        String imageName = System.currentTimeMillis() + "MeAdoteImg" + imageFile.getOriginalFilename();
        post.setImageName(imageName);

        PetPost savedPost = postRepository.save(post);

        fileStorageConfig.saveImage(imageName, imageFile);

        PetPostDTO petPostDTO = petPostMapper.toDTOPost(savedPost);

        return ResponseEntity.ok(petPostDTO);
    }


    // Outros métodos do serviço
    public ResponseEntity<List<PetPostDTO>> getPostsByUserId(Long userId) {
        List<PetPost> userPosts = postRepository.findByUsuarioLoginIdUsuario(userId);

        List<PetPostDTO> userPostDTOs = userPosts.stream()
                .map(petPostMapper::toDTOPost)
                .collect(Collectors.toList());

        return ResponseEntity.ok(userPostDTOs);
    }

    public void deletePetPost(Long postId) {
        postRepository.findById(postId)
                .orElseThrow(()-> new MessageNotFoundException(MessageNotFoundException.NotFoundPostId(postId)));
        postRepository.deleteById(postId);

    }
}