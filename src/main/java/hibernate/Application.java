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
//		session.save(e1); //makes it persistent
//		Employee employee = session.find(Employee.class, 1);
//		employee.setName("Ram");
//		System.out.println(employee.getName());
//		session.update(employee);
		session.getTransaction().commit();
		
	}
}
