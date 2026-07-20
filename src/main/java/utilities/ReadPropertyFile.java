package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// NOTE: Using absolute path here is for local debugging only.
		// In BaseTest, config is loaded using System.getProperty("user.dir") for portability.
		FileReader file1=new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\configfiles\\config.properties");
		Properties p1=new Properties();
		p1.load(file1);
		System.out.println(p1.getProperty("browser"));
		System.out.println(p1.getProperty("testurl"));
	}

}
