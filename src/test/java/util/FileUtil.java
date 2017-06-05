package util;

import java.io.File;

public class FileUtil {
	public static String findFileOnPath(final String fileName) {
		if (FileUtil.class.getClassLoader().getResource(fileName) != null) {
			return FileUtil.class.getClassLoader().getResource(fileName).getPath();
		} else {
			return new File("src/main/resources/" + fileName).getAbsolutePath();
		}
	}

}
