/* NOTE:
 * getDeclaredMethods includes all methods declared by the class itself, whereas getMethods returns only public methods, 
 * but also those inherited from a base class (here from java.lang.Object).
 */

package PostConstructImplementation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.google.inject.spi.InjectionListener;

public class PostConstructObjectInjectionListener<I> implements InjectionListener<I> {

	@Override
	public void afterInjection(I injectee) {
		
		try {
		final Method[] declaredMethods = injectee.getClass().getDeclaredMethods();
		final Method[] methods = injectee.getClass().getMethods();
		
		List<Method> allMethodsList = new ArrayList<>(Arrays.asList(methods));
		allMethodsList.addAll(Arrays.asList(declaredMethods));
		
		//removed duplicates method 
		final Set<Method> allMethods = new HashSet<>(allMethodsList);
		
		//Iterate on all methods to scan for PostConstruct annotation and if found invoke that method
		 for (final Method method : allMethods) {
			  final PostConstruct postConstructAnnotation = method.getAnnotation(PostConstruct.class);
			  if (postConstructAnnotation != null) {
				  // Need PostConstruct method to be public otherwise post construct will not work.
					method.invoke(injectee);
		          break;
			  }
		 }
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
