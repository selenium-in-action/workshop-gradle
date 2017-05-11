package util;

import org.apache.commons.lang3.SystemUtils;

public class Os {
	public static String getOs() {
		String os = "";
		if (SystemUtils.IS_OS_MAC) {
			os = "mac";
		}
		if (SystemUtils.IS_OS_LINUX) {
			os = "linux";
		}
		if (SystemUtils.IS_OS_WINDOWS) {
			os = "win";
		}
		return os;
	}
}
