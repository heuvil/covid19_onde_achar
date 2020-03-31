package br.com.fiap.OndeAchar.controller;

import br.com.fiap.OndeAchar.dto.UsuarioDTO;
import br.com.fiap.OndeAchar.dto.UsuarioDTO;
import br.com.fiap.OndeAchar.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Api
@RestController
@CrossOrigin
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ApiOperation(value = "Lista todos os usuarios")
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        List<UsuarioDTO> resultado = usuarioService.findAll();
        return ResponseEntity.ok().body(resultado);
    }

    @ApiOperation(value = "Busca o usuario pelo cpf")
    @GetMapping("{cpf}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable String cpf){
        UsuarioDTO resultado = usuarioService.findByCpf(cpf);
        return ResponseEntity.ok().body(resultado);
    }

    @ApiOperation(value = "Cadastra novo usuario")
    @PostMapping
    public ResponseEntity<UsuarioDTO> insert(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO resultado = usuarioService.create(usuarioDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cpf}").buildAndExpand(resultado.getCpf()).toUri();
        return ResponseEntity.created(uri).body(resultado);
    }

    @ApiOperation(value = "Apaga um usuario")
    @DeleteMapping(value = "{cpf}")
    public void delete(@PathVariable String cpf){
        usuarioService.delete(cpf);
    }

}
