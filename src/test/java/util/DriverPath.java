package util;

public class DriverPath {

	public static String getChromeDriver() {
		String path = "";
		if (Os.getOs().equals("win")) {
			path = "drivers/win/chromedriver.exe";
		} else {
			path = "drivers/" + Os.getOs() + "/chromedriver";
		}
		return path;
	}

	public static String getFirefoxDriver() {
		String path = "";
		if (Os.getOs().equals("win")) {
			path = "drivers/win/geckodriver.exe";
		} else {
			path = "drivers/" + Os.getOs() + "/geckodriver";
		}
		return path;
	}

}
