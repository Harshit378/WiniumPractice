package tests;

import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.MatcherAssert.*;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import apps.Calculator;

public class CalculatorTests {

	private WiniumDriver app = null;
	private DesktopOptions options;
	private String CALC_PATH = "C:\\Windows\\System32\\calc.exe";
	private String WINIUM_PATH = "http://localhost:9999";
	Calculator calc;

	@Before
	public void startCalculator() throws MalformedURLException {
		options = new DesktopOptions();
		options.setApplicationPath(CALC_PATH);
		app = new WiniumDriver(new URL(WINIUM_PATH), options);
		calc = new Calculator(app);
	}

	@After
	public void closeCalculator() {
		app.close();
	}

	@Test
	public void test() throws IOException {
		DesktopOptions options = new DesktopOptions();
		options.setApplicationPath("C:\\WINDOWS\\system32\\notepad.exe");
		try {
			WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), options);
			driver.findElementByClassName("Edit").sendKeys(
					"This is sample test to test the functionality of Winium. This test is triggered from Jenkins");
			Thread.sleep(2500);
			driver.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void add() throws InterruptedException {
		assertThat(calc.add(7, 5), is("Display is 14"));
	}

	/*
	 * @Test public void subtract() { assertThat(calc.subtract(7, 5), is(2)); }
	 * 
	 * @Test public void multiply() { assertThat(calc.multiply(7, 5), is(35)); }
	 * 
	 * @Test public void divide() { assertThat(calc.divide(7, 5), is(1)); }
	 */

}
