package br.com.app.dao;

import br.com.app.entidades.Resposta;
import br.com.app.infraestrutura.EntityFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class RespostaDao {

    private EntityManager manager;

    public RespostaDao() {

        this.manager = new EntityFactory().getInstance();

    }

    public Resposta salvar(Resposta resp) {

        Resposta resposta = null;
        EntityTransaction transaction = this.manager.getTransaction();
        transaction.begin();
        resposta = manager.merge(resp);
        transaction.commit();
        return resposta;

    }

    public void apagar(Resposta resp) {

        Resposta resposta = null;
        EntityTransaction transaction = this.manager.getTransaction();
        transaction.begin();
        resposta = manager.find(Resposta.class, resp.getId());
        manager.remove(resposta);
        transaction.commit();

    }

    public void update(Resposta resp) {
        EntityTransaction transaction = this.manager.getTransaction();
        transaction.begin();
        manager.merge(resp);
        transaction.commit();

    }

    public Resposta procurar(Resposta resp) {

        Resposta resposta = null;
        EntityTransaction transaction = this.manager.getTransaction();
        transaction.begin();
        resposta = manager.find(Resposta.class, resp.getId());
        transaction.commit();

        return resposta;
    }

    public List<Resposta> listar() {

        EntityTransaction transaction = this.manager.getTransaction();   
        transaction.begin();
        Query query = manager.createQuery("from Resposta");
        List<Resposta> respostas = query.getResultList();
        transaction.commit();
 
        return respostas;
    }
    
    public List<Resposta> listaResposta(Long idProfessor){
        
        String queryString = "from Resposta where  professor_id = :id ";
        
        Query query = manager.createQuery(queryString);
       return  query.setParameter("id", idProfessor).getResultList();
    
    }
    


}
