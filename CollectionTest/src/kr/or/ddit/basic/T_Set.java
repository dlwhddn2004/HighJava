package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class T_Set {

	public static void main(String[] args) {
		
		Set<String> Country = new HashSet<>();
		
		System.out.println("----------add 메소드-----------");
		Country.add("한국");
		Country.add("스위스");
		Country.add("브라질");
		Country.add("가나");
		System.out.println("나라 종류 : " + Country.toString());
		
		System.out.println();
		System.out.println("---------contains 메소드---------");
		System.out.println("가나가 포함 되는지 확인: " + Country.contains("가나"));
		System.out.println("브라질이 포함 되는지 확인: " + Country.contains("브라질"));
		
		System.out.println();
		System.out.println("---------iterator 메소드---------");
		Iterator<String> it = Country.iterator();
			while(it.hasNext())
		System.out.println("나라 종류 : " + it.next());
			
			//데이터의 개수만큼 반복하기
			//hasNext()메서드 => 포인터 다음 위치에 데이터가 있으면 true, 없으면 false를 반환한다.
			//next()메서드 ==> 포인터를 다음 자료 위치로 이동하고, 이동한 위치의 자료를 반환한다.
				
		
			
		System.out.println();
		System.out.println("---------size 메소드---------");
		System.out.println("나라의 사이즈(길이) : " + Country.size());
				
			
		System.out.println();
		System.out.println("--------=isEmpty 메소드---------");
		System.out.println("저장된 나라 확인 : " + Country.isEmpty());
		System.out.println(">>clear() 메소드 사용 후 ...");
		Country.clear();
		System.out.println("저장된 나라 확인 : " + Country.isEmpty());
		
		System.out.println();
		System.out.println("---------remove 메소드---------");
		Country.add("한국");
		Country.add("스위스");
		Country.add("브라질");
		Country.add("가나");
		Country.remove("한국");
		System.out.println("나라 종류 : " + Country.toString());
		
		
		List<String> remove = new ArrayList<>();
		System.out.println();
		System.out.println("---------removeAll 메소드---------");
		remove.add("한국");
		remove.add("스위스");
		remove.add("브라질");
		remove.add("가나");
		Country.removeAll(remove);
		System.out.println("나라 종류 : " + Country.toString());

		
		System.out.println();
		System.out.println("---------clear 메소드---------");
		Country.clear();
		System.out.println("나라 종류 : " + Country.toString());
		
	}
}
