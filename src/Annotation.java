/**
 * 
 */

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * @author Settings
 *
 */
public class Annotation {
	int erros=1;
	WebDriver driver;
	WebDriverWait wait;
	FirefoxProfile profile;
	List <WebElement> vids;
	WebElement catname;
	WebElement href;
	boolean lastpage = false;
	List <WebElement> list;
	String contactButton=".//button[contains(text(),'Contact Us')]";
	String signInButton=".//button[contains(text(),'Sign In')]";
	String usernameId = "username";
	String username = "candidate1";
	String pwId = "password";
	String pw = "candidate1";
	String signInButton2=".//button[contains(text(),'Sign in')]";
	int batch = 2;
	int batchannotation=1;
	
	
	/**
	 * 
	 */
	public Annotation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Annotation aaaa=new Annotation();
		
			 aaaa.driver =  new FirefoxDriver();
			 
			//wait implicito do driver
			aaaa.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			aaaa.driver.get("http://error-check-staging.nlp.unbabel.com/");
			
			aaaa.driver.findElement(By.xpath(aaaa.signInButton)).click();
			aaaa.driver.findElement(By.id(aaaa.usernameId)).sendKeys(aaaa.username);
			aaaa.driver.findElement(By.id(aaaa.pwId)).sendKeys(aaaa.pw);
			aaaa.driver.findElement(By.xpath(aaaa.signInButton2)).click();
			aaaa.driver.findElement(By.xpath(".//tbody/tr["+aaaa.batch+"]/td[1]/a")).click();
		
/*			Actions actions = new Actions(aaaa.driver);
			aaaa.driver.findElement(By.xpath("//*[@id=\"segments\"]/div["+aaaa.batchannotation+"]/div[2]"));
			actions.clickAndHold(aaaa.driver.findElement(By.xpath("//*[@id=\"segments\"]/div["+aaaa.batchannotation+"]/div[2]")));
			actions.doubleClick();
			actions.release(aaaa.driver.findElement(By.xpath("//*[@id=\"segments\"]/div["+aaaa.batchannotation+"]/div[1]"))).perform();;
			actions.release(aaaa.driver.findElement(By.xpath("//*[@id=\"segments\"]/div["+aaaa.batchannotation+"]/div[1]"))).perform();
*/
			//*[@id="segments"]/div[1]/div[2]
			JavascriptExecutor executor = (JavascriptExecutor)aaaa.driver;
			executor.executeScript("arguments[0].click();", aaaa.driver.findElement(By.xpath(".//tbody/tr["+aaaa.batchannotation+"]/td[2]/a")));
			
			
			//div[contains(text(),'noreply@somedomain.com')]
			
			//aaaa.driver.close();






		}catch(Exception exception){
			System.out.println("fdxc");
			System.out.println(exception.toString());
			;
		}

	}

}
