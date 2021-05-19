package ChromeBrowser;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestCase {

	static WebDriver driver;
	
	@BeforeClass
	public static void BrowserOpen()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://booking.com/");
	}
	
	@AfterClass
	public static void BrowserClose()
	{
		driver.quit();
	}
	
	@After
	public void tearDown()
	{
		driver.navigate().to("https://www.booking.com/index.en-gb.html?label=gen173nr-1FCAEoggI46AdIM1gEaA-IAQGYAQm4ARfIAQzYAQHoAQH4AQuIAgGoAgO4As3tjoUGwAIB0gIkYmUzNWM0MzAtMTJhYi00YjhmLWJkMjYtZDIyNDczNmE0ZmYw2AIG4AIB&sid=2f877879db177a3a2e5bddc326241ed5&srpvid=3320622d6560007c&click_from_logo=1");
	}
	
	@Test
	public void testForAreaBySym()//This is test for entering the symbol
	{
		driver.findElement(By.id("ss")).sendKeys("@#!@#");
		driver.findElement(By.id("ss")).submit();
		String text = driver.findElement(By.id("ss")).getAttribute("value");
		assertEquals(text, "");
	}
	
	@Test
	public void testForAreaByAbv()//This is test for entering the abbreviation of location name
	{
		driver.findElement(By.id("ss")).sendKeys("Mel");
		driver.findElement(By.id("ss")).submit();
		String text = driver.findElement(By.id("ss")).getAttribute("value");
		assertEquals(text,"Melbourne CBD");
		
	}
	
	@Test
	public void testForAreaByInt()//This is test for entering the int
	{
		driver.findElement(By.id("ss")).sendKeys("12314");
		driver.findElement(By.id("ss")).submit();
		String text = driver.findElement(By.id("ss")).getAttribute("value");
		assertEquals(text,"");
		
	}
	
	@Test
	public void testForAreaByDouble()//This is test for entering the double
	{
		driver.findElement(By.id("ss")).sendKeys("12314.123123");
		driver.findElement(By.id("ss")).submit();
		String text = driver.findElement(By.id("ss")).getAttribute("value");
		assertEquals(text,"");
		
	}
	
	@Test
	public void testForAreaByWrongName()//This is test for entering the wrong name
	{
		driver.findElement(By.id("ss")).sendKeys("Meebourne");
		driver.findElement(By.id("ss")).submit();
		String text = driver.findElement(By.id("ss")).getAttribute("value");
		assertEquals(text,"Meebourne");
	}
	
	@Test
	public void testForOnlyEnterDate()
	{
		driver.findElement(By.className("xp__dates__checkin")).click();
		driver.findElement(By.cssSelector("td.bui-calendar__date[data-date='2021-05-15']")).click();
		driver.findElement(By.cssSelector("td.bui-calendar__date[data-date='2021-05-18']")).click();
		driver.findElement(By.cssSelector("td.bui-calendar__date[data-date='2021-05-18']")).submit();;
		String url = driver.getCurrentUrl();
		assertEquals(url,"https://www.booking.com/index.en-gb.html?label=gen173nr-1FCAEoggI46AdIM1gEaA-IAQGYAQm4ARfIAQzYAQHoAQH4AQuIAgGoAgO4As3tjoUGwAIB0gIkYmUzNWM0MzAtMTJhYi00YjhmLWJkMjYtZDIyNDczNmE0ZmYw2AIG4AIB&sid=2f877879db177a3a2e5bddc326241ed5&srpvid=3320622d6560007c&click_from_logo=1");
	}

}