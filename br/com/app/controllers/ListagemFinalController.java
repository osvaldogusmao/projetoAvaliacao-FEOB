package br.com.app.controllers;

import br.com.app.form.FrmListagemFinal;


public class ListagemFinalController {
    
    private FrmListagemFinal view;
    
    public void exibirInterface(){
        if (view == null) {
            view = new FrmListagemFinal();
        }
        
        view.setVisible(true);
    }
    
    
    
    
}