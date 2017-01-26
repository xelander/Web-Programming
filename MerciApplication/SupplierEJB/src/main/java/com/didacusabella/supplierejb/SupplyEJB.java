package com.didacusabella.supplierejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author diego
 */
@Stateless
@Loggable
public class SupplyEJB implements SupplyEJBRemote {

  @Inject
  private EntityManager em;

  @Override
  public Supply createSupply(Supply s) {
    em.persist(s);
    return s;
  }

  @Override
  public Supply updateSupply(Supply s) {
    return em.merge(s);
  }

  @Override
  public void removeSupply(Supply s) {
    em.remove(em.merge(s));
  }

  @Override
  public List<Supply> findAll() {
    TypedQuery<Supply> query = em.createQuery("SELECT s FROM Supply s", Supply.class);
    return query.getResultList();
  }

  @Override
  public List<Supply> findForName(String name) {
    TypedQuery<Supply> query = em.createQuery("SELECT s FROM Supply s WHERE s.name=?1", Supply.class);
    query.setParameter(1, name);
    return query.getResultList();
  }

  @Override
  public List<Supply> findForlastName(String lastName) {
    TypedQuery<Supply> query = em.createQuery("SELECT s FROM Supply s WHERE s.lastName=?1", Supply.class);
    query.setParameter(1, lastName);
    return query.getResultList();
  }

  @Override
  public Supply findForId(int id) {
    Supply s = em.find(Supply.class, id);
    return s;
  }

  @Override
  public List<Supply> findForOrder(int maxOrder) {
    TypedQuery<Supply> query = em.createQuery("SELECT s FROM Supply s WHERE s.maxOrder>=?1", Supply.class);
    query.setParameter(1, maxOrder);
    return query.getResultList();
  }

  @Override
  public Supply order(int id) {
    Supply s = em.find(Supply.class, id);
    int value = s.getTotalOrder() + 1;
    s.setTotalOrder(value);
    return s;
  }

}
