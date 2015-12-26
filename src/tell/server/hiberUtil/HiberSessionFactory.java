package tell.server.hiberUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberSessionFactory {
	
    //private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
   // private  static Configuration configuration = new Configuration();    
    private static SessionFactory sessionFactory;
    
	static {
    	try {
    		Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
    }
	
    private HiberSessionFactory(){}
    
    //获取session
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();

		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession():null;
			threadLocal.set(session);
		}

        return session;
    }
    
    //重新建立session
	public static void rebuildSessionFactory() {
		try {
	 		Configuration configuration = new Configuration().configure();
		    sessionFactory = configuration.buildSessionFactory();
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}
    
	//关闭session
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }
}
