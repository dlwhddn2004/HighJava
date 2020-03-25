package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.util.DB_util;
import kr.or.ddit.util.DB_util3;

public class MemberDaoImpl implements IMemberDao{

   private Connection conn;
   private Statement stmt;
   private PreparedStatement pstmt;
   private ResultSet rs;
   
   
   /**
    * 자원 반납용 메소드
    */
   private void disConnect() {
      if(rs!=null)try {rs.close();}catch(SQLException ee) {}
      if(stmt!= null)try {stmt.close();}catch(SQLException ee) {}
      if(pstmt!=null)try {pstmt.close();}catch(SQLException ee) {}
      if(conn!=null)try {conn.close();}catch(SQLException ee) {}
      
   }
   
   
   @Override
   public int insertMember(MemberVO mv) {
	   int cnt=0;
	   
	   try {
         conn = DB_util.getConnection();

         String sql = "insert into mymember (mem_id, mem_name, mem_tel, mem_addr) values(?, ?, ?, ?)";

         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mv.getMem_id());
         pstmt.setString(2, mv.getMem_name());
         pstmt.setString(3, mv.getMem_tel());
         pstmt.setString(4, mv.getMem_addr());

         cnt = pstmt.executeUpdate();

         
      }catch (SQLException e) {
         e.printStackTrace();
      }finally {
         disConnect();
      }
      return cnt;
   }

   @Override
   public boolean getMember(String memId) {
	   boolean chk =false;
		
		try {
			conn = DB_util.getConnection();
			String sql = "SELECT count(*) as cnt from mymember"
					+ " where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			
			int cnt=0;
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
			if(cnt > 0) {
				chk = true; //중복이 있는걸 true로 봄
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return chk;
		
   }

   @Override
   public List<MemberVO> getAllMemberList() {
	   List<MemberVO> memList = new ArrayList<MemberVO>();
	   
	   try {
			conn = DB_util3.getConnection();
			
			String sql = "select * from mymember";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberVO mv = new MemberVO();
				mv.setMem_id(rs.getString("mem_id"));
				mv.setMem_name(rs.getString("mem_name"));
				mv.setMem_tel(rs.getString("mem_tel"));
				mv.setMem_addr(rs.getString("mem_addr"));
				
				memList.add(mv);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	   return memList;
	}
   
   @Override
   public int updateMember(MemberVO mv) {
	  int cnt=0;
	   try {
			conn = DB_util.getConnection();
			String sql= "update mymember set mem_name = ?"
					+  ",mem_tel =?"+ " ,mem_addr = ?" + " where mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMem_name());
			pstmt.setString(2, mv.getMem_tel());
			pstmt.setString(3, mv.getMem_addr());
			pstmt.setString(4, mv.getMem_id());
			
			cnt = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
	   return cnt;
	}

   @Override
   public int deleteMember(String memId) {
	  int cnt=0;
	   try {
			conn = DB_util.getConnection();
			String sql = "delete from mymember where mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			
			 cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				System.out.println(memId + "회원삭제 성공 ");
			}else {
				System.out.println(memId + "회원 삭제 실패 ");
			}
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return cnt;
	}
   
}