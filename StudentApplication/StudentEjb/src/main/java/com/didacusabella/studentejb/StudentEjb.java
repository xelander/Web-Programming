package com.didacusabella.studentejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author diego
 */
@Stateless
@Loggable
@WebService(serviceName = "StudentService", portName = "studentPort")
public class StudentEjb implements StudentEjbRemote {
    
    @Inject
    private EntityManager em;

    
    @Override
    public Student createStudent(Student aStudent) {
        em.persist(aStudent);
        return aStudent;
    }

    @Override
    public Student updateStudent(Student astudent) {
        return em.merge(astudent);
    }

    @Override
    public void removeStudent(Student aStudent) {
        em.remove(em.merge(aStudent));
    }

    @Override
    public List<Student> findForLastName(String lastName) {
       TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE s.lastName=?1", Student.class);
       query.setParameter(1, lastName);
       return query.getResultList();
    }

    @Override
    @WebMethod(operationName = "getStudents")
    public List<Student> findAllStudent() {
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }

    @Override
    public Student updateNumberOfExams(int number, String id) {
        Student st = em.find(Student.class, id);
        st.setNumberOfExams(number);
        return st;
    }

    @Override
    public List<Student> findForId(String id) {
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE s.id=?1", Student.class);
        query.setParameter(1, id);
        return query.getResultList();
    }

    
}
