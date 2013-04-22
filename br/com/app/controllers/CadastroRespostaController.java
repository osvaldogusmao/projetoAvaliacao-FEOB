
package br.com.app.controllers;

import br.com.app.dao.RespostaDao;
import br.com.app.entidades.Resposta;
import br.com.app.form.FrmResposta;
import java.util.List;

public class CadastroRespostaController {
    private static CadastroRespostaController instancia = new CadastroRespostaController();
    private FrmResposta view;
    private Resposta resposta = new Resposta();
    
    public static CadastroRespostaController getInstancia() {
        return instancia;
    }
    
    public void salvar() {
        //view.sincronizarEntidadeComForm(professor);
        if (resposta.getId() == null) {
            new RespostaDao().salvar(resposta);
        }
    }
    
    public void atualizar() {
        //view.sincronizarEntidadeComForm(professor);
        if (resposta.getId() != null) {
            new RespostaDao().update(resposta);
        }
    }
    
    public void remover() {
       // view.sincronizarEntidadeComForm(resposta);
        if (resposta.getId() != null) {
            new RespostaDao().apagar(resposta);
        }
    }
    
    public void listarPorNome(String nome) {
            List<Resposta> lista = new RespostaDao().procurar(resposta);
    }
    
    public void exibirInterfaceGrafica() {
        if (view == null) {
            view = new FrmResposta(this);
        }
        view.setVisible(true);
    }

}




