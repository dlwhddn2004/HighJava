package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelCheck {

	Scanner sc = new Scanner(System.in);
	private Map<String, Hotel> map = new HashMap<>();

	public void display() {
		System.out.println();
		System.out.println();
		System.out.println("**************************");
		System.out.println("어떤 업무를 수행 하시겠습니까?");
		System.out.print("1.체크인\t2.체크아웃\t3.객실상태\t4.방옮기기 0 종료" );
	}

	public void start() {

		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다");
		System.out.println("**************************");

		while (true) {

			display();

			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {

			case 1: // 등록 수정 삭제
				checkin();
				break;
			case 2:
				checkout();
				break;
			case 3:
				roomstatus();
				break;
			case 4:
				upgrade();
				break;
			case 0:
				System.out.println("종료");
				return;
			default :
				System.out.println("다시 입력 ");
			}
		}
		
		
		
	}

	private void upgrade() {
		
		System.out.println("현재 머문 방번호");
		String Roomnum = sc.nextLine();
		
		Hotel name = null;
		if(map.get(Roomnum) ==null) {
			System.out.println("거긴 이미 체크아웃인디요?");
			return;
		}else {
			name = map.get(Roomnum);
			map.remove(Roomnum);
		}
		
		String changeRoom = null;
		boolean check = true;
		do {
		System.out.println("어디로 가시게요?");
		 changeRoom = sc.nextLine();
		 	
		if(map.get(changeRoom) != null) {
			System.out.println("거긴 안돼! 누가 쓴단말야");
			check = false;
		 }else {
			 check = true;
		 }
		}while(check = false);
		name.setRoom(changeRoom);
		map.put(changeRoom, name);
		
		
	}

	private void roomstatus() {
		Set<String> keySet = map.keySet();
	/*	
		for(String a : keySet) {
			System.out.println("방번호" + a + "투숙객"+ map.get(a));
		}*/
		if(keySet == null) {
			System.out.println("코로나때매 방번호 예약 없어요");
			return;
		}else {
			Iterator<String> it = keySet.iterator();
			while(it.hasNext()) {
				String num = it.next();
				Hotel h = map.get(num);
				System.out.println("방번호" +num + "투숙객"+ h);
			}
		}
		
	}

	private void checkout() {
		System.out.println("어느 방을 채크 아웃 할꺼냐?");
		String room = sc.nextLine();
		
		if(map.get(room) == null) {
			System.out.println("그 방은 이미 없는데요?");
			return;
		}
		
		map.remove(room);
		
		System.out.println("체크 아웃 됬슴다");
		
		
	}

	private void checkin() {
		System.out.println("==================");
		System.out.println("어느 방에 체크인 하실꺼냐");
		System.out.println("방 번호 입력 =>");
		String num = sc.nextLine();
		
		if(map.get(num)!= null) {
			System.out.println(num+"방 번호는 이미 있음");
			return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		String name = sc.nextLine();
		
		map.put(num, new Hotel(num, name));
		
		System.out.println("체크인 되었습니다.");
		
	}
	public static void main(String[] args) {
		HotelCheck a =new HotelCheck();
		a.start();
	}
	
	
}

class Hotel {
	private String room;
	private String name;

	public Hotel(String room, String name) {
		super();
		this.room = room;
		this.name = name;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {

		return "[방번호 " + room + "," + "투수객 이름  " + "," + name + " ]";
	}
}
