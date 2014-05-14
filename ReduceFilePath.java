package main;
/**
 * 
 * @author Ivan Petrov
 *
 */
public class ReduceFilePath {

	public static String reduce_file_path(String path) {
		try {
			path = goOneDirBack(path);
			path = path.replaceAll("\\./", "/");
			
			while (path.contains("//")) {
				path = path.replaceAll("//", "/");
			}
			
			if (path.length() > 1 && path.substring(path.length() - 1).equalsIgnoreCase("/")) {
				path = path.substring(0, path.length() - 1);
			}
		} catch (Exception e) {
			System.out.println("Unexpected error ocurres for path: '" + path + "'");
		}
		
		
		return path;
	}
	
	public static String goOneDirBack(String path) throws Exception {
		int index = -1;
		String firstPart, secondPart;
		String backDir = "../";
		int backDirLength = backDir.length();
	
		if (path.contains(backDir)) {
			index = path.indexOf(backDir);
			
			//if "../" is at the end
			if (index + backDirLength == path.length()) {
				path = path.substring(0, index - 1);
				if (path.contains("/")) {
					path = "/" + path.substring(0, path.lastIndexOf("/"));
				} else {
					path = "/";
				}
				
			} else {
				firstPart = path.substring(0, index - 1);
				if (firstPart.contains("/")) {
					firstPart = firstPart.substring(0, firstPart.lastIndexOf("/"));
				}
				secondPart = path.substring(index + backDirLength, path.length());
				path = goOneDirBack(firstPart + "/" + secondPart);
			}
		}
	return path;
	}
	
	public static void main(String[] args) {
		String path0 = "/home//radorado/code/../hackbulgaria/week0/../";
		String path1 = "/etc/../etc/../etc/../";
		String path2 = "//////////////";
		String path3 = "/etc//wtf/";
		String path4 = "/srv/./././././";
		String path5 = "/";
		System.out.println(reduce_file_path(path0));
		System.out.println(reduce_file_path(path1));
		System.out.println(reduce_file_path(path2));
		System.out.println(reduce_file_path(path3));
		System.out.println(reduce_file_path(path4));
		System.out.println(reduce_file_path(path5));
	}

}
