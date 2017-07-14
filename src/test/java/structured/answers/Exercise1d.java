package structured.answers;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * The goal of this exercise is to replace regular identifiers by angular identifiers
 *
 */
@Test
public class Exercise1d extends AbstractTestBase {

	public void addToDo() {
		getDriver().get("http://todomvc.com/examples/angularjs/#/");
		getDriver().manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		new NgWebDriver((JavascriptExecutor) getDriver()).waitForAngularRequestsToFinish();

		getDriver().findElement(ByAngular.model("newTodo")).sendKeys("new TODO");

		getDriver().findElement(By.cssSelector("#todo-form")).submit();

	}

}
