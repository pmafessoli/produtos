package br.com.api.produtos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.model.ProdutoModel;
import br.com.api.produtos.model.RespostaModel;
import br.com.api.produtos.repostory.ProdutoRepostory;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepostory pr;

    @Autowired
    private RespostaModel rm;

    // metodo para listar todos os produtos
    public Iterable<ProdutoModel> listar() {
        return pr.findAll();
    }

    // Metodo para cadastrar produtos ou alterar produtos
    public ResponseEntity<?> cadastrarAlterar(ProdutoModel pm, String acao) {

        if (pm.getNome().equals("")) {
            rm.setMensagem("O nome do produto é obrigatório");
            return new ResponseEntity<RespostaModel>(rm, HttpStatus.BAD_REQUEST);

        } else if (pm.getMarca().equals("")) {
            rm.setMensagem("O nome da marca é obrigatório");
            return new ResponseEntity<RespostaModel>(rm, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equalsIgnoreCase("cadastrar")) {
                return new ResponseEntity<ProdutoModel>(pr.save(pm), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<ProdutoModel>(pr.save(pm), HttpStatus.OK);
            }
        }
    }

    // Metodo para remover produtos
    public ResponseEntity<RespostaModel> remover(long codigo) {
        pr.deleteById(codigo);
        rm.setMensagem("O produto foi removido com sucesso");
        return new ResponseEntity<RespostaModel>(rm, HttpStatus.OK);
    }

}
