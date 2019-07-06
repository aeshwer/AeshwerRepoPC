package PostConstructViaGuiceCustomImplementation;

import com.google.inject.AbstractModule;

import PostConstructImplementation.PostConstructObjectMatcher;
import PostConstructImplementation.PostConstructObjectTypeListener;

public class ApplicationModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(IMessage.class).to(Message.class);
		this.bindListener(new PostConstructObjectMatcher(), new PostConstructObjectTypeListener());
	}

}
