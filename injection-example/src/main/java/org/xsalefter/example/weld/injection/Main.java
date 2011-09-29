package org.xsalefter.example.weld.injection;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.StartMain;
import org.jboss.weld.environment.se.events.ContainerInitialized;

/**
 * You could see that this class as a main class with <pre>public static void 
 * main(String[] args)</pre> method in traditional Java SE application.
 * 
 * @author xsalefter (xsalefter@gmail.com)
 *
 */
public class Main {
	
	/***
	 * Just @{@link Inject} the bean would call method {@link SimpleInjectionTest#run()} 
	 * automatically. Why? Because the method annotated with @{@link PostConstruct}
	 * annotation.
	 */
	@Inject
	SimpleInjection simpleInjection;

	/**
	 * In SE application, @{@link Observes} {@link ContainerInitialized} e is a 
	 * requirement to "mark" your class as a main class. But to run the Weld-SE 
	 * application, you need to call {@link StartMain} instead.
	 */
	public void main(@Observes ContainerInitialized event) {
		// We simple don't need this, but keep it here to make me understand 
		// better. If you un-comment this out, the method will called twice: 
		// By the container and direct invocation it self.
		// this.simpleInjection.run();
		
		
		this.simpleInjection.registerAddressToPerson();
	}
}
