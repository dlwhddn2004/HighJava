package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class ListTest {
public static void main(String[] args) {
   
     //1
    List list = new ArrayList();
    List abc = new ArrayList();
    abc.add("가");
    abc.add("나");
    abc.add("다");
    
    list.add(0, new Integer(123));
    list.add(1, new Character('a'));
    list.add(2, 'b');
    list.add(3, "한국입니다");
    list.add(4, true);
    list.add(5, 3.14);
    list.addAll(5, abc );
    System.out.println(list);
    System.out.println(list.get(6));
    System.out.println("-------------------------");
    
    //2
    for(int i=0; i<list.size(); i++) {
    System.out.println(list.get(i));
    }
    
    //3
    
    int a =   list.indexOf(new Integer(123));
    int b = list.indexOf(new Character('a'));
    System.out.println("a 의 객체 인덱스 위치 반환 값 "+a+ " b의 객체 인덱스 위치 반환 값 "+ b);
    System.out.println("---------------------------------------");
    
    //4
    List good = new ArrayList();
    good.add("aaa");
    good.add("bbb");
    good.add("ccc");
    good.add("ddd");
    
    int c = good.lastIndexOf("aaa");
    int d = good.lastIndexOf("ddd");
    System.out.println(c+","+d);
    System.out.println("---------------------------------------");
    
    //5 ListIterator는 양방향으로의 이동이 가능
    System.out.println(good);
    
    System.out.println("good listIterator(2).nextIndex() ");
    System.out.println(good.listIterator(2).nextIndex());
    System.out.println("-------------------------------");
    
    //6
    System.out.println(list);
    String temp = (String)list.remove(3);
    System.out.println("삭제된 자료 : "+temp);
    System.out.println("삭제 후 "+ list);
    System.out.println();
 //7
   list.clear();
   
   
   list.add(0, new Character('a'));
   list.add(1, new Integer(12345));
   list.add(2,"aaa");
   list.add(3, 678);
   
   
   
   List String_1 = new ArrayList();
   String_1.add("aaa");
   String_1.add("bbb");
   String_1.add("ccc");
   String_1.add("ddd");
   
   for(int i=0; i<list.size()-1; i++) {
      list.set(i, String_1);
   }System.out.println(list);
   
   list.clear();
   String_1.clear();
   
   System.out.println("list =" +list +"," +"String_1"+String_1);
   
   list.add(0, new Character('a'));
   list.add(1, new Integer(12345));
   list.add(2,"aaa");
   list.add(3, 678);
   list.add(4, new Character('b'));
   
   String_1.add("aaa");
   String_1.add("bbb");
   String_1.add("ccc");
   String_1.add("ddd");
   String_1.add("eee");
   
   System.out.println("list =" +list +"," +"String_1"+String_1);
   
   
   String temp1 = (String)String_1.set(0, "XXX");
   System.out.println("temp :" + temp1);
   System.out.println("String_1"+ String_1);
   System.out.println("------------------------");
   
   //8
   ArrayList<Integer> list2 = new ArrayList<Integer>();
   list2.add(1);
   list2.add(4);
   list2.add(6);
   list2.add(2);
   list2.add(5);
   System.out.println("정렬 전  : " + list2.toString());
   
   System.out.println("오름차순 : " + list2.toString());
   

   
   //9
   System.out.println("---------------------------------");
   System.out.println("list "+ list);
   System.out.println("list.subist(2,4");
   System.out.println(list.subList(2, 4));
   
}
}