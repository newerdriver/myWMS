package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库工具类
 * @author 1234
 *
 */
public class DBUtils {
		private static Properties prop=new Properties();
		//在类加载时执行（第一次使用并只执行一次）
		static{
			//相对于类路径（bin/src）去查找源文件
			try {
				prop.load(DBUtils.class.getClassLoader().getResourceAsStream("config/db.properties"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {//加载驱动
				Class.forName(prop.getProperty("driver"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}	
	public static Connection getConnection() throws SQLException{
	Connection conn=	DriverManager.getConnection(prop.getProperty("url"),
				prop.getProperty("user"),
				prop.getProperty("password"));
		return conn;
		
	}
	
}
