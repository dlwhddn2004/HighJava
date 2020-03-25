package kr.or.ddit.basic;


/*
 *  제너릭메서드 <T, R> method(T t)
 *  
 *  	파라미터 타입과 리턴타입으로 타입 피라미터(글자)를 가지는 메서드
 *  
 *  	선언방법 : 리턴타입 앞에 <> 기호를 추가하고 타입 피라미터를 기술 후 사용
 */
class Util{ //제너릭클래스를 쓰는 메서드는 같이 제너릭 해줘~그래야 알지
	public static <K, V> boolean Compare(Pair<K,V> p1, Pair<K,V> p2) {
		boolean KeyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		return KeyCompare && valueCompare;
	}
}

class Pair<K,V>{
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
}



public class T04_GenericMethodTest {

	public static void main(String[] args) {
		
		Pair<Integer, String> p1 = 
				new Pair<Integer, String>(1, "홍길동");
		
		Pair<Integer, String> p2 =
				new Pair<Integer, String>(1, "홍길동");
		
		//구체적 타입을 명시적으로 지정(생략가능)
		boolean result1 = Util.<Integer, String >Compare(p1, p2);
		
		if(result1) {
			System.out.println("논리적(의미)으로 동일한 객체임");
		}else {
			System.out.println("논리적(의미)으로 동일한 객체아님");
		}
		
		Pair<String, String> p3 = new Pair<>("001","홍길동");
		Pair<String, String> p4 = new Pair<>("002","홍길동");
		
		boolean result2 = Util.Compare(p3, p4);
		
		if(result2) {
			System.out.println("논리(의미)적으로 동일한 객체임");
		}else {
			System.out.println("논리(의미)적으로 동일한 객체 아님.");
		}
		
		
		
		
	}
}
