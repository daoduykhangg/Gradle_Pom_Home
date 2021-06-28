package homecredit.TeleLanding.SubmitBOD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbcConnect.OracleSQLConnUtils;

public class MySQLTest {

	public static void main(String[] args) throws SQLException {
		String phoneNumber = "0340422394";
		ArrayList<String> otpCode = new ArrayList<>();
		String otp = null;
		//Mở kết nối
		Connection conn = OracleSQLConnUtils.getOracleSQLConnection();
		//Định nghĩa 1 câu Query
		String sql = "SELECT * FROM HSOTP.OTP_REQUEST RE "
				+ "LEFT JOIN HSOTP.OTP_VERIFICATION VE ON RE.ID = VE.OTP_REQUEST_ID "
				+ "LEFT JOIN HSOTP.OTP_DISPATCH DI ON RE.ID = DI.OTP_REQUEST_ID "
				+ "WHERE RE.RECIPIENT = '" + phoneNumber + "' "
						+ "ORDER BY RE.UUID desc";

		//Thực thi query
		Statement statement = conn.createStatement();
		
		//Hứng dữ liệu từ query trả về
		ResultSet rs = statement.executeQuery(sql);
		
		//Duyệt qua dữ liệu trả về 
		while (rs.next()) {
			otpCode.add(rs.getString("OTP_CODE"));
		}
		otp = otpCode.get(0);
		System.out.println(otp);
		conn.close();
	}

}
