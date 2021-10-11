package ChromeBrowser;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;sdasds
sadsda
public class Launch {

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\Automation\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://booking.com/");
		Faker faker = new Faker();
		driver.findElement(By.id("ss")).sendKeys("Melbourne,Australia");
		driver.findElement(By.className("xp__dates__checkin")).click();
		driver.findElement(By.cssSelector("td.bui-calendar__date[data-date='2021-05-15']")).click();
		driver.findElement(By.cssSelector("td.bui-calendar__date[data-date='2021-05-18']")).click();
		driver.findElement(By.className("xp__guests__count")).click();
		driver.findElement(By.cssSelector("button.bui-button.bui-button--secondary.bui-stepper__add-button[aria-label='Increase number of Adults'")).click();
		driver.findElement(By.cssSelector("button.bui-button.bui-button--secondary.bui-stepper__add-button[aria-label='Increase number of Children'")).click();
		driver.findElement(By.cssSelector("button.bui-button.bui-button--secondary.bui-stepper__add-button[aria-label='Increase number of Rooms'")).click();
		driver.findElement(By.cssSelector("button.bui-button.bui-button--secondary.bui-stepper__add-button[aria-label='Increase number of Rooms'")).submit();

	}
	/*@Test
	public void testForNormalSearch() {
			driver.findElement(By.id("ss")).sendKeys("Melbourne,Australia");
			driver.findElement(By.className("xp__dates__checkin")).click();
			driver.findElement(By.cssSelector("td.bui-calendar__date[data-date='2021-05-15']")).click();
			driver.findElement(By.cssSelector("td.bui-calendar__date[data-date='2021-05-18']")).click();
			driver.findElement(By.className("xp__guests__count")).click();
			driver.findElement(By.cssSelector("button.bui-button.bui-button--secondary.bui-stepper__add-button[aria-label='Increase number of Adults'")).click();
			driver.findElement(By.cssSelector("button.bui-button.bui-button--secondary.bui-stepper__add-button[aria-label='Increase number of Children'")).click();
			driver.findElement(By.cssSelector("button.bui-button.bui-button--secondary.bui-stepper__add-button[aria-label='Increase number of Rooms'")).click();
			driver.findElement(By.cssSelector("button.bui-button.bui-button--secondary.bui-stepper__add-button[aria-label='Increase number of Rooms'")).submit();
			

			
	}
	@Test
	public void testForArea()//This is test for entering the  abbreviation of location name
	{
		driver.findElement(By.id("ss")).sendKeys("Mel");
		driver.findElement(By.id("ss")).submit();
	}*/
	
	@Test
	public void testForEnteringWrongName()//This is test for entering wrong name of a location
	{
		driver.findElement(By.id("ss")).sendKeys("@#!@#");
		driver.findElement(By.id("ss")).submit();
		String url = driver.getCurrentUrl();
		assertEquals("fail- unable to research this location", url, "https://www.booking.com/index.en-gb.html?label=gen173nr-1FCAEoggI46AdIM1gEaA-IAQGYAQm4ARfIAQzYAQHoAQH4AQuIAgGoAgO4As3tjoUGwAIB0gIkYmUzNWM0MzAtMTJhYi00YjhmLWJkMjYtZDIyNDczNmE0ZmYw2AIG4AIB;sid=2f877879db177a3a2e5bddc326241ed5;sb_price_type=total&;");

	}

}
