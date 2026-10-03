package br.com.fiap.esg.dto;

import br.com.fiap.esg.model.Usuario;
import br.com.fiap.esg.model.UsuarioRole;

public record UsuarioExibicaoDTO(
        Long usuarioId,
        String nome,
        String email,
        UsuarioRole role) {

    public UsuarioExibicaoDTO(Usuario usuario) {
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole());
    }

}
