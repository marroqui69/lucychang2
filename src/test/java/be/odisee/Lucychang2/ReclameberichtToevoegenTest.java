package be.odisee.Lucychang2;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReclameberichtToevoegenTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testTutorialToevoegen() throws Exception {
		selenium.open("/NetflixDB/");
		selenium.click("link=Tutorial Toevoegen");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=titel", "Mijntitel");
		selenium.type("id=prombleemOmschrijving", "Hans zijn omschrijving");
		selenium.type("id=status", "MijnStatus");
		selenium.type("id=oplossing", "http://www.netflix.com/oplossing");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Titel: Mijntitel\n Probleembeschrijving:"
				+ " Hans zijn omschrijving\n status: MijnStatus\n oplossing: "
				+ "Oplossing link \n \n Edit Delete Home", 
				selenium.getText("css=div"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
