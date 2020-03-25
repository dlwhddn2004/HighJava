package kr.or.ddit.basic;
/*
 *  LPROD 테이블에 새로운 데이터를 추가하기
 *  
 *  lprod_gu와 lprod_nm은 직접 입력받아 처리하고,
 *  lprod_id는 현재의 lprod_id들 중 제일 큰 값보다 1 증가된 값으로 한다.
 *  (기타 사항 : lprod_gu도 중복되는지 검사한다.)
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DB_util;

public class T04_jdbcTest {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		Connection con = null;
		PreparedStatement pstmt= null;
		Statement stmt =null;
		ResultSet rs = null;
		
		  
	    try{
	      
	    
	       con = DB_util.getConnection();
	       stmt = con.createStatement();
	       
	       
	       String sql = "SELECT max(lprod_id) Max_id FROM lprod";
	       
	       rs= stmt.executeQuery(sql);
	       int num=0;
	       
	       while(rs.next()) {
	    	   num =rs.getInt("Max_id");
	       }
	       
	       num++;
	       
	       String gu= null;
			int count;
			String sql3 = "select count(*) cnt from lprod "
					+ " where lprod_gu = ?";
			pstmt = con.prepareStatement(sql3);
			
			do{
				System.out.print("상품 분류코드(LPROD_GU) 입력 : ");
				
				gu = sc.next();
				
				pstmt.setString(1, gu);
				
				rs = pstmt.executeQuery();
				
				count = 0;
				
				if(rs.next()){
					count = rs.getInt("cnt");
				}
				if(count>0){
					System.out.println("상품 분류 코드 " + gu + "은(는) "
							+ "이미 있는 상품입니다.");
					System.out.println("다시 입력하세요.");
					System.out.println();
				}
				
			}while(count>0);
			
			System.out.print("상품 분류명(LPROD_NM) 입력 : ");
			String nm = sc.next();
			
			sc.close();
			
			String sql2 = "insert into lprod (lprod_id, lprod_gu, lprod_nm) "
					+ " values (?, ?, ?)";
			pstmt = con.prepareStatement(sql2);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, gu);
			pstmt.setString(3, nm);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0){
				System.out.println(gu + "를 추가했습니다.");
			}else{
				System.out.println(gu + "를 추가하는데 실패했습니다.");
			}
	   /* }catch(ClassNotFoundException e) {
	         System.out.println("드라이버 로딩 실패 !");*/
	      }catch(SQLException e){
	         e.printStackTrace();
	      }finally {
	         //사용했던 자원 반납
	         if(con != null) try {con.close();} catch(SQLException e){}
	         if(pstmt != null) try {pstmt.close();} catch(SQLException e){}
	         if(stmt != null) try {stmt.close();} catch(SQLException e){}
	      }
	   }
	 }

