package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Scanner;

public class T02_jdbcTest {
	/*
	 * 문제1) 사용자로부터 lprod_id값을 입력받아 입력한 값보다 lprod_id가 큰 자료들을 출력하시오.
	 * 
	 * 문제2) lprod_id값을 2개 입력받아서 두값 중 작은 값부터 큰 값 사이의 자료를 출력하시오.
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("번호 입력");
		int num = 0;
		num = Integer.parseInt(sc.nextLine());
		new T02_jdbcTest().selectSql("SELECT * FROM lprod where lprod_id >'" + num+"'");

		System.out.println("번호입력 1");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("번호입력 2");
		int num2 = Integer.parseInt(sc.nextLine());
		int max = 0;
		int min = 0;
		if (num1 > num2) {
			max = num1;
			min = num2;
		} else if (num1 < num2) {
			max = num2;
			min = num1;
		}

		new T02_jdbcTest().selectSql("SELECT * FROM lprod where lprod_id between '" + min + "'  and '"+ max + "'");
	}

	void selectSql(String sql) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String user_id = "dlwhddn2004";
			String pass = "java";
			conn = DriverManager.getConnection(url, user_id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt("lprod_id"));
				System.out.println(rs.getString("lprod_gu"));
				System.out.println(rs.getString("lprod_nm"));
			}
			System.out.println("출력 끝");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
					}
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
						}
					}
				}
			}
		}
	}
}
