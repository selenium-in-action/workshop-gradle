package util;

import answers.AbstractTestBase;

public class File {
	public static String findFileOnPath(final String fileName) {
		return AbstractTestBase.class.getClassLoader().getResource(fileName).getPath();
	}
}
