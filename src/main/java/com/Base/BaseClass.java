package com.Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseClass {

	public static WebDriver driver;
	//public static Actions a = new Actions(driver); // we should not create like this, because java will execute static block first,
	//at the time driver is null, so we may get an exception
	public static Actions a;

	// Browser Launching by using base class driver
		public static WebDriver browserLaunch(String browser) {

			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions ch = new ChromeOptions();
				ch.addArguments("Incognito");
				driver = new ChromeDriver(ch);
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("opera")) {
				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
			}
			return driver;

		}
		public static void urlLaunch(String url) {
			driver.manage().window().maximize();
			driver.get(url);
		}

		public static void implicitWait(int time) {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		}
		
		public static void explicitWaitVisibility(WebElement element, int time) {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public static void explicitWaitClickable(WebElement element, int time) {
				WebDriverWait wait = new WebDriverWait(driver, time);			
				wait.until(ExpectedConditions.elementToBeClickable(element));	
		}
	
	public static void clickOnElement(WebElement element) {
		if (element.isDisplayed()) {
			element.click();
		}
	}

	public static void inputValues(WebElement element, String value) {
		if (element.isDisplayed()) {
			element.sendKeys(value);
		}
	}

	public static void screenShot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		// we should not use TakesScreenshot ts = new ChromeDriver(); because it will open
		// new browser and capture blank snap
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\gobiv\\eclipse-workspace\\IPT1\\ScreenShot\\" + filename + ".png");
		FileHandler.copy(src, dest);
	}

	public static void dropDown(WebElement element, String option, String value) {
		Select s = new Select(element);
		if (option.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(value);
			s.selectByIndex(index);
		} else if (option.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (option.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		}
	}
	public static void mouseHover(WebElement element) {
		a= new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	public static void mouseClick(WebElement element) {
		a= new Actions(driver);
		a.click(element).build().perform();
	}
	public static void rightClick(WebElement element) {
		a= new Actions(driver);
		a.contextClick(element).build().perform();
	}
	public static void dragAndDrop(WebElement src, WebElement dest) {
		a= new Actions(driver);
		a.dragAndDrop(src,dest).build().perform();
	}

	public static void simpleAlert() {
		driver.switchTo().alert().accept();
	}

	public static void confirmAlert(String option) {
		if (option.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		} else if (option.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
		}
	}

	public static void promptAlert(String message, String option) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(message);

		if (option.equalsIgnoreCase("accept")) {
			alert.accept();
		} else if (option.equalsIgnoreCase("dismiss")) {
			alert.dismiss();
		}
	}
	//Window Handling
		public static void switchWindow(int index) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new LinkedList<>(windowHandles);
		String string = list.get(index);
		driver.switchTo().window(string);
		}

// Navigation methods
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

