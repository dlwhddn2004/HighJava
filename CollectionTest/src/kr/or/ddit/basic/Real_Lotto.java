package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Real_Lotto{

	/**
	 * 
	 * @param args
	 * 
	 * 메인 메소드
	 */
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      int input = 0;
      
      do {
      System.out.println("==========================");
      System.out.println("\t1. Lotto 프로그램\t");
      System.out.println("\t2. 프로그램 종료\t");
      System.out.println("==========================");
      System.out.print  ("메뉴 선택 : ");
      input = Integer.parseInt(s.nextLine());
      
      if(input ==1) {
         generate_lotto();
      }
      }while(input != 2);
      
   }
      
   /**
    * 1. 로또 프로그램 선택 시 실행
    * 
    * - 입력한 금액만큼 로또 번호 생성
    */
   private static void generate_lotto() {
	   
	   Scanner s = new Scanner(System.in);
	   
	   System.out.print  ("금액 입력 : ");
	   int input_money = s.nextInt();
	   
	   TreeSet<Integer> hs = null;
	   
	   ArrayList<TreeSet<Integer>> user_lotto = new ArrayList<TreeSet<Integer>>();
	   
	   for(int i = 0; i < input_money / 1000; i++) {
		   hs = new TreeSet();
		   while(hs.size() < 6) {
			   hs.add((int)(Math.random() * 45) + 1);
		   }
		   System.out.println(i + 1 + "번째 : " + hs);
		   user_lotto.add(hs);
	   }
	   
	   System.out.println("user_lotto(ArrayList) : " + user_lotto);
	   
	   TreeSet<Integer> lotto = new TreeSet<Integer>();
	   
	   while(lotto.size() < 6) {
		   lotto.add((int)(Math.random() * 45) + 1);
	   }
	   
	   Iterator it2 = lotto.iterator();
	   
	   ArrayList<Integer> lotto_list = new ArrayList<Integer>();
	   
	   while(it2.hasNext()) {
		   lotto_list.add((Integer) it2.next());
	   }
	   
	   int count = 0;
	   
	   System.out.println("이번 주 로또 번호 : " + lotto_list);
	   
	   for(int i = 0; i < user_lotto.size(); i++) {
		   count = 0;
		   
		   TreeSet<Integer> user_lotto1 = user_lotto.get(i);
		   Iterator it = user_lotto1.iterator();
		   
		   ArrayList<Integer> user_lotto2 = new ArrayList<Integer>();
		   
		   while(it.hasNext()) {
			   user_lotto2.add((Integer) it.next());
		   }
		   
		   for(int j = 0; j < lotto_list.size(); j++) {
			   for(int k = 0; k < user_lotto2.size(); k++) {
				   if(lotto_list.get(j) == user_lotto2.get(k)) {
					   count += 1;
				   }
			   }
		   }
		   
		   System.out.println(i + "번째 : " + user_lotto2);
		   
		   if(count == 6) {
			   System.out.println("1등입니다.");
		   }else if(count == 5) {
			   System.out.println("2등입니다.");
		   }else if(count == 4) {
			   System.out.println("3등입니다.");
		   }else {
			   System.out.println("꽝입니다.");
		   }
		   
	   }
   }

}