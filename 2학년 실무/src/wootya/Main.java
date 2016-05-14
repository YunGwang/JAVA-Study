package wootya;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	public static Connection conn;

	public static void main(String[] args) {
		try {
    		conn = DriverManager.getConnection(
    			          "jdbc:oracle:thin:@14.63.171.87:1522:XE", "sb03", "sb03");
    		
			System.out.println("Success!");
		} catch (SQLException ex) {
			System.out.println("SQLException:" + ex);
		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
		FrameManager.getInstance().showFrame("First"); // 작업할 때 첫 화면

	}
}
