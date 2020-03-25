package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class T03_ArayListTest {

/*5명의 사람이름을 입력하여 ArrayList에 저장하고 이중에 '김'씨 성의 이름을 출력하시오
 * 단 입력은 Sccanner를 이용하여 입력받는다.
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> name = new ArrayList<String>();
		
		 
		for(int i=0; i<5; i++) {
		System.out.println("입력하시오");
		String voice = sc.nextLine();
		name.add(voice);
		}
		
		for(int i=0; i<name.size(); i++) {
			if(name.indexOf(i) =='김') {
				System.out.println(name.get(i));
				break;
			}
		}
		
		name.clear();
		
	}
	
}

