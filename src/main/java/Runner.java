import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import java.util.List;

public class Runner {
	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry
				= new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml")
				.build();

		MetadataSources metadataSources = new MetadataSources(serviceRegistry);
		metadataSources.addAnnotatedClass(Country.class);
		metadataSources.addAnnotatedClass(Actor.class);

		MetadataBuilder metadataBuilder = metadataSources.getMetadataBuilder();
		metadataBuilder.applyPhysicalNamingStrategy(new CamelCaseToUnderscoreNamingStrategy());

		SessionFactory sessionFactory = metadataBuilder.build().buildSessionFactory();

		try(Session session = sessionFactory.openSession()) {
			EntityManager entityManager = session.unwrap(EntityManager.class);
			Transaction transaction = session.beginTransaction();
			List<Actor> actors = entityManager.createQuery("from Actor", Actor.class).getResultList();
			System.out.println(actors);
			transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
