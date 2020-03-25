package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class T11_BaseBallTest {
/*
 * 문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
 * 		컴퓨터의 숫자는 난수를 이용하여 구한다.
 * 		(스트라이크는 'S', 볼은 'B'로 출력한다.)
 * 		
 * 		컴퓨터의 난 수가 9 5 7 일때 실행 예시)
 * 		숫자 입력 ==> 3 5 6
 * 		3 5 6 	 ===>1S 0B
 * 		숫자 입력 ==> 7 8 9
 * 		7 8 9 	 ===> 0S 2B
 * 		...
 * 		숫자 입력 => 9 5 7
 * 		9 5 7	===> 3S 0B
 * 
 *  	5번째 만에 맞췄군요.
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean ch;
		
		Set<Integer> computer =new HashSet<>();
		
		while(computer.size()<3) {
			int num = (int)(Math.random() *(9)+1); //1~9사이의 난수
			boolean i =computer.add(num);
					if(i){
			/*computer.add(num);*/
			}
		}
		
		List<Integer> a = new ArrayList<Integer>(computer);
		
		Collections.shuffle(a);
		
		System.out.println("숫자를 3번 입력하세요");
		int voice = sc.nextInt();
		int voice2 = sc.nextInt();
		int voice3 = sc.nextInt();
		
		int s=0;
		int b=0;
		int o=0;
		int chance=0;
		
		int t= a.get(0);
		int t2 = a.get(1);
		int t3= a.get(2);
		
		
		while(true){
			if(voice == t && voice2 == t2 && voice3 == t3) {
				s += 3;
				
				System.out.println(s +","+ b+ ","+ o);
				break;
			}
			else if((voice == t && voice2 == t2) ) {
				s+=2;
				System.out.println(s +","+ b+ ","+ o);
				chance ++;
			}
			else if(voice == a.get(0) || voice2 == a.get(1) || voice3 == a.get(2)) {
				s+=1;
				System.out.println(s +","+ b+ ","+ o);
				chance ++;
			}else if(voice == a.get(0) && voice2 == a.get(1) || voice3 ==a.get(2)) {
				s+=2;
				b+=1;
				System.out.println(s +","+ b+ ","+ o);
				chance ++;
			}
			
		
		}
		
		
		
			
		
		
		
	}
}
