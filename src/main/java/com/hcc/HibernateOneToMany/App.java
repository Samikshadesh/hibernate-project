package com.hcc.HibernateOneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Configuration cf= new Configuration();
        cf.configure("com/hcc/hibernateOneToMany/hibernate.cfg.xml");
        SessionFactory factory= cf.buildSessionFactory();
        
//        Question q1= new Question();
//        q1.setQuestionId(12);
//        q1.setQuestion("What is java?");
//        
//        
//        Answer a1= new Answer();
//        a1.setAnswerId(32);
//        a1.setAnswer("Java id oop language");
//        a1.setQuestion(q1);
//        
//        Answer a2= new Answer();
//        a2.setAnswerId(31);
//        a2.setAnswer("Java is robust,secure programming language");
//        a2.setQuestion(q1);
//       
//        Answer a3= new Answer();
//        a3.setAnswerId(33);
//        a3.setAnswer("Java concurrent programming language");
//        a3.setQuestion(q1);
//       
//        List<Answer>list=new ArrayList<Answer>();
//        list.add(a3);
//        list.add(a1);
//        list.add(a1);
//        
//        q1.setAnswers(list);
//        
        Session session = factory.openSession();
        Transaction tx=session.beginTransaction();
//        session.save(q1);
//        session.save(a1);
//        session.save(a2);
//        session.save(a3);
//        
        
       //fetching data 
        Question q=(Question)session.get(Question.class,12);
        
        System.out.println(q.getQuestion());
        
        for(Answer a:q.getAnswers())
        {
        	System.out.println(a.getAnswer());
        }
        
        tx.commit();
        session.close();
        factory.close();
        
    }
}
