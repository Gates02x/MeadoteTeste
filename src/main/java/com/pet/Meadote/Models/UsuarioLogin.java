package com.pet.Meadote.Models;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity

@Table (name = "USUARIOLOGIN")
public class UsuarioLogin {

    @Id
    @Column(name = "IDUSUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @NotNull
    @NotBlank
    @Column(name = "EMAIL", length = 35)
    private String email;

    @NotNull
    @NotBlank
    @Column(name = "SENHAUSUARIO")
    private String senhaUsuario;

    @NotNull
    @NotBlank
    @Column(name = "NOMEUSUARIO", length = 30)
    private String nomeUsuario;

    @NotNull
    @NotBlank
    @Column(name = "TELEFONEUSUARIO",length = 12)
    private String telefoneUsuario;

}
