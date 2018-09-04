/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.dsw.webservice;

import br.udesc.ceavi.dsw.model.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author GUSTAVO JUNG
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }
    
    public List<Veiculo> findCor(String cor) {
        Query query = getEntityManager().createQuery("SELECT v FROM Veiculo v WHERE v.cor = :cor");
        query.setParameter("cor",cor); 
        return query.getResultList();
    }
    
    public List<Veiculo> findMotor(double motor) {
        Query query = getEntityManager().createQuery("SELECT v FROM Veiculo v WHERE v.motor = :motor");
        query.setParameter("motor",motor); 
        return query.getResultList();
    }
    
     public List<Veiculo> findQuilometragem(int quilometragem) {
        Query query = getEntityManager().createQuery("SELECT v FROM Veiculo v WHERE v.quilometragem = :quilometragem");
        query.setParameter("quilometragem",quilometragem); 
        return query.getResultList();
    }
    
     public List<Veiculo> findTipo(String tipo) {
        Query query = getEntityManager().createQuery("SELECT v FROM Veiculo v WHERE v.tipo = :tipo");
        query.setParameter("tipo",tipo); 
        return query.getResultList();
    } 
      public List<Veiculo> findTipoeCor(String tipo,String cor) {
        Query query = getEntityManager().createQuery("SELECT v FROM Veiculo v WHERE v.tipo = :tipo  and v.cor=:cor");
        query.setParameter("tipo",tipo);
        query.setParameter("cor",cor);
        return query.getResultList();
    }
    
      public List<Veiculo> findTipoeQuilometragem(String tipo, int quilometragem){
         Query query = getEntityManager().createQuery("SELECT v FROM Veiculo v where v.tipo =:tipo and v.quilometragem=:quilometragem");
         query.setParameter("tipo", tipo);
         query.setParameter("quilometragem",quilometragem);
         return query.getResultList();
      }
      
      public List<Veiculo> findTipoeMotor(String tipo, double motor){
         Query query = getEntityManager().createQuery("SELECT v FROM Veiculo v where v.tipo =:tipo and v.motor=:motor");
         query.setParameter("tipo", tipo);
         query.setParameter("motor",motor);
         return query.getResultList();
      }
      
      public List<Veiculo> motorMaximo(double valorMaximo){
          Query query = getEntityManager().createQuery("SELECT v FROM Veiculo v where v.motor< :valorMaximo");
          query.setParameter("valorMaximo", valorMaximo);
          return query.getResultList();
      }
      
      public List<Veiculo> motorMinimo(double valorMinimo){
          Query query = getEntityManager().createQuery("SELECT v FROM Veiculo v where v.motor> :valorMinimo");
          query.setParameter("valorMinimo", valorMinimo);
          return query.getResultList();
      }
      
      
      public List<Veiculo> quilometragemMaxima(int valorMaximo){
          Query query = getEntityManager().createQuery("SELECT v FROM Veiculo v where v.quilometragem < :valorMaximo");
          query.setParameter("valorMaximo", valorMaximo);
          return query.getResultList();
      }
      
      public List<Veiculo> quilometragemMinima(int valorMinimo){
          Query query = getEntityManager().createQuery("SELECT v FROM Veiculo v where v.quilometragem > :valorMinimo");
          query.setParameter("valorMinimo", valorMinimo);
          return query.getResultList();
      }                  
      
      public List<Veiculo> findTipoeMontadora(String tipo,String nome){
          Query query = getEntityManager().createQuery("SELECT v FROM Veiculo v LEFT JOIN v.montadora m WHERE v.tipo=:tipo and m.nome =:nome");
          query.setParameter("tipo",tipo);
          query.setParameter("nome",nome);
          return query.getResultList();
      }
      
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List<Veiculo> findModelo(String nome) {
         Query query = getEntityManager().createQuery("SELECT v FROM Veiculo v LEFT JOIN v.modelo m WHERE m.nome =:nome");
          query.setParameter("nome",nome);
          return query.getResultList();
    }

   public List<Veiculo> findMontadora(String nome) {
          Query query = getEntityManager().createQuery("SELECT v FROM Veiculo v LEFT JOIN v.montadora m WHERE  m.nome =:nome");
          query.setParameter("nome",nome);
          return query.getResultList();
    
    }
    
}
