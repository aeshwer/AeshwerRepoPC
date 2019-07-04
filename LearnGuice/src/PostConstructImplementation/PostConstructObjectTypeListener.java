package PostConstructImplementation;

import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

public class PostConstructObjectTypeListener implements TypeListener {

	@Override
	public <I> void hear(TypeLiteral<I> typeLiteral, TypeEncounter<I> encounter) {
		encounter.register(new PostConstructObjectInjectionListener<>());
	}

}
