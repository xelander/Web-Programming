/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.didacusabella.clientweb;

import java.util.List;
import javax.xml.ws.WebServiceRef;

public class ClientWeb {
    
    @WebServiceRef
    private static StudentService service = new StudentService();
    
    
    public static void main(String[] args){
        StudentEJB ejb = service.getStudentPort();
        List<Student> list = ejb.getStudents();
        for(Student x : list){System.out.println(x);}
    }

}
