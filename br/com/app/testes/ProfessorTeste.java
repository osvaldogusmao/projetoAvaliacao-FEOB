package br.com.app.testes;

import javax.persistence.EntityManager;
import br.com.app.dao.ProfessorDAO;
import br.com.app.entidades.Professor;
import br.com.app.entidades.Resposta;
import br.com.app.infraestrutura.EntityFactory;
import java.util.List;

/**
 *
 * @author osvaldo
 */
public class ProfessorTeste {

    private EntityManager manager;
    
    public ProfessorTeste() {
        this.manager = new EntityFactory().getInstance();
       
        //this.testSalva();
        
        
        for (Resposta  r : testListResposta(1L)) {
            System.out.println(r.getTexto());
        }
        
    }

    
    
    public void testSalva(){
        
        Professor p = new Professor();
        
        p.setNome("José Osvaldo");
        p.setCpf("111.111.111-11");
        p.setTitulacao("ADS");
        
        ProfessorDAO dao = new ProfessorDAO();
       
        p =  dao.salva(p);
        
        if( p != null){
            System.out.println("Teste: Salva : Passou");
        }else{
            System.out.println("Teste: Salva :Não  Passou");
        }
    }
    
        public List<Professor> testLista(String nome){
            
            return new ProfessorDAO().listaPorNome(nome);
            //return new ProfessorDAO().lista();
        }
      
        
        public List<Resposta> testListResposta(Long idProfessor){
            
            return new ProfessorDAO().listaResposta(idProfessor);
            
        }
}
