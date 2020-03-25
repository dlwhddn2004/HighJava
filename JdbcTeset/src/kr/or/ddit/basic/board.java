package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.SwingConstants;

import org.omg.CORBA.INTF_REPOS;

import kr.or.ddit.util.DB_util;

public class board {
	Scanner sc= new Scanner (System.in);
	private Connection con= null;
	private Statement stmt= null;
	private PreparedStatement pstmt=null;
	private ResultSet rs =null;
	
	public static void main(String[] args) {
		new board().start();
	}
	
	void start(){
		
		int menu= 0;
		
		do {
		System.out.println("=======================");
		System.out.println("1.전체목록 조회");
		System.out.println("2.새글 작성");
		System.out.println("3. 게시판 수정");
		System.out.println("4. 게시판 삭제");
		System.out.println("5. 게시판 검색");
		System.out.println("0. 종료");
		System.out.println("=======================");
		
		menu = Integer.parseInt(sc.nextLine());
		switch(menu) {
		
		case 1 : 
		  selectAll();
			break;
		case 2 :
			insertBoard();
			break;
		
		case 3 :
			updateBoard();
			break;
		case 4 :
			deleteBoard();
			break;
			
		case 5 :
			serchBoard();
			break;
			
		case 0 :
			System.out.println("종료");
			break;
			
		default :
			System.out.println("번호 다시 입력");
			
		}
		
		}while(menu != 0);
	}
	
	private void serchBoard() {
		int num;
		
		boolean chk = false;
		do {
			System.out.println("검색할 게시판 번호를 입력해주세요");
			 num = Integer.parseInt(sc.nextLine());
		chk = checknum(num);
		if(!chk) {
			System.out.println("게시판 번호가 틀립니다 다시해주세요");
		}else {
			System.out.println("게시판 번호 확인 기다려주세요");
			}
		}while(!chk);
		
		try {
			
			con = DB_util.getConnection();
			stmt= con.createStatement();
			String sql = "select * from jdbc_board where board_no = '"
			+ num + "'";
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				num = rs.getInt("board_no");
				String title = rs.getString("board_title");
				String writer = rs.getString("board_writer");
				String bo_date = rs.getString("board_date");
				String content = rs.getString("board_content");
				System.out.println(num+title+writer+content+bo_date);
			}
			
				
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		
	}

	private void updateBoard() {
		System.out.println();
		boolean chk = false; //기존에 삭제할 게시판이 있는지
		int board_num;
		do {
			System.out.println();
			System.out.println("수정할 게시판 번호를 입력하세요");
			board_num = Integer.parseInt(sc.nextLine());
			
			chk = checknum(board_num);
			if(!chk) {
				System.out.println("게시판"+board_num+"번호가 없음");
				
			}else {
				System.out.println("입력완료");
			}
		}while(!chk);
		System.out.println("수정할 제목을 입력해주세요");
		String title = sc.nextLine();
		System.out.println("수정할 내용을 입력해주세요");
		String content = sc.nextLine();
		System.out.println("수정한 작성자 입력해주세요");
		String name = sc.nextLine();
		
		try {
			con = DB_util.getConnection();
			String sql= "update jdbc_board set board_title =?,"
					+ " board_content = ?," +" board_writer = ?, "+
					"board_date = sysdate where board_no =" +board_num;
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, name);
		
		int rs2 = pstmt.executeUpdate();
		
		if(rs2 >0) {
			System.out.println("게시글"+board_num+" 수정 완료");
		}else {
			System.out.println("게시글" +board_num+" 수정 실패");
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}

	private boolean checknum(int board_num) {
		boolean chk =false;
		
		try {
			con=DB_util.getConnection();
			String sql = "SELECT count(*) as cnt from jdbc_board"
					+ " where board_no = " + board_num;
					pstmt =con.prepareStatement(sql);
			
			rs= pstmt.executeQuery();
			
			int cnt= 0;
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			if(cnt >0) {
				chk= true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return chk;
	}

	private void deleteBoard() {
		System.out.println();
		System.out.println("삭제할 게시판 번호 입력해주세요");
		int num = Integer.parseInt(sc.nextLine());
		
		try {
			con = DB_util.getConnection();
			stmt = con.createStatement();
			
			String sql= "delete from jdbc_board where"
					+  " board_no= "+ num;
			
			int rs_int = stmt.executeUpdate(sql);
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
	}

	//새글 작성
	private void insertBoard() {
		System.out.println("========================");
		System.out.println("제목");
		String title = sc.nextLine();
		System.out.println("작성자");
		String name = sc.nextLine();
		System.out.println("내용");
		String content = sc.nextLine();
		
		try {
			con =DB_util.getConnection();
			
			stmt = con.createStatement();
			
			String sql = "insert into jdbc_board "
					+ " values(board_seq.nextVal," +
					"'"+title + "', "+   "'"+name + "', " + "sysdate, "+
					"'"+ content + "'" +")";
			int int_rs =stmt.executeUpdate(sql);
			
			if(int_rs >0) {
				System.out.println(name + "님 새글 작성 완료");
			}else {
				System.out.println(name+ "님 새글 작성 실패");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
	}

	//전체 조회
	private void selectAll() {
		System.out.println();
		System.out.println("----------------------------");
		System.out.println("번호\t\t제목\t\t작성자\t\t내용\t\t작성날짜\t");
		System.out.println("-----------------------------");
		
		try {
			con =DB_util.getConnection();
			
			String sql = "SELECT * FROM jdbc_board";
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int num = rs.getInt("board_no");
				String title = rs.getString("board_title");
				String writer = rs.getString("board_writer");
				String day = rs.getString("board_date");
				String content = rs.getString("board_content");
			
				System.out.println(num +"\t"+title +"\t"+writer
						+"\t"+content+"\t"+day);
			}
			
			System.out.println("-------------------------------");
			System.out.println("완료");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	}
	
	private void disConnect() {
		if(rs != null) try {rs.close();} catch(SQLException e){}
		if(con != null) try {con.close();} catch(SQLException e){}
        if(pstmt != null) try {pstmt.close();} catch(SQLException e){}
        if(stmt != null) try {stmt.close();} catch(SQLException e){}
		
	}
	
	
}
