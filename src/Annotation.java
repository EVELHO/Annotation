/**
 * 
 */

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;



/**
 * @author evelho
 *
 */
public class Annotation {

	static WebDriver driver;
	static	Actions actions;
	WebDriverWait wait;
	static String contactButton=".//button[contains(text(),'Contact Us')]";
	static String signInButton=".//button[contains(text(),'Sign In')]";
	static String usernameId = "username";
	static String username = "candidate1";
	static String pwId = "password";
	static String pw = "candidate1";
	static String signInButton2=".//button[contains(text(),'Sign in')]";
	static int batch = 2;



	/**
	 * 
	 */
	public Annotation() {


	}
	@BeforeClass
	public static void init(){
		driver =  new FirefoxDriver();
		driver.manage().window().maximize();
		actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://error-check-staging.nlp.unbabel.com/");
	}

	public static WebElement find(String by, String text){
		WebElement element = null;
		int retry=0;
		while(retry<10 && element == null){
			try {
				Thread.sleep(1000);
				if (by=="xpath"){
					element = driver.findElement(By.xpath(text));
				}else if (by=="id"){
					element = driver.findElement(By.id(text));
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				retry++;
				e.printStackTrace();
			}
		}

		return element;

	}

	public static void login(){
		find("xpath", signInButton).click();
		find("id",usernameId).sendKeys(username);
		find("id",pwId).sendKeys(pw);
		find("xpath",signInButton2).click();
	}


	public static void selectBatch(int batch){
		batch=batch*2;
		find("xpath",".//tbody/tr["+batch+"]/td[1]/a").click();
	}

	public static void createAnnotation(int batchannotation){
		try{
			find("xpath","//*[@id=\"segments\"]/div["+batchannotation+"]/div[2]");
			actions.clickAndHold(find("xpath","//*[@id=\"segments\"]/div["+batchannotation+"]/div[2]"));
			actions.moveToElement(find("xpath","//*[@id=\"segments\"]/div["+batchannotation+"]/div[2]"), 1, 1);
			actions.release();
			actions.release(driver.findElement(By.xpath("//*[@id=\"segments\"]/div["+batchannotation+"]/div[1]"))).perform();
		}catch(Exception exception){

			;
		}
	}

	public static void finalizeAnnotation(String action){
		if(action=="clear"){
			find("id","exit").click();
		}else{
			find("id","add").click();
		}


	}

	/**
	 * @param args
	 */
	@Test
	public void test() {
		// TODO Auto-generated method stub
		Annotation a = new Annotation();


		login();
		selectBatch(2);
		createAnnotation(3);
		selectError("False Friend");
		selectSeverity(2);
		finalizeAnnotation("add");



	}

	private static void selectSeverity(int severity) {
		find("xpath","//*[@id=\"annotation-tools-container\"]/span/li["+severity+"]/input").click();

	}

	private static void selectError(String errorType) {
		int seconds = 2000;
		int retry =0;
		System.out.println(find("id","error-type-btn").getText() + retry);


		while(find("id","error-type-btn").getText().equals(errorType)==false && retry < 5){
			System.out.println(find("id","error-type-btn").getText() + " - " +errorType );
			System.out.println(find("id","error-type-btn").getText().equals(errorType));
			try{

				driver.findElement(By.id("error-type-btn")).click();

				Thread.sleep(seconds);
				actions.moveToElement(find("id","error-type-btn"));
				actions.moveToElement(driver.findElement(By.id("error-type-btn"))).moveToElement(driver.findElement(By.xpath(".//span[contains(text(),'"+errorType+"')]"))).click().build().perform();
				retry++;
			}catch(Exception e){
				retry++;
				System.out.println(find("id","error-type-btn").getText() + retry);
			}
		}




	}


		public void finalize(){
			driver.close();
		}


}
