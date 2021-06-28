package jdbcConnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleSQLConnUtils {
	public static Connection getOracleSQLConnection() {
		String hostName = "DBVN00C1HO.VN.INFRA";
		String userName = "appdeploy";
		String password = "VN00C1HO";
		return getOracleSQLConnection(hostName, userName, password);
	}
	
	public static Connection getOracleSQLConnection(String hostName, String userName, String password) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String connectionURL = "jdbc:oracle:thin:" + userName + "/" + password + "@" + hostName + ":1521/VN00C1HO.VN.INFRA";
			conn = DriverManager.getConnection(connectionURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
