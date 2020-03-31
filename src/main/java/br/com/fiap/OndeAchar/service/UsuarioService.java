package br.com.fiap.OndeAchar.service;

import br.com.fiap.OndeAchar.dto.UsuarioDTO;
import br.com.fiap.OndeAchar.model.Necessidade;
import br.com.fiap.OndeAchar.model.Usuario;
import br.com.fiap.OndeAchar.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(x -> new UsuarioDTO(x))
                .collect(Collectors.toList());
    }

    public UsuarioDTO findByCpf(String cpf) {
        return new UsuarioDTO(usuarioRepository.findById(cpf)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado")));
    }

    public List<UsuarioDTO> findByCidade(Integer cidade){
        return usuarioRepository.findByCidade(cidade)
                .stream()
                .map(x -> new UsuarioDTO(x))
                .collect(Collectors.toList());
    }

    public UsuarioDTO create(UsuarioDTO usuario) {
        return new UsuarioDTO(usuarioRepository.save(fromDTO(usuario)));
    }

    public void delete(String cpf) {
        usuarioRepository.deleteById(cpf);
    }

    public UsuarioDTO addNecessidade(String cpf, Integer idProduto, String mensagem){
        Usuario usuario = usuarioRepository.findById(cpf)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado"));
        usuario.getNecessidades().add(new Necessidade(idProduto, mensagem));
        return new UsuarioDTO(usuario);
    }

    private Usuario fromDTO(UsuarioDTO dto) {
        Usuario usuario = new Usuario(
                dto.getCpf(),
                dto.getNome(),
                dto.getCidade(),
                dto.getEmail(),
                dto.getCelular(),
                dto.getNecessidades()
        );

        return usuario;
    }

}
