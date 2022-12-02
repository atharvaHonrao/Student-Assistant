package TeacherSide;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	
	public static void main(String[] args) throws SQLException{
		
//		teacher_main_interface j = new teacher_main_interface("tdsa");
		
		Login l = new Login(); 
	 
	}

//	public static void uploaddsa() throws SQLException {	
//		
//		
//		String SQL="INSERT INTO dsanotes (file_name,file_size_in_kb,file_extension,file_content)VALUES(?,?,?,?)";
//		Path dir = Paths.get("FilesUpload");
//		try(Stream<Path> list = Files.list(dir);Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassistant","root","Atharva@123");
//				PreparedStatement ps = connection.prepareStatement(SQL)) {
//			 
//			
//			List<Path> pathList = list.collect(Collectors.toList());
//			System.out.println("Following files are saved in database..");
//			for (Path path : pathList) {
//				System.out.println(path.getFileName());
//				File file = path.toFile();
//				String fileName = file.getName();
//				long fileLength = file.length();
//				long fileLengthInKb=fileLength/1024;
//				
//				ps.setString(1, fileName);
//				ps.setLong(2, fileLengthInKb);
//				
//				ps.setString(3, fileName.substring(fileName.lastIndexOf(".")+1));
//				
//				FileInputStream fis = new FileInputStream(file);
//				ps.setBinaryStream(4, fis, fileLength);
//				
//				ps.addBatch();
//			}
//			System.out.println("----------------------------------------");
//			int[] executeBatch = ps.executeBatch();
//			for (int i : executeBatch) {
//				System.out.println(i);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//	}
	
}


