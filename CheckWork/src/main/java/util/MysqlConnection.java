package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection { 
	

	/**
	 *     
	 * @return Connection 返回创建的链接
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
   public static Connection getConnection() throws ClassNotFoundException, SQLException {
	   
	   Class.forName(ReadProperties.driver);
	   Connection conn = DriverManager.getConnection(ReadProperties.url,ReadProperties.user,ReadProperties.password);
	   return conn;    
   }
   /**
    * 此方法用来关闭不需要的链接
    * @param conn  传入需要关闭的链接
    */
   public static void closeConnation(Connection conn) {
	    if(conn!=null) {
	    	try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
   }
}
