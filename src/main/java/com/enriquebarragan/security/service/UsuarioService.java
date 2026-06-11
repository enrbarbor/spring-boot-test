package com.enriquebarragan.security.service;

import com.enriquebarragan.security.dto.RegisterRequest;
import com.enriquebarragan.security.entity.Rol;
import com.enriquebarragan.security.entity.Usuario;
import com.enriquebarragan.security.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(RegisterRequest request) {
        Usuario usuario = Usuario.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .rol(Rol.USER)
                .build();
        usuarioRepository.save(usuario);
    }
}