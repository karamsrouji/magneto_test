import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class Mtest {
	WebDriver driver = new EdgeDriver();

	@BeforeTest
	public void start() {

		driver.get("https://magento.softwaretestingboard.com/");

	}

	// ----------------------- login
	@Test (priority = 1) 
	public void sign_up_test () throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)) ; 
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a")).click() ; 
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("karam@gmail.com"); 
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("KaramSrouji98"); 
		driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();
		Thread.sleep(3000); 
	String welcomemsg =driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[1]/span")).getText();
				System.out.println(welcomemsg) ; 
				Boolean testmsg = welcomemsg.contains("Welcome") ; 
				SoftAssert myassertiion = new SoftAssert ();
					myassertiion.assertEquals(testmsg, true) ; 
		
		
			myassertiion.assertAll();
		}

//	// ---------------------------------- add items to search bar
	@Test(priority = 2)
	public void search_bar() throws InterruptedException {
		String[] a = { "Jacket,", "t-shirt", "jeans for men", "jeans for women", "pants" };
		Random rand = new Random();
		int random = rand.nextInt(5);

		driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys(a[random] + Keys.ENTER);
		Thread.sleep(3000);
		System.out.println(a[random]);
		String senttext = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")).getText();
		Boolean containValue = senttext.contains(a[random]);
		SoftAssert myassertiion = new SoftAssert();
		myassertiion.assertEquals(containValue, true);
		myassertiion.assertAll();

	}

	// --------------------------------------- add items from home page
	@Test(priority = 3)
	public void addItems() throws InterruptedException {

		// -- add 3 Radiant tee
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[1]")).click();
		Thread.sleep(2000);
		for (int i = 0; i < 1; i++) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			WebElement itemsize = driver
					.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
			List<WebElement> sizes = itemsize.findElements(By.tagName("div"));
			WebElement itemcolor = driver
					.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
			List<WebElement> colors = itemcolor.findElements(By.tagName("div"));
			Random rand = new Random();
			int randsize = rand.nextInt(sizes.size());
			int randcolor = rand.nextInt(colors.size());
			sizes.get(randsize).click();
			colors.get(randcolor).click();
			Thread.sleep(2000);

		}
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("3");
		driver.findElement(By.id("product-addtocart-button")).click();
		driver.navigate().back();
		Thread.sleep(2000);
		// --- add 2 breathe- easy tank
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[2]")).click();
		Thread.sleep(2000);
		for (int i = 0; i < 1; i++) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			WebElement itemsize = driver
					.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
			List<WebElement> sizes = itemsize.findElements(By.tagName("div"));
			WebElement itemcolor = driver
					.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
			List<WebElement> colors = itemcolor.findElements(By.tagName("div"));

			Random rand = new Random();
			int randsize = rand.nextInt(sizes.size());
			int randcolor = rand.nextInt(colors.size());
			sizes.get(randsize).click();
			colors.get(randcolor).click();
			Thread.sleep(2000);

		}
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("2");
		driver.findElement(By.id("product-addtocart-button")).click();
		driver.navigate().back();
		Thread.sleep(2000);

		// ---- add 4 argus all weather tank
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[3]")).click();
		Thread.sleep(2000);
		for (int i = 0; i < 1; i++) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			WebElement itemsize = driver
					.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
			List<WebElement> sizes = itemsize.findElements(By.tagName("div"));
			WebElement itemcolor = driver
					.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
			List<WebElement> colors = itemcolor.findElements(By.tagName("div"));

			Random rand = new Random();
			int randsize = rand.nextInt(sizes.size());
			int randcolor = rand.nextInt(colors.size());
			sizes.get(randsize).click();
			colors.get(randcolor).click();
			Thread.sleep(2000);

		}
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("4");
		driver.findElement(By.id("product-addtocart-button")).click();
		driver.navigate().back();
		Thread.sleep(2000);

		// ---------- add 1 hero hoodie
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[4]")).click();
		Thread.sleep(2000);
		for (int i = 0; i < 1; i++) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			WebElement itemsize = driver
					.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
			List<WebElement> sizes = itemsize.findElements(By.tagName("div"));
			WebElement itemcolor = driver
					.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
			List<WebElement> colors = itemcolor.findElements(By.tagName("div"));

			Random rand = new Random();
			int randsize = rand.nextInt(sizes.size());
			int randcolor = rand.nextInt(colors.size());
			sizes.get(randsize).click();
			colors.get(randcolor).click();
			Thread.sleep(2000);

		}

		driver.findElement(By.id("product-addtocart-button")).click();
		driver.navigate().back();
		Thread.sleep(2000);

		// ------------- add 5 fusion backpack
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("5");
		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(2000);
		
		

	}

	@Test (priority = 4 ) 
	public void checkOut () throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); 
		driver.get("https://magento.softwaretestingboard.com/radiant-tee.html");
		driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-168\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-57\"]")).click();
driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("2");
driver.findElement(By.id("product-addtocart-button")).click(); 
Thread.sleep(3000);

		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a/span[2]")).click(); 
		Thread.sleep(2000);
        driver.findElement(By.id("top-cart-btn-checkout")).click(); 
		Thread.sleep(10000);
driver.findElement(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input")).click(); 

       driver.findElement(By.xpath("//*[@id=\"checkout\"]/div[1]/button")).click(); 
       Thread.sleep(3000);
       driver.findElement(By.id("login-email")).sendKeys("karam@gmail.com");  
       driver.findElement(By.xpath("//*[@id=\"login-password\"]")).sendKeys("KaramSrouji98"); 
       driver.findElement(By.xpath("//*[@id=\"modal-content-7\"]/div/div/div[3]/form/div[2]/div[1]/button")).click();
       Thread.sleep(3000);
       driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
       Thread.sleep(4000);
       String price =  driver.findElement(By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/table/tbody/tr[4]/td/strong/span")).getText();
       System.out.println(price);
       String updateprice = price.replace("$", "") ; 
       double doubleprice = Double.parseDouble(updateprice);  
       System.out.println(doubleprice);
       
	}

	@Test(priority = 5 , invocationCount = 5)
	public void reorder() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); 
driver.get("https://magento.softwaretestingboard.com/sales/order/history/");
driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/a[2]/span")).click(); 
Thread.sleep(7000);
driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button")).click(); 
Thread.sleep(5000) ; 
driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click(); 
Thread.sleep(3000) ;
driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click(); 
Thread.sleep(3000) ;
	}

	@AfterTest
	public void end() {

	}
}
