package br.com.app.testes;

import javax.persistence.EntityManager;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import br.com.app.dao.ProfessorDAO;
import br.com.app.entidades.Professor;
import br.com.app.infraestrutura.EntityFactory;

/**
 *
 * @author osvaldo
 */
public class ProfessorTeste {

    private EntityManager manager;
    
    public ProfessorTeste() {
        this.manager = new EntityFactory().getInstance();
        this.testSalva();
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
    
}
