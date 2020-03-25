package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.xml.ws.FaultAction;

import kr.or.ddit.util.DB_util;

public class db_hotel {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	db_hotel a = new db_hotel();
		a.start();
	}
	
	public void display() {
		System.out.println();
		System.out.println();
		System.out.println("**************************");
		System.out.println("어떤 업무를 수행 하시겠습니까?");
		System.out.print("1.체크인\t2.체크아웃\t3.객실상태\t 0 종료");
	}

	public void start() {

		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다");
		System.out.println("**************************");

		while (true) {

			display();

			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {

			
			case 1: checkin();
				
				break;
			case 2:
				checkout();
				break;
			case 3:
				Select();
				break;
			case 0:
				System.out.println("종료");
				return;
			default:
				System.out.println("다시 입력 ");
			}
		}
	}

	public void Select() {
		System.out.println("===========================================");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String user = "dlwhddn2004";
			String pass = "java";
			
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			String sql = "Select * from jackandlee";
			rs = stmt.executeQuery(sql);
			
			
			System.out.println("--------------------------------------------");
			while(rs.next()) {
				System.out.println(rs.getInt(1) +","+ rs.getString("name"));
			}
			System.out.println("--------------------------------------------");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {}
			}
			if(stmt != null) {
				try {
					stmt.close();
				}catch(SQLException e) {}
			}
			
		}
		
	}

	public void checkout() {
		System.out.println("삭제할 방번호를 입력해주세요");
		int room = 0;
		room = Integer.parseInt(sc.nextLine());
		String sql= "delete from jackandlee where room = " + room ;
		sql(sql);
		
	}

	public void checkin() {
		System.out.println("방번호를 입력해주세요");
		int room=0;
		
		room = Integer.parseInt(sc.nextLine());
		if(duplicate(room)) {
			System.out.println("중복되었습니다");
			return;
		}
		
		System.out.println("이름을 입력해주세요");
		String name= sc.nextLine();
		
		String sql = "Insert into jackandlee values (" + room + ", '" + name + "')";
		sql(sql);
		
	}
	
	public boolean duplicate(int room) {
		boolean chk = false;
		ResultSet rs= null;
		PreparedStatement pstmt =null;
		Connection con =null;
		
		try {
			con = DB_util.getConnection();
			String sql = "SELECT count(*) as cnt from"
					+ " jackandlee where room = ? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, room);
				
				rs = pstmt.executeQuery();
				
				int cnt = 0;
				if(rs.next()) {
					cnt =rs.getInt("cnt");
				}
				if(cnt > 0) {
					chk = true;
		
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException e){}
			if(con != null) try {con.close();} catch(SQLException e){}
	        if(pstmt != null) try {pstmt.close();} catch(SQLException e){}
	        
		}
		
		
		return chk;
	}

	public void sql(String sql) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ptmt= null;
		int rs = 0;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String user = "dlwhddn2004";
			String password = "java";
			conn = DriverManager.getConnection(url, user, password);

			stmt = conn.createStatement();
			rs = stmt.executeUpdate(sql);

			
				
				
				
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {

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
