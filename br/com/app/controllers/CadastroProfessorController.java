package br.com.app.controllers;

import br.com.app.dao.ProfessorDao;
import br.com.app.entidades.Professor;
import br.com.app.form.FrmProfessor;
import java.util.List;
import javax.swing.JOptionPane;

public class CadastroProfessorController {
    
    private static CadastroProfessorController instancia = new CadastroProfessorController();
    private FrmProfessor view;
    private Professor professor = new Professor();
    
    public CadastroProfessorController(){
    
    }
    
    public static CadastroProfessorController getInstancia() {
        return instancia;
    }
    
    public void salvar() {
        view.pegandoDadosDoFormEnviandoEntidade(professor);
        if (professor.getId() == null) {
            new ProfessorDao().salva(professor);
         JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        }
    }
    
    public void atualizar() {
        view.pegandoDadosDoFormEnviandoEntidade(professor);
        if (professor.getId() != null) {
            new ProfessorDao().atualiza(professor);
        }
    }
    
    public void remover() {
        view.pegandoDadosDoFormEnviandoEntidade(professor);
        if (professor.getId() != null) {
            new ProfessorDao().remove(professor);
        }
    }
    
    public List<Professor> listar() {
        List<Professor> lista = new ProfessorDao().lista();
        return lista;
    }
    
    public List<Professor> listarPorNome(String nome) {
            List<Professor> lista = new ProfessorDao().listaPorNome(nome);
            return  lista;
    }
    
    public void exibirInterfaceGrafica() { 
        if (view == null) {
            view = new FrmProfessor(this);
        }
        view.setVisible(true);
    }
    
    public void exibirFormRespostas(){
        CadastroRespostaController.getInstancia().exibirInterfaceGrafica();
    }
}