package com.pet.Meadote.Models;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter

@Table(name = "PostUsuario")
public class PetPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;

    private String imageName;

    @Column(name = "comentarioInfo", length = 500)
    private String comentario;

    @Column(name = "nomePet", length = 15)
    private String nomePet;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

}
