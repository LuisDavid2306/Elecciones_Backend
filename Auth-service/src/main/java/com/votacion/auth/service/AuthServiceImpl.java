package com.votacion.auth.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.votacion.auth.dto.AuthResponse;
import com.votacion.auth.dto.LoginRequest;
import com.votacion.auth.dto.RegisterRequest;
import com.votacion.auth.entity.Usuario;
import com.votacion.auth.repository.UsuarioRepository;
import com.votacion.auth.security.JwtService;
import com.votacion.auth.exception.AuthException;

@Service
public class AuthServiceImpl implements IAuthService {
	
	private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    
    public AuthServiceImpl(
            UsuarioRepository usuarioRepository,
            BCryptPasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
	public String register(RegisterRequest request) {
	
	    if (usuarioRepository.existsByUsername(request.getUsername())) {
	    	throw new AuthException("El username ya existe");
	    }
	
	    if (usuarioRepository.existsByDni(request.getDni())) {
	        throw new AuthException("El DNI ya existe");
	    }
	
	    Usuario usuario = new Usuario();
	
	    usuario.setDni(request.getDni());
	    usuario.setNombres(request.getNombres());
	    usuario.setUsername(request.getUsername());
	    usuario.setPassword(passwordEncoder.encode(request.getPassword()));
	    usuario.setRol("VOTANTE");
	
	    usuarioRepository.save(usuario);
	
	    return "Usuario registrado correctamente";
	}

    @Override
    public AuthResponse login(LoginRequest request) {

        Usuario usuario = usuarioRepository.findByUsername(request.getUsername())
        		.orElseThrow(() ->
                new AuthException("Usuario no encontrado"));

        boolean passwordCorrecta = passwordEncoder.matches(request.getPassword(),usuario.getPassword());

        if (!passwordCorrecta) {
            throw new AuthException("Credenciales inválidas");
        }

        String token = jwtService.generateToken(usuario.getUsername());

        return new AuthResponse(token);
    }
}
