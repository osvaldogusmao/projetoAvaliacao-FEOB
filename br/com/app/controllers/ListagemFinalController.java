package br.com.app.controllers;

import br.com.app.dao.ProfessorDao;
import br.com.app.entidades.Professor;
import br.com.app.entidades.Resposta;
import br.com.app.form.FrmListagemFinal;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ListagemFinalController {
    
    private FrmListagemFinal view;
    
    private static ListagemFinalController instancia = new ListagemFinalController();
    
    public static ListagemFinalController getInstancia() {
        return instancia;
    }
    
    public void exibirInterface(){
        if (view == null) {
            view = new FrmListagemFinal(this);
        }
        
        view.setVisible(true);
    }
    
    public List<Resposta> listaPorNome(String nome){
        
        ProfessorDao dao = new ProfessorDao();
        
        return  dao.listaPorNome(nome);
        
    }
    
   
}