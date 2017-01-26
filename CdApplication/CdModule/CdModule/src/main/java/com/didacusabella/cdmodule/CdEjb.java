package com.didacusabella.cdmodule;

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
public class CdEjb implements CdEjbRemote {

  @Inject
  private EntityManager em;

  @Override
  public List<Cd> findAllCds() {
    TypedQuery<Cd> list = em.createNamedQuery("FIND-ALL", Cd.class);
    return list.getResultList();
  }

  @Override
  public Cd createCd(Cd cd) {
    em.persist(cd);
    return cd;
  }

  @Override
  public Cd updateCd(Cd cd) {
    return em.merge(cd);
  }

  @Override
  public void deleteCd(Cd cd) {
    em.remove(em.merge(cd));
  }

  @Override
  public List<Cd> findForAuthor(String author) {
    TypedQuery<Cd> query = em.createQuery("SELECT cd FROM Cd cd WHERE cd.author=?1", Cd.class);
    query.setParameter(1, author);
    return query.getResultList();
  }

  @Override
  public List<Cd> findForId(String id) {
    TypedQuery<Cd> query = em.createQuery("SELECT cd FROM Cd cd WHERE cd.id=?1", Cd.class);
    query.setParameter(1, id);
    return query.getResultList();
  }

  @Override
  public Cd updatePrice(String id, double value) {
    Cd query = em.find(Cd.class, id);
    query.setPrice(value);
    return updateCd(query);
  }

}
