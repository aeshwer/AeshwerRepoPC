package TradingAppilcation.TradingAppilcation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.cfg.Configuration;

import com.google.inject.Guice;
import com.google.inject.Injector;

import Business.TradePricingCalculation;
import Domain.DummyTradeCreator;
import Domain.Trade;
import Domain.TradeDomainToPersistableMapper;
import PersistableEntity.TradeDAO;
/**
 * Hello world!
 *
 */
public class App
{
	
	public static void main( String[] args )
	{
		Injector injector = Guice.createInjector(new ApplicationModule());
		DummyTradeCreator dummyTrade = new DummyTradeCreator(injector.getInstance(Trade.class));
		
		TradePricingCalculation tradePricingCalculation = new TradePricingCalculation(dummyTrade.CreatedummyTrade());
		TradeDomainToPersistableMapper mapper = new TradeDomainToPersistableMapper(dummyTrade.CreatedummyTrade(), tradePricingCalculation);

		TradeDAO dao = new TradeDAO(mapper.DomainToPersistableMapper());
		dao.PeristTrade();
/*
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(mapper.DomainToPersistableMapper());
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();*/
	}
}
