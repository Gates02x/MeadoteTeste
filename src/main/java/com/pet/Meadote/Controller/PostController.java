package com.pet.Meadote.Controller;

import com.pet.Meadote.DTO.PetPostDTO;
import com.pet.Meadote.Mapper.PetPostMapper;
import com.pet.Meadote.Models.PetPost;
import com.pet.Meadote.Repository.PostRepository;
import com.pet.Meadote.Service.PetPostService;
import com.pet.Meadote.StorageCongif.FileStorageConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/publicacoes")
public class PostController {

    private final PetPostService petPostService;
    private final PostRepository postRepository;
    private final FileStorageConfig fileStorageConfig;

    private final PetPostMapper petPostMapper;


    @PostMapping(value = "/CriarPost",produces = "application/json",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createPost(
            @RequestParam("petName") String petName,
            @RequestParam("comment") String comment,
            @RequestParam("image") MultipartFile imageFile,
            @RequestParam("userId") Long userId,
            RedirectAttributes redirectAttributes) {

        return petPostService.createPost(petName, comment, imageFile, userId);
    }

    @GetMapping(value = "/images/{imageName}", produces = "application/json")
    public ResponseEntity<UrlResource> getImage(@PathVariable String imageName) throws MalformedURLException {
        UrlResource imageResource = fileStorageConfig.loadImageAsResource(imageName);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageResource);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<PetPostDTO>> getAllPosts() {
       List<PetPostDTO> allPostDTOs = postRepository.findAll().stream()
                .map(petPostMapper::toDTOPost)
                .collect(Collectors.toList());
        return ResponseEntity.ok(allPostDTOs);
    }
}