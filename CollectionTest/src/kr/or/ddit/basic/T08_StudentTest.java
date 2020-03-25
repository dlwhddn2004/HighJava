package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 *  문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버변수로 갖는
 *  Student클래스를 만든다.
 *  생성자는 학번,이름,국어,영어,수학 점수만 매개변수로 받아서 처리한다.
 *  
 *  이 Student객체들은 List에 저장하여 관리한다.
 *  List에 저장된 데이터들을 학번의 오름차순으로 정렬 하여 출력하는 부분과
 *  총점의 역순으로 정렬하는 부분을 프로그램 하시오.
 *  (총점이 같으면 학번의 내림차순으로 정렬되도록 하라)
 *  (학번의 정렬기준은 student클래스 자체에서 제공하도록 하고 총점 정렬기준은 외부 클래스에서 제공하도록 한다.) 
 */
public class T08_StudentTest {
	
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("1356012","이종우",65,50,30));
		list.add(new Student("1234034","박희찬",65,50,30));
		list.add(new Student("2345634","김철수",87,42,42));
		list.add(new Student("5467657","이재호",87,42,42));
		list.add(new Student("8769678","구마적",100,100,90));
		
		for(Student total : list) { //정렬을 하기전에 랭크를 1로 다 초기화 해줌
			
			total.setRank(1); 
		}
		
		for(int i=0; i<list.size(); i++) { //랭크를 총점에따라 순위를 매긴다.
			for(int j=0; j<list.size()-1; j++) {
			if(list.get(i).getSum() <list.get(j+1).getSum()) {
				list.get(i).setRank(list.get(i).getRank()+1);
			}
			}			
		}
		
		
		
		
		System.out.println("========================================");
	
		Collections.sort(list);

		System.out.println("학번으로 정렬된 기준");
		
		for(Student hac2 : list) {
			System.out.println(hac2);
			
			
		}
		
		System.out.println("=========================================");
System.out.println("총점 기준으로 역순 ");
		
		Collections.sort(list, new Total());
		
		
		for(Student total : list) {
			
			System.out.println(total);
		}		
		
		for(int i=0; i<list.size()-1; i++) {			
			for(int j=i+1; j<list.size(); j++) {				
			if(list.get(i).getSum() == list.get(j).getSum()) {					
				if(Integer.parseInt(list.get(i).getHac()) < Integer.parseInt(list.get(j).getHac())) {					
					Collections.swap(list, j, i);					
				}
			}
			}
		}
		System.out.println("총점으로 정렬 한후 총합이 같을경우 학번으로 정렬");
		System.out.println("=============================================");
		for(Student hac : list) {
			System.out.println(hac);
		}
	}

		
}

class Student implements Comparable<Student>{
	private String hac;
	private String name;
	private int kog;
	private int eng;
	
	public Student(String hac, String name, int kog, int eng, int math) {
		super();
		this.hac = hac;
		this.name = name;
		this.kog = kog;
		this.eng = eng;
		this.math = math;
		this.sum = kog+eng+math;
		
	}

	private int math;
	private int sum ;
	private int rank;
	
	//학번으로 오름차순 정렬
	@Override
	public int compareTo(Student hac) {
		
		return getHac().compareTo(hac.getHac());
	}

	public String getHac() {
		return hac;
	}

	public void setHac(String hac) {
		this.hac = hac;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKog() {
		return kog;
	}

	public void setKog(int kog) {
		this.kog = kog;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "Student [hac=" + hac + ", name=" + name + ", kog=" + kog + ", eng=" + eng + ", math=" + math + ", sum="
				+ sum + ", rank=" + rank + "]";
	}
	
}

class Total implements Comparator<Student>{
	//총점의 역순으로 정렬
	@Override
	public int compare(Student sum1, Student sum2) {
		
		
		return new Integer(sum1.getSum()).compareTo(sum2.getSum()) *-1;
	}
	//만약 총점으로 내림차순 하는데 총점이 같고 학번을 내림차순으로 정렬한다면?
	/*
	 * public int compare(Student sum1, Student sum2) {
		if(sum1.getSum() == sum2.getSum()){
			return sum1.gethac().compareTo(sum2.gethac()) *-1;
		}else{
			return new Integer(sum1.getSum()).compareTo(sum2.getSum()) *-1;
		}
	}
	 */
}
