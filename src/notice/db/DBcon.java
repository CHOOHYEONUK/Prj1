package notice.db;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBcon {
	public static Connection getConnection() throws Exception {
		//드라이버로드
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		//접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "123456";
		Connection con = DriverManager.getConnection(url, user, pw); jdbc방식*/ 
		
		Context initCtx = new InitialContext();	
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/noticeOrcl");
		Connection con = ds.getConnection();
		return con; //dbcp방식 
	}
}
