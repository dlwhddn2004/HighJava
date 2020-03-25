package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Lotto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Set<Integer> Lotto = new HashSet<>();
		
		int a;
		int money=0;
		do {
			 
		System.out.println("==========================");
		System.out.println("\t1. Lotto 프로그램\t");
		System.out.println("\t2. 프로그램 종료\t");
		System.out.println("==========================");
		System.out.print  ("메뉴 선택 : ");
		a = Integer.parseInt(sc.nextLine());
		
		if(a ==1) {
			money();
		}
		}while(a!=2);
		
		
	
		
	}
		
	
		
		
		
		

	

	private static void money() {
		TreeSet<Integer> Lotto = null;
		
		List<Set> user_Lotto = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
			System.out.println("금액을 입력하시오");
			int money;
		
			money = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<money/1000; i++) {
			Lotto = new TreeSet();
			
			while(Lotto.size()<6) {
				
				Lotto.add((int)(Math.random()*45)+1);
				
			}
			System.out.println(i+"번째 로또 번호"+Lotto);
			user_Lotto.add(Lotto);
		}
		System.out.println("====================");
		System.out.println("당신이 산 로또 번호");
		System.out.println(user_Lotto);
		System.out.println("====================");
		
		TreeSet<Integer> com_Lotto = new TreeSet<>();
		while(com_Lotto.size()<6) {
			com_Lotto.add((int)(Math.random()*45)+1);
			for(int a=0; a<user_Lotto.size(); a++) {
			if(com_Lotto == user_Lotto.get(a)) {
				System.out.println("축하합니다 로또 1등입니다");
				}
			}
		}
		System.out.println("00회차 로또 1등 번호 알아서 보세요");
		System.out.println(com_Lotto);
 		
		int changeMoney = money%1000;
		System.out.println("거스름돈 : "+ changeMoney);
		
		
	}

}
