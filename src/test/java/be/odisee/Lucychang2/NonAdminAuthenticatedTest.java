package be.odisee.Lucychang2;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class NonAdminAuthenticatedTest extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testNonAdminAuthenthicated() throws Exception {
		selenium.open("/brainstorm2015WA3/login.html");
		selenium.type("username", "roos.vanacker@gmail.com");
		selenium.type("password", "verkeerd");
		selenium.click("submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Boodschap: Bad credentials"));
		selenium.type("username", "roos.vanacker@gmail.com");
		selenium.type("password", "geheim");
		selenium.click("submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Welkom Roos Vanacker, kies uw rol aub:"));
		selenium.click("link=Deelnemer in brainstormsessie een eerste brainstormsessie");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Roos Vanacker, u speelt de rol van Deelnemer in brainstormsessie een eerste brainstormsessie"));
		selenium.open("/brainstorm2015WA3/rol.html?id=1");
		assertTrue(selenium.isTextPresent("Oeps! Dit mag je niet doen"));
		selenium.open("/brainstorm2015WA3/rol.html?id=4");
		assertTrue(selenium.isTextPresent("Oeps! Dit mag je niet doen"));
		selenium.open("/brainstorm2015WA3/rol.html?id=6");
		assertTrue(selenium.isTextPresent("Roos Vanacker, u speelt de rol van Deelnemer in brainstormsessie een eerste brainstormsessie"));
		selenium.click("css=input[type=\"submit\"]");  // hiermee clickt u op de "logout"-button
		selenium.waitForPageToLoad("30000");      
		assertTrue(selenium.isTextPresent("Bedankt om te brainstormen"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
