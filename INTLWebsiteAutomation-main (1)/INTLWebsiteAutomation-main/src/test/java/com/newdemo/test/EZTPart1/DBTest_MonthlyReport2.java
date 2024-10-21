package com.newdemo.test.EZTPart1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.List;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Unit test for simple App.
 */
public class DBTest_MonthlyReport2 {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Anil_Nag\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://s1-2.ariba.com/Buyer/Main/aw?awh=r&awssk=KOoWFOXr&realm=mcgraw-hill&dard=1#b0";
		driver.get(url);
		driver.findElement(By.xpath("//input[@id='okta-signin-username']")).sendKeys("anil.nag@mheducation.com");
		driver.findElement(By.xpath("//input[@id='okta-signin-password']")).sendKeys("Simdega123456!");
		driver.findElement(By.xpath("//input[@id='okta-signin-submit']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 55);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Send Push']")));
		driver.findElement(By.xpath("//input[@value='Send Push']")).click();
		Thread.sleep(9000);
		// FileInputStream fis = new
		// FileInputStream("C:\\new\\data\\datafile\\datafile.xlsx");
		FileInputStream fis = new FileInputStream("C:\\new\\data\\datafile\\datafile2.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("testdata");
		// get all rows in the sheet
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		// iterate over all the row to print the data present in each cell.
		for (int i = 1; i <= rowCount; i++) {
			// get cell count in a row
			int cellcount = sheet.getRow(i).getLastCellNum();
			// iterate over each cell to print its value
			for (int j = 0; j < cellcount; j++) {
				String ProjectId = sheet.getRow(i).getCell(j).getStringCellValue();
				// Click on Search Bar Category Menu Id single select list
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='_1eckkc']")));
				driver.findElement(By.xpath("//a[@id='_1eckkc']")).click();
				// Click on/select Contract Workspace (Procurement)
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//a[.='Contract Workspace (Procurement)']")));
				driver.findElement(By.xpath("//a[.='Contract Workspace (Procurement)']")).click();
				// enter project id in 'Search using Title, ID, or any other term' field
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='_rdqcdb']")));
				driver.findElement(By.xpath("//input[@id='_rdqcdb']")).sendKeys(ProjectId);
				// click on Search button
				driver.findElement(By.xpath("//button[@id='_4opwwd']")).click();
				// Click on first contract link
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("(//a[@class=\"awmenuLink hoverArrow\"])[1]")));
				driver.findElement(By.xpath("(//a[@class=\"awmenuLink hoverArrow\"])[1]")).click();
				// Click on first contract link menu item
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='_hvefad']")));
				driver.findElement(By.xpath("//a[@id='_hvefad']")).click();
				// find the No.of document Columns
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//table[@class='tableBody']//tr/td/a[@class='hoverArrow hoverLink']")));
				List<WebElement> col = driver
						.findElements(By.xpath("//table[@class='tableBody']//tr/td/a[@class='hoverArrow hoverLink']"));
				// System.out.println("No.of document Columns : " +col.size());
				for (int k = 0; k < col.size(); k++) {
					// get the document title
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"(//table[@class='tableBody']//tr/td/a[@class='hoverArrow hoverLink'])[" + (k + 1) + "]")));
					String Name = driver.findElement(By.xpath(
							"(//table[@class='tableBody']//tr/td/a[@class='hoverArrow hoverLink'])[" + (k + 1) + "]"))
							.getText();
					// convert document title in single line
					Name = Name.replaceAll("[\r\n]+", " ");
					// get the document id
					String DocumentId = driver.findElement(By.xpath(
							"(//table[@class='tableBody']//tr/td/a[@class='hoverArrow hoverLink'])[" + (k + 1) + "]"))
							.getAttribute("_mid");
					// return the ProjectId + "^" + DocumentId + "^" + Name
					System.out.println(ProjectId + "^" + DocumentId + "^" + Name);
					// try {
					// FileWriter myWriter = new
					// FileWriter("C:\\new\\data\\datafile\\datafilename.txt");
					// myWriter.write(ProjectId + "^" + DocumentId + "^" + Name);
					// myWriter.close();
					// // System.out.println("Successfully wrote to the file.");
					// } catch (IOException e) {
					// System.out.println("An error occurred.");
					// e.printStackTrace();
					// }
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='_bd98i']")));
				driver.findElement(By.xpath("//a[@id='_bd98i']")).click();
			}
		}
	}
}












