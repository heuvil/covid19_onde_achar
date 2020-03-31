package br.com.fiap.OndeAchar.service;

import br.com.fiap.OndeAchar.dto.ProdutoDTO;
import br.com.fiap.OndeAchar.model.Produto;
import br.com.fiap.OndeAchar.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<ProdutoDTO> findAll() {
        return produtoRepository.findAll()
                .stream()
                .map(x -> new ProdutoDTO(x))
                .collect(Collectors.toList());
    }

    public ProdutoDTO findById(Integer id){
        return new ProdutoDTO(produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto nao encontrado")));
    }

    public ProdutoDTO create(ProdutoDTO produtoDTO) {
        return new ProdutoDTO(produtoRepository.save(fromDTO(produtoDTO)));
    }

    public void delete(Integer id) {
        produtoRepository.deleteById(id);
    }

    private Produto fromDTO(ProdutoDTO dto) {
        Produto produto = new Produto(
                dto.getId(),
                dto.getDescricao()
        );
        return produto;
    }
}
