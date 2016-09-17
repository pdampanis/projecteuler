
public class Problem44 {

	public static int P(int num){
		return num*(3*num - 1) / 2;
	}
	
	public static boolean isP(int num){
		double a = (Math.pow((24*num + 1), 0.5) + 1) / 6;
		if(a == Math.floor(a)) return true;
		else return false;
	}
	public static void main(String[] args) {
		
		
		int[] p = new int[10000];
		for(int i = 0; i < 10000; i++)
			p[i] = P(i);
		
		outerloop:
		for(int i = 1; i < 10000; i++){
			for(int j = i + 1; j < 10000; j++){
				if(isP(p[i] + p[j]) && isP(Math.abs(p[i] - p[j]))){
					int D = Math.abs(p[i] - p[j]);
					System.out.println(D);
					break outerloop;
				}
			}
		}
		
	}

}
