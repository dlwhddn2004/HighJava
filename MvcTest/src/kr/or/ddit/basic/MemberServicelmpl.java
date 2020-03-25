package kr.or.ddit.basic;

import java.util.List;


public class MemberServicelmpl implements IMemberService{

	  // 사용할 DAO의 객체 변수를 선언한다.
	   private IMemberDao memDao;
	   
	   public  MemberServicelmpl() {
		
	      memDao = new MemberDaoImpl();
	   }

	@Override
	public int insertMember(MemberVO mv) {
		
		return memDao.insertMember(mv);
	}

	@Override
	public boolean getMember(String memId) {
		
		return memDao.getMember(memId);
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		
		return memDao.getAllMemberList();
	}

	@Override
	public int updateMember(MemberVO mv) {
		
		return memDao.updateMember(mv);
	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return memDao.deleteMember(memId);
	}

	
}
   
   