package br.com.fiap.OndeAchar.repository;

import br.com.fiap.OndeAchar.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

//    @Query("{'tipoSanguineo' : ?0 , 'cidade' : ?1}")
//    public List<Usuario> findByTipoSanguineoOrCidade(TipoSanguineo tipoSanguineo, Integer cidade);

    public List<Usuario> findByCidade(Integer cidade);

}