package be.odisee.Lucychang2;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EditReclameberichtTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testChangeTutorial() throws Exception {
		selenium.open("/NetflixDB/");
		selenium.click("link=Mijntitel");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Edit");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=titel", "Mijntitel2");
		selenium.type("id=prombleemOmschrijving", "Mijnomschrijving2");
		selenium.type("id=status", "MijnStatus2");
		selenium.type("id=oplossing", "http://www.netflix.com/oplossing2");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("link=Mijntitel2"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
