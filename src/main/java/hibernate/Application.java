package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Application {
	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		
		SessionFactory sessionFactory  = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee e1 = new Employee();//transient
		e1.setName("Pariwesh");
		Account account = new Account();
		account.setNumber(354646);
		account.setEmployee(e1);
		session.save(e1);
		session.save(account);
		session.getTransaction().commit();
		
	}
}
