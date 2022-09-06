package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMysql {
	
	private static String USERNAME = "root";
	private static final String PASSWORD ="Robert@1";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bonvoyage";
	
	public static Connection createConnectionMysql() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}
	
	public static void main (String[] args) throws Exception {
		Connection conn = createConnectionMysql();
		
		if(conn != null) {
			System.out.println("Conexão obtida com sucesso!" + conn);
			conn.close();
		}
	}
}
