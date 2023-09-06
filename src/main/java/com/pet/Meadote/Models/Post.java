package com.pet.Meadote.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "PostUsuario")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;

    @Lob
    private byte[] dados;

    @Column(name = "comentarioInfo",length = 500)
    private String comentario;

    @Column(name = "nomePet", length = 15)
    private String nomePet;


    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

}
