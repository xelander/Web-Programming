package com.didacusabella.cdmodule;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author diego Remote interface for method calls
 */
@Remote
public interface CdEjbRemote {

  List<Cd> findAllCds();

  Cd createCd(Cd cd);

  Cd updateCd(Cd cd);

  void deleteCd(Cd cd);

  List<Cd> findForAuthor(String author);

  List<Cd> findForId(String id);

  Cd updatePrice(String id, double value);
}
