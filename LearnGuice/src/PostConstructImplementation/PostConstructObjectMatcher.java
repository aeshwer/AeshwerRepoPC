package PostConstructImplementation;

import com.google.inject.TypeLiteral;
import com.google.inject.matcher.AbstractMatcher;

public class PostConstructObjectMatcher extends AbstractMatcher<TypeLiteral<?>> {

	@Override
	public boolean matches(TypeLiteral<?> typeLiteral) {
		return PostConstructObject.class.isAssignableFrom(typeLiteral.getRawType());
	}
}
