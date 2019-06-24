package util;
/**
 * 读取文本文件并存入数据库
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReadRTxt {
	public static void toArrayByRandomAccessFile() {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(ReadProperties.kqtxt);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
       BufferedReader bufferedReader = null;
	try {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"gbk"));
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
	   ArrayList<String> al = new ArrayList<String>();
       String str = null;
       try {
		while((str = bufferedReader.readLine()) != null)
		    {
		    System.out.println(str);
		    String[] str1 = str.split(" ");
		    try {
		    	//创建数据库链接
		    	Connection conn = MysqlConnection.getConnection();
		    	//获取Statement对象
				Statement st = conn.createStatement();
				String sql = "update clock_time set name= "+str1[4]+" set date = "+str1[1];
				//处理SQL语句
				ResultSet rs=st.executeQuery(sql);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    }
	} catch (IOException e) {
		e.printStackTrace();
	}
	
        //close
        try {
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
