package util;

public class File {
	public static String findFileOnPath(final String fileName) {
		return File.class.getClassLoader().getResource(fileName).getPath();
	}
}
