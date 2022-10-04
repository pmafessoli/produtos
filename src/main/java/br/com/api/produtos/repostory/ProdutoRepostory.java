package br.com.api.produtos.repostory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.produtos.model.ProdutoModel;

@Repository
public interface ProdutoRepostory extends CrudRepository<ProdutoModel, Long> {

}
