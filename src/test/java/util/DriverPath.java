package util;

import util.Os;

public class DriverPath {

	public static String getDriver() {
		String path = "";
		if (!Os.getOs().equals("win")) {
			path = "drivers/win/chromedriver.exe";
		} else {
			path = "drivers/" + Os.getOs() + "/chromedriver";
		}
		return path;
	}

}
