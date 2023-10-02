package com.pet.Meadote.Controller;

import com.pet.Meadote.Models.Usuario;
import com.pet.Meadote.Service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/conta")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping(value = "/criar", produces = "application/json")
    public ResponseEntity criarConta (@RequestBody Usuario usuario){
        Usuario contaCriada = usuarioService.CriarConta(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("feito com sucesso !!!!");
    }


}