// Browser closing methods
	public static void quit() {
		driver.quit();
	}

	public static void close() {
		driver.close();
	}

	// Java Script Methods
	public static void scrollByAxis(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+");");
	}

	public static void scrollByElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void scrollAndClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void scrollAndPassValue(String id, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('"+id+"').value=('"+value+"');");
	}
	public static void jsSendkeys(String txtbox, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+txtbox+"');", element);
	}

	public static void scrollToEnd() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);", "");
	}
	public static void jsAlert(String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('"+message+"');");
	}

	// Frames Handling Methods
	public static void switchToFrame(String id) {
		driver.switchTo().frame(id);// id is used as reference
	}

	public static void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);// web element is used as reference
	}

	public static void switchToFrame(int index) {
		driver.switchTo().frame(index);// index starts from 0, i.e first iframe is selected
	}

	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();// return to previous frame
	}

	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();// return to main page
	}
	
	// Boolean type Return verification methods
		public static boolean isEnabled(WebElement element) {
			boolean enabled = element.isEnabled();
			System.out.println("Whether the WebElement is enabled: "+enabled);
			return enabled;
		}

		public static boolean isDisplayed(WebElement element) {
			boolean displayed = element.isDisplayed();
			System.out.println("Whether the WebElement is displayed: "+displayed);
			return displayed;
		}

		public static boolean isSelected(WebElement element) {
			boolean selected = element.isSelected();
			System.out.println("Whether the WebElement is selected: "+selected);
			return selected;
		}
		// String type Return get methods
		public static String getTitle() {
			String title = driver.getTitle();
			System.out.println(title);
			return title;
		}

		public static String getCurrentUrl() {
			String currentUrl = driver.getCurrentUrl();
			System.out.println("The current webpage URL address is: "+currentUrl);
			return currentUrl;
		}

		public static String getText(WebElement element) {
			String text = element.getText();
			System.out.println("Text found in the WebElement is: "+text);
			return text;
		}

		public static String getAttribute(WebElement element, String value) {
			String attribute = element.getAttribute(value);		
			System.out.println(attribute);
			return attribute;
		}
		//OTP get Scanner Method
		public static String otp() {
			Scanner s =new Scanner(System.in);
			System.out.println("Please enter the otp received");
			String otp = s.next();
			s.close();
			return otp;		
		}
		public static void clearfield(WebElement element) {
			element.clear();
		}
		public static void radioButton(WebElement element) {
			element.click();
		}
		public static void checkBox(WebElement element) {
			element.click();
		}
		public static void dropDownDeSelect(WebElement element, String option, String data) {
			Select s=new Select(element);
			if (option.equalsIgnoreCase("value")) {
				s.deselectByValue(data);
			}
			else if (option.equalsIgnoreCase("text")) {
				s.deselectByVisibleText(data);
			}
			else if (option.equalsIgnoreCase("index")) {
				int index = Integer.parseInt(data);
				s.deselectByIndex(index);
			}	
			else if (option.equalsIgnoreCase("all")) {
				s.deselectAll();
			}
		}
		//Multiple Drop Down Methods	
		public static boolean isMultiple(WebElement element) {
			Select s = new Select(element);
			boolean multiple = s.isMultiple();
			return multiple;
		}
		public static void getoptions(WebElement element) {
			Select s = new Select(element);
			List<WebElement> options = s.getOptions();
			for(WebElement opt:options) {
				System.out.println(opt.getText());
			}
		}
		public static void getAllOptions(WebElement element) {
			Select s = new Select(element);
			List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
			for(WebElement selectedOptions:allSelectedOptions) {
				System.out.println(selectedOptions.getText());
			}
		}
		public static void getFirstSelectedOptions(WebElement element) {
			Select s = new Select(element);
			WebElement firstSelectedOption = s.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText());
		}
		// Action Methods
		public static void actions(WebElement element, String option) {
			Actions a = new Actions(driver);
			if (option.equalsIgnoreCase("moveToElement")) {			
				a.moveToElement(element).build().perform();
			} else if (option.equalsIgnoreCase("click")) {
				a.click(element).build().perform();
			} else if (option.equalsIgnoreCase("contextClick")) {
				a.contextClick(element).build().perform();
			} else if (option.equalsIgnoreCase("doubleClick")) {
				a.doubleClick(element).build().perform();
			} else if (option.equalsIgnoreCase("clickAndHold")) {
				a.clickAndHold(element).build().perform();
			}  else if (option.equalsIgnoreCase("release")) {
				a.release(element).build().perform();
			}
		}
		//Robot Class Methods for enter
		public static void robot(String option) throws AWTException {
			Robot r = new Robot();
			if (option.equalsIgnoreCase("Enter")) {
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
			}else if (option.equalsIgnoreCase("down")) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
			}		
			else if (option.equalsIgnoreCase("up")) {
				r.keyPress(KeyEvent.VK_UP);
				r.keyRelease(KeyEvent.VK_UP);
			}
			else if (option.equalsIgnoreCase("left")) {
				r.keyPress(KeyEvent.VK_LEFT);
				r.keyRelease(KeyEvent.VK_LEFT);
			}
			else if (option.equalsIgnoreCase("Right")) {
				r.keyPress(KeyEvent.VK_RIGHT);
				r.keyRelease(KeyEvent.VK_RIGHT);
			}
		}
}
