
public class Problem39 {
	
	public static boolean isRightT(int a,int b,int c){
		if(c*c == a*a + b*b) return true;
		return false;
	}
	
	public static void main(String[] args) {
		
		int a,b,count,max,maxp=0;
		double c;
		max = 0;
		for(int i = 1; i <= 1000; i++){
			count = 0;
			for(a = 1; a <= i/4; a++){
				for(b = 1; b <= (i-a)/2; b++){
					c = Math.pow(a*a+b*b, 0.5);
						if((a+b+c == i) && (c > b && b >= a)) {
							//System.out.println("{"+a+","+b+","+c+"}");
							count++;
						}
					
				}
			}
			//System.out.println("count "+count);
			if(count > max){
				max = count;
				maxp = i;
			}
			//System.out.println("max "+max);
			System.out.println(i);
		}
		
		System.out.println("definite max is "+max+" and maxp is "+maxp);
	}

}
