package SequenceGeneratorDesign;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

public class DraftIdStringAppenderGenerator extends SequenceStyleGenerator {

	private static String valuePrefix = "D";
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return valuePrefix + String.format("%d", super.generate(session, object));
	}
	
	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		super.configure(LongType.INSTANCE, params, serviceRegistry);
	}
	
	
}