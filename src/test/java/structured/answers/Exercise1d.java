package structured.answers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

/**
 * The goal of this exercise is to replace regular identifiers by angular identifiers
 *
 */
@Test
public class Exercise1d extends AbstractTestBase {

	public void addToDo() {
		driver.get("http://todomvc.com/examples/angularjs/#/");
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();

		driver.findElement(ByAngular.model("newTodo")).sendKeys("new TODO");

		driver.findElement(By.cssSelector("#todo-form")).submit();

	}

}
