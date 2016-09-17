
public class Problem9 {

	public static void main(String[] args) {
		
		
		int a,b,c;
		int n = 1;

		//do{
		while(true){
			a = 2*n + 1;
			b = 2*n*(n+1);
			c = 2*n*(n+1)+1;
			if(a+b+c == 1000) break;
			//System.out.println(a+" "+b+" "+c);
			n++;
		}
			
		//}while( (a+b+c)!= 10 );
		
		System.out.println(a+" "+b+" "+c);
		System.out.println(a+b+c+"\n"+a*b*c);
	}

}
