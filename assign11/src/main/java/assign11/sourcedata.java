package assign11;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



public class sourcedata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
        List<laptop> li=new ArrayList<>();
        li.add(new laptop(1,"lg","4gbram"));
        li.add(new laptop(2,"sony","8gbram"));
        li.add(new laptop(3,"hpp","16gbram"));
        li.add(new laptop(4,"dell","4gbram"));
        
        for(laptop o:li) {
        	try {
        	 if(o.getType()=="lg"||o.getType()=="sony"||o.getType()=="hp"||o.getType()=="dell") {
        		 session.save(o);
             }
        	 else {
        		 throw new Exception("Entered type is invalid for id="+o.getId());
        	 }
        	}catch(Exception e) {
        		System.out.print(e.getMessage());
        	}
        }
		session.getTransaction().commit();
		session.close();
	}

}
