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
		insert(sessionFactory);
		readEmployee(sessionFactory);
//		deleteEmpWithAccount(sessionFactory);
//		Session session1 = sessionFactory.openSession();
//		Employee e2 = session1.find(Employee.class, 1);
//		Account account1 = e2.getAccount();
//		System.out.println(account1.getNumber());
////		System.out.println(account.getEmployee().getName());
	}

	private static void readEmployee(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee e1 = session.find(Employee.class, 1);
		System.out.println(e1.getName());
		session.getTransaction().commit();
		session.close();		
	}

	private static void deleteEmpWithAccount(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee e2 = new Employee();
		e2.setId(1);
		session.delete(e2);
		session.getTransaction().commit();
		session.close();
	}

	private static void insert(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee e1 = new Employee();// transient
		e1.setName("Pariwesh");
		Account account = new Account();
		account.setNumber(354646);
		account.setEmployee(e1);
//		e1.setAccount(account);
//		session.save(e1);//owner
		session.save(account);
		session.getTransaction().commit();
		session.close();
	}
}
