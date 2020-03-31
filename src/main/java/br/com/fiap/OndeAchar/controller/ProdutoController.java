package br.com.fiap.OndeAchar.controller;

import br.com.fiap.OndeAchar.dto.ProdutoDTO;
import br.com.fiap.OndeAchar.model.Produto;
import br.com.fiap.OndeAchar.service.ProdutoService;
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
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @ApiOperation(value = "Lista todos os produtos")
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll(){
        List<ProdutoDTO> resultado = produtoService.findAll();
        return ResponseEntity.ok().body(resultado);
    }

    @ApiOperation(value = "Busca o produto pelo ID")
    @GetMapping("{idProduto}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Integer idProduto){
        ProdutoDTO resultado = produtoService.findById(idProduto);
        return ResponseEntity.ok().body(resultado);
    }

    @ApiOperation(value = "Cadastra novo produto")
    @PostMapping
    public ResponseEntity<ProdutoDTO> insert(@RequestBody ProdutoDTO produtoDTO){
        ProdutoDTO resultado = produtoService.create(produtoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idProduto}").buildAndExpand(resultado.getId()).toUri();
        return ResponseEntity.created(uri).body(resultado);
    }

    @ApiOperation(value = "Apaga um produto")
    @DeleteMapping(value = "{idProduto}")
    public void delete(@PathVariable Integer idProduto){
        produtoService.delete(idProduto);
    }

}
