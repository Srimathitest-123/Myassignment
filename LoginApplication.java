package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginApplication {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		//EdgeDriver driver=new EdgeDriver();
	
			//step 2 ma
		driver.manage().window().maximize();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
//
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");  //companyname
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("TestFirstname");  //Firstname
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("TestLastname");  //Lastname
		
		//Drop down=sourcename
		
		WebElement dropdown= driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select opt=new Select(dropdown);
		//object.method
	    opt.selectByIndex(4);
		//opt.selectByVisibleText("Website");
	    
	    WebElement marketingdropdown=driver.findElement(By.name("marketingCampaignId")); //marketing
	    Select marketingopt= new Select(marketingdropdown);
	    marketingopt.selectByVisibleText("Automobile");
	    
	    WebElement ownershipdropdown=driver.findElement(By.name("ownershipEnumId"));
	    Select ownershipopt=new Select(ownershipdropdown);
	    ownershipopt.selectByValue("OWN_CCORP");
	    
	    driver.findElement(By.className("smallSubmit")).click();
	    Thread.sleep(5000);
	    String title=driver.getTitle();
	    System.out.println(title);
	    
	    String expectedresult="View Lead | opentaps CRM";
	    if(title.equalsIgnoreCase(expectedresult))
	    {
	    	 System.out.println("Title Matched");
        } else {
            System.out.println("Not a match");
	    }
	    driver.close();

	}

}
