package kr.or.ddit.basic;

public class Planet {

	public enum planet{
		수성(2439), 
		금성(6052), 
		지구(6371), 
		성(3390), 
		목성(69911), 
		토성(58232), 
		천왕성(25362), 
		해왕성(24622);
		
		private double str;
		
		planet(double data){
			str = data * data * 3.14;
		}
		public Double getStr() {
			return str;
		}
		
	}
	
	public static void main(String[] args) {
		planet[] arr = planet.values();
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i].name()+ ","+ Math.round(arr[i].getStr()));
			
		}
	}
	
}
