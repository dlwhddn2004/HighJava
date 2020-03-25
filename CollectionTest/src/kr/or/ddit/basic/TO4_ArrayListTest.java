package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class TO4_ArrayListTest {
public static void main(String[] args) {
	/*문제 1) 5명의 발명을 입력하여 ArrayList에 저장하고
	별명의 길이가 제일 긴 별명을 출력하시오
	(단, 각 별명의 길이는 모두 다르게 입력한다)*/
	ArrayList<String> name = new ArrayList<String>();
	Scanner sc = new Scanner(System.in);
	
	for(int i=0; i<5; i++) {
		System.out.println("별명을 입력하시오");
		String voice2 = sc.nextLine();
		name.add(voice2);	
	}
	
	String max = name.get(0);
	for(int i=1; i<name.size(); i++) {
		if(max.length() < name.get(i).length() ) {
			max = name.get(i);
		}
	}
	System.out.println("가장 큰 별명" + max);
	
	//문제2 문제1에서 별명의 길이가 같은 것을 여러개 입력했을 때에도 처리되도록 하시오
	
	//maxLen은 제일 긴 별명의 길이를 저장하는 변수
	int maxLen = name.get(0).length();
	for(int i=1; i<name.size(); i++) {
		if(maxLen < name.get(i).length()) {
			maxLen = name.get(i).length();
		}
	}
	
	System.out.println("제일 긴 별명들");
	for(int i=0; i<name.size(); i++) {
		if(maxLen == name.get(i).length()) {
			System.out.println(name.get(i));
		}
	}
	
	}
}
