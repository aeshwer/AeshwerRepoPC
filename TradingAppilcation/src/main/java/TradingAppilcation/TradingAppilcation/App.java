package TradingAppilcation.TradingAppilcation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		Trade trade = new Trade();
		trade.setId("1");
		trade.setBuySellIndicator("Buy");
		trade.setPrice1(100);
		trade.setPrice2(200);

		/*  //creating configuration object  
	    Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	    //creating session factory object  
	    SessionFactory factory=cfg.buildSessionFactory();*/

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(trade);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
