package org.xsalefter.example.weld.injection.test;

import javax.inject.Inject;

import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xsalefter.example.weld.injection.SimpleInjection;
import org.xsalefter.example.weld.ref.domain.Person;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
@RunWith(Arquillian.class)
public class SimpleInjectionTest {
	
	@Inject
	private SimpleInjection simpleInjection;
	
	
	@Deployment
	public static JavaArchive createJAR() {
		return ShrinkWrap.create(JavaArchive.class, "injection-example.jar").
				addClass(SimpleInjection.class).
				addAsManifestResource(
						EmptyAsset.INSTANCE, 
						ArchivePaths.create("beans.xml"));
	}
	
	@Test
	public void testDefaultPersonsInjectionPoint() {
		Person injectedPerson = this.simpleInjection.getPerson();
		Assert.assertEquals(injectedPerson.getId(), new Long(0L));
		Assert.assertEquals(injectedPerson.getName(), "I'm created automatically");
		Assert.assertEquals(injectedPerson.getEmail(), "inject@ion.com");
		Assert.assertEquals(injectedPerson.getAddresses().size(), 1);
	}
}
