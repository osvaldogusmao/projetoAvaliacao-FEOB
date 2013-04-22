package br.com.app.dao;

import br.com.app.entidades.Professor;
import br.com.app.infraestrutura.EntityFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/*
 *
 * @author osvaldo
 */
public class ProfessorDAO {

    private EntityManager manager;
    
    public ProfessorDAO() {
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
    
    public List<Professor> listaPorNome(String nome){
        
        String queryString  = "from Professor where nome like :nome";
        
        Query query  = manager. createQuery(queryString);
        query.setParameter( "nome",  "%"+ nome +"%");
        return query.getResultList();
        
    }
    
    
}
