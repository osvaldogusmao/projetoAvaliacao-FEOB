package br.com.app.infraestrutura;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author osvaldo
 */
public class EntityFactory {

    private EntityManagerFactory factory;
    private EntityManager manager;
    
    public EntityFactory() {
        this. factory = Persistence.createEntityManagerFactory("ProjetoAvaliacao");
    }
    
    public EntityManager getInstance(){
        
        if(manager == null){
            manager = factory.createEntityManager();
        }
        return manager;
    }

}
