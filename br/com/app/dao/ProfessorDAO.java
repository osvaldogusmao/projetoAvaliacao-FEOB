package br.com.app.dao;

import br.com.app.entidades.Professor;
import br.com.app.entidades.Resposta;
import br.com.app.infraestrutura.EntityFactory;
import com.sun.org.glassfish.external.probe.provider.annotations.Probe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/*
 *
 * @author osvaldo
 */
public class ProfessorDao {

    private EntityManager manager;
    
    public ProfessorDao() {
        this.manager = new EntityFactory().getInstance();
    }
    
    public Professor salva(Professor professor){

        Professor salvo = null;        
        
        EntityTransaction transaction =    manager.getTransaction();
        transaction.begin();
        salvo = manager.merge(professor);
        transaction.commit();

        return salvo;
        
    }
    
    public void remove(Professor professor){
        
        professor = manager.find(Professor.class, professor.getId());
        
        EntityTransaction transaction =    manager.getTransaction();
        transaction.begin();
        manager.remove(professor);
        transaction.commit();
        
    }

    public void atualiza(Professor professor){
        
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(professor);
        transaction.commit();
        
    }
    
    public List<Professor> lista(){
        return manager.createQuery("from Professor").getResultList();
    }
    
    public List<Resposta> listaPorNome(String nome){
        String queryString  = "from Resposta r join fetch r.professor p where p.nome like :nome";
        Query query  = manager. createQuery(queryString);
        query.setParameter( "nome",  "%"+ nome +"%");
        return query.getResultList();
    }
    
}