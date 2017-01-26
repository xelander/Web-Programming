package com.didacusabella.studentejb;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author diego
 */
@Remote
public interface StudentEjbRemote {

  Student createStudent(Student aStudent);

  Student updateStudent(Student astudent);

  void removeStudent(Student aStudent);

  List<Student> findForLastName(String lastName);

  List<Student> findAllStudent();

  Student updateNumberOfExams(int number, String id);

  List<Student> findForId(String id);

}
