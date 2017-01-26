package com.didacusabella.studentejb;


import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Loggable
public class LoggerInterceptor {
    
   //@Inject @Default
   //private Logger logger;
    
    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception{
        System.out.println(ic.getTarget().getClass().getName()+" "+ic.getMethod().getName());
        try{
             return ic.proceed();
        }finally{
            System.out.println(ic.getTarget().getClass().getName()+" "+ic.getMethod().getName());
        }
    }

}
