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

@Table (name = "ContaUsuario")
public class Usuario {

    @Id
    @Column(name = "idUsuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nomeLogin", length = 15)
    private String nomeLogin;


    @Column (name = "senhaUsuario")
    private String senhaUsuario;


    @Column(name = "nomeUsuario", length = 30)
    private String nomeUsuario;

    @Column(name = "TelefoneUsuario",length = 12)
    private String TelefoneUsuario;

}
