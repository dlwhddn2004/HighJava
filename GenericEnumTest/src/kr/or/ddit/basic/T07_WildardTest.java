package kr.or.ddit.basic;

import java.util.Arrays;

public class T07_WildardTest {
/*
 * 	와일드 카드 예제
 * 
 * 	<? extends T> : 와일드 카드의 상한 제한. T와 그 자손들만 가능
 * 	<? super T>   : 와일드 카드의 하한 제한. T와 그 조상들만 가능 <Object 제외>
 * 	<?>		  	  : 제한없음. 모든 타입이 가능. <? exnteds Object>와 동일 object는 
 */
	
	/*
	 * 모든 과정 등록
	 * @param course 모든과정
	 */
	public static void registerCource(Course<?> course) {
		System.out.println(course.getName()+ "수강생 : "+ Arrays.toString(course.getstudents()));
		
	}
	
	
	/*
	 * 학생 과정 등록
	 * @param course
	 *public static void Student<T> registerCourceSudent(Student<T> course) 의미와 동일
	 */
	
	public static void registerCourceSudent(Course<? extends Student> course) {
		System.out.println(course.getName()+ "수강생 : "+ Arrays.toString(course.getstudents()));
		
	}
	
	/*
	 * 직장인 과정
	 * @param course
	 */
	public static void registerCourceworker(Course<? super Worker> course) {
		System.out.println(course.getName()+ "수강생 : "+ Arrays.toString(course.getstudents()));
		
	}
	//나중가면 Person클래스 T가 person을 나타내는데 person의 하위 객체들도 다 넣을수잇음
	public static void main(String[] args) {
		Course<Person> personCourse = new Course("일반인과정", 5); 
		personCourse.add(new Person("일반인1"));
		personCourse.add(new Worker("직장인1"));
		personCourse.add(new Student("학생1"));
		personCourse.add(new HighStudent("고등학생1"));
		
		Course<Worker> workerCourse = new Course("직장인과정",5);
		workerCourse.add(new Worker("직장인1"));
		
		Course<Student> studentCourse = new Course("학생과정",5);
		studentCourse.add(new Student("학생1"));
		studentCourse.add(new HighStudent("고등학생1"));
		
		Course<HighStudent> highstudentCourse = new Course("고등학생과정",5);
		highstudentCourse.add(new HighStudent("고등학생1"));
		
		registerCource(personCourse);
		registerCource(workerCourse);
		registerCource(studentCourse);
		registerCource(highstudentCourse);
		System.out.println("------------------------------------------");
		
		//registerCourceSudent(personCourse);
		//registerCourceSudent(workerCourse);
		registerCourceSudent(studentCourse);
		registerCourceSudent(highstudentCourse);
		System.out.println("------------------------------------------");
		
		registerCourceworker(personCourse);
		registerCourceworker(workerCourse);
		//registerCourceworker(studentCourse);
		//registerCourceworker(highstudentCourse);
		
		
		
	}
	
}

//일반인
class Person {
	String name; // 이름
	
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "이름 : " + name;
	}
}


//근로자
class Worker extends Person{
	
	public Worker(String name) {
		super(name);
	}
}

//학생
class Student extends Person{
	
	public Student(String name) {
		super(name);
	}
}


//고등학생
class HighStudent extends Student{
	
	public HighStudent(String name) {
		super(name);
	}
}


//수강코드
class Course<T>{
	private String name; //코드명
	private T[] students; //수강생(제너릭 배열) 
	
	public Course(String name, int capacity) {
		this.name = name;
		//타입 피라미터로 배열을 생성시 오브젝트 배열을 생성후, 타입 피라미터 배열로
		//캐스팅 처리해야한다.
		students = (T[])(new Object[capacity]);
	}
	
	
	//코스명 조회
	public String getName() {return name;}
	
	
	//수강생 조회
	public T[] getstudents() {return students;}
	
	
	//수강생 등록
	public void add(T t) {
		for(int i=0; i< students.length; i++) {
			if(students[i] ==null) { //아직 등록되지 않은 자리확인
				students[i] = t;
				break;
			}
		}
	}
	
	
}
