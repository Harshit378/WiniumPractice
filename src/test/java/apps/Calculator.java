package apps;

import org.openqa.selenium.winium.WiniumDriver;

public class Calculator {

	private WiniumDriver app;

	public Calculator(WiniumDriver app) {
		this.app = app;
	}

	public String add(int firstNumber, int secondNumber) throws InterruptedException {
		return compute("+", firstNumber, secondNumber);
	}

	/*
	 * public int subtract(int firstNumber, int secondNumber) { return
	 * compute("Subtract", firstNumber, secondNumber); }
	 * 
	 * public int multiply(int firstNumber, int secondNumber) { return
	 * compute("Multiply", firstNumber, secondNumber); }
	 * 
	 * public int divide(int firstNumber, int secondNumber) { return
	 * compute("Divide", firstNumber, secondNumber); }
	 */
	private String compute(String type, int firstNumber, int secondNumber) throws InterruptedException {
		app.findElementByClassName("num5Button").click();
		Thread.sleep(1000);
		app.findElementByClassName("plusButton").click();
		Thread.sleep(1000);
		app.findElementByClassName("num9Button").click();
		Thread.sleep(1000);
		app.findElementByClassName("equalButton").click();
		Thread.sleep(1000);
		String result = app.findElementById("CalculatorResults").getText();
		System.out.println("The result of calculation is: " + result);
		return result;
	}

}
