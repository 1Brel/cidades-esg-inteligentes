package br.com.fiap.esg.controller;

import br.com.fiap.esg.config.security.TokenService;
import br.com.fiap.esg.dto.LoginDTO;
import br.com.fiap.esg.dto.TokenDTO;
import br.com.fiap.esg.dto.UsuarioCadastroDTO;
import br.com.fiap.esg.dto.UsuarioExibicaoDTO;
import br.com.fiap.esg.model.Usuario;
import br.com.fiap.esg.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO login) {
        UsernamePasswordAuthenticationToken userNamePassword = new UsernamePasswordAuthenticationToken(login.email(), login.senha());
        Authentication auth = authenticationManager.authenticate(userNamePassword);
        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity register(@RequestBody @Valid UsuarioCadastroDTO usuarioDTO) {
        UsuarioExibicaoDTO usuario = usuarioService.salvarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuario);
    }
}
