package br.com.app.controllers;

import br.com.app.dao.ProfessorDAO;
import br.com.app.entidades.Professor;
import br.com.app.form.FrmProfessor;
import java.util.List;

public class CadastroProfessorController {
    
    private static CadastroProfessorController instancia = new CadastroProfessorController();
    private FrmProfessor view;
    private Professor professor = new Professor();
    
    public static CadastroProfessorController getInstancia() {
        return instancia;
    }
    
    public void salvar() {
        view.sincronizarEntidadeComForm(professor);
        if (professor.getId() == null) {
            new ProfessorDAO().salva(professor);
        }
    }
    
    public void atualizar() {
        view.sincronizarEntidadeComForm(professor);
        if (professor.getId() != null) {
            new ProfessorDAO().atualiza(professor);
        }
    }
    
    public void remover() {
        view.sincronizarEntidadeComForm(professor);
        if (professor.getId() != null) {
            new ProfessorDAO().remove(professor);
        }
    }
    
    public List listar() {
        List<Professor> lista = new ProfessorDAO().lista();
        return lista;
    }
    
    public void listarPorNome(String nome) {
            List<Professor> lista = new ProfessorDAO().listaPorNome(nome);
    }
    
    public void exibirInterfaceGrafica() {
        if (view == null) {
            view = new FrmProfessor(this);
        }
        view.setVisible(true);
    }
}
