package be.odisee.Lucychang2;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdminAuthenticatedAddOnePersonTest extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8088/");
		selenium.start();
	}

	@Test
	public void testAdminAuthenthicatedAddOnePerson() throws Exception {
		selenium.open("/lucychangrestaurant/login.html");
		selenium.type("username", "hans.vandenbogaerde@gmail.com");
		selenium.type("password", "geheim");
		selenium.click("submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Administrator"));
		selenium.click("link=Administrator");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Lijst van de personen"));
		selenium.click("link=Persoon Toevoegen");
		selenium.waitForPageToLoad("30000");
		selenium.type("voornaam", "Roger");
		selenium.type("familienaam", "Waters");
		selenium.type("emailadres", "roger.waters@");
		selenium.click("submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Vul een geldig e-mail adres in"));
		assertTrue(selenium.isTextPresent("Paswoord is minstens 6 letters aub"));
		selenium.type("emailadres", "roger.waters@pinkfloyd.co.uk");
		selenium.type("paswoord", "meddle");
		selenium.click("submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("E-mailadres: roger.waters@pinkfloyd.co.uk"));
		selenium.click("link=Admin Home");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Roger Waters"));
		selenium.click("link=Menu");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Facilitator in brainstormsessie een eerste brainstormsessie"));
		selenium.click("link=Facilitator in brainstormsessie een eerste brainstormsessie");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Hans Vandenbogaerde, u speelt de rol van Facilitator in brainstormsessie een eerste brainstormsessie"));
		selenium.click("css=input[type=\"submit\"]");  // hiermee clickt u op de "logout"-button
		selenium.waitForPageToLoad("30000");      
		assertTrue(selenium.isTextPresent("Bedankt om te brainstormen"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
