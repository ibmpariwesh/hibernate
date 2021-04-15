package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Application {
	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		demo1(sessionFactory);

//		Session session1 = sessionFactory.openSession();
//		Employee e2 = session1.find(Employee.class, 1);
//		Account account1 = e2.getAccount();
//		System.out.println(account1.getNumber());
////		System.out.println(account.getEmployee().getName());
	}

	private static void demo1(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee e1 = new Employee();// transient
		e1.setName("Pariwesh");
		Account account = new Account();
		account.setNumber(354646);
//		account.setEmployee(e1);
		e1.setAccount(account);
		session.save(e1);
//		session.save(account);
		session.getTransaction().commit();
		session.close();
	}
}
