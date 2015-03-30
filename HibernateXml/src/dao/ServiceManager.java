package dao;

import metier.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class ServiceManager {

		// attribut
		static SessionFactory sessionFactory;
		// constructeur sans argument
		public ServiceManager(){

		}

		public static Service save(Service service) {

				// TODO Auto-generated method stub
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
				Service serviceSauve = null;
				Session s = sessionFactory.openSession();
				Transaction tx = null;
				try {
					tx = s.beginTransaction();
					s.save(service);
					tx.commit();
					serviceSauve = service;
					
				} catch (Exception e) {
					// TODO: handle exception
					if (tx != null)
						tx.rollback();
					// throw e;
					e.printStackTrace();
				} finally {
					s.close();
					sessionFactory.close();
				}
				return serviceSauve;
		}
		public static Service get(int id) {

			// TODO Auto-generated method stub
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Service service = null;
			Session s = sessionFactory.openSession();
			//Service service = new Service();
			
			try {

				service= (Service) s.get(Service.class, id);

				
			} catch (Exception e) {
				// TODO: handle exception
				// throw e;
				e.printStackTrace();
			} finally {
				s.close();
				sessionFactory.close();
				
			}
			return service;
		}
	

}
