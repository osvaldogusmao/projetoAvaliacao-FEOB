package br.com.app.controllers;

import br.com.app.dao.RespostaDao;
import br.com.app.entidades.Professor;
import br.com.app.entidades.Resposta;
import br.com.app.form.FrmResposta;
import java.util.List;
import javax.swing.JOptionPane;

public class CadastroRespostaController {

    private static CadastroRespostaController instancia = new CadastroRespostaController();
    private FrmResposta view;
    private Resposta resposta = new Resposta();

    public static CadastroRespostaController getInstancia() {
        return instancia;
    }

    public void salvar() {
        view.pegandoDadosDoFormEnviandoEntidade(resposta);

        if(resposta.getProfessor()==null){
            JOptionPane.showMessageDialog(null, "O cadastro nÃ£o foi realizado pois contem erros!");
        }else{
        if (resposta.getId() == null) {
            new RespostaDao().salvar(resposta);
           JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");  
        }
    }
    }

    public void atualizar() {
        view.pegandoDadosDoFormEnviandoEntidade(resposta);
        if (resposta.getId() != null) {
            new RespostaDao().update(resposta);
        }
    }

    public void remover() {
        view.pegandoDadosDoFormEnviandoEntidade(resposta);
        if (resposta.getId() != null) {
            new RespostaDao().apagar(resposta);
        }
    }

    public void procurar() {
        view.pegandoDadosDoFormEnviandoEntidade(resposta);
        if (resposta.getId() != null) {
            new RespostaDao().procurar(resposta);
        }
    }

    public List<Professor> listaProfessoresCadastados() {
        return CadastroProfessorController.getInstancia().listar();
    }

    public void exibirInterfaceGrafica() {
        if (view == null) {
            view = new FrmResposta(this);
        }
        view.setVisible(true);
    }
}