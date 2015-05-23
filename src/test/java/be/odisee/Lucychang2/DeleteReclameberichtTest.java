package be.odisee.Lucychang2;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeleteReclameberichtTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testDeleteTutorial() throws Exception {
		selenium.open("/NetflixDB/");
		assertTrue(selenium.isElementPresent("link=Mijntitel2"));
		selenium.click("link=Mijntitel2");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Delete");
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isElementPresent("link=Mijntitel2"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
