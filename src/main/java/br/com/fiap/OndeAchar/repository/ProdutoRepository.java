package br.com.fiap.OndeAchar.repository;

import br.com.fiap.OndeAchar.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, Integer> {

}
