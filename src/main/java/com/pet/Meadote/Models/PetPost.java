package com.pet.Meadote.Models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity

@Table(name = "POSTUSUARIO")
public class PetPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;

    @NotNull
    @NotBlank
    @Column(name = "IMAGENAME")
    private String imageName;

    @NotNull
    @NotBlank
    @Column(name = "COMENTARIOINFO", length = 500)
    private String comentario;

    @NotNull
    @NotBlank
    @Column(name = "NOMEPET", length = 15)
    private String nomePet;

    @NotNull
    @Column(name = "IDADEPET", length = 15)
    private Long idadePet;

    @NotNull
    @NotBlank
    @Column(name = "TAMANHOPET", length = 15)
    private String tamanhoPet;

    @NotNull
    @NotBlank
    @Column(name = "CIDADEPET", length = 15)
    private String cidadePet;

    @ManyToOne
    @JoinColumn(name = "IDUSUARIO")
    private UsuarioLogin usuarioLogin;

}
