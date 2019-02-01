import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;

public class Runner {
	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry
				= new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml")
				.build();

		MetadataSources metadataSources = new MetadataSources(serviceRegistry);
		metadataSources.addAnnotatedClass(Country.class);

		SessionFactory sessionFactory = metadataSources.buildMetadata().buildSessionFactory();

		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			// logic
			Country country = session.find(Country.class, 1L);
//			country.setCountry("Afganistan12");
//			country.setActive(false);
//			transaction.commit();
			System.out.println(country);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
