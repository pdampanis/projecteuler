public class Problem43 {

	public static String intToString(int[] a){
		String temp = "";
		for(int i = 0; i < a.length; i++)
			temp += Integer.toString(a[i]);
		return temp;
	}
	
	public static long StringtoInt(String s){
		int j = 0; 
		long sum = 0;
		for(int i = s.length() - 1; i >= 0; i--)
			sum += Character.getNumericValue(s.charAt(j++)) * Math.pow(10, i);
		return sum;
	}
	
	public static int fact(int a){
		int g = 1;
		for(int i = 0; i < a; i++){
			g *= (i + 1);
		}
		return g;
	}
	
	public static int findIndexK(int[] a){
		int k = 0, c = 0;
		int index = -1;;
		for(k = 0; k < (a.length - 1); k++){
			if(a[k] < a[k+1])
				index = k;
			else 
				c++;
		}
		
		if(c == a.length - 1) return -1;
		return index;
	}
	
	public static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static int[] findNextPerm(int[] a, int indexK){
		int i = 0,indexL = -1;
		for(i = indexK + 1; i < a.length; i++){
			if(a[indexK] < a[i])
				indexL = i;
		}
		swap(a, indexK, indexL);
		
		if( (indexK + 1 == indexL) && (indexL == a.length - 1) ) return a;
		else{
			int j = 0;
			int[] temparr = new int[a.length - (indexK + 1)];
			
			for(i = a.length - 1; i >= (indexK + 1); i--)
				temparr[j++] = a[i];
			
			j = 0;
			for(i = indexK + 1; i < a.length; i++)
				a[i] =temparr[j++];
			
			return a;
		}
		
	}
	
	public static String[] findPerms(int[] a){
		int indexK = findIndexK(a);
		int g = fact(a.length);
    	String[] perms = new String[g];
    	perms[0] = intToString(a);
    	int countIndex = 1;
    	while(indexK != -1){
    		int []perm = findNextPerm(a, indexK);
    		perms[countIndex++] = intToString(perm);
    		a = perm;
    		indexK = findIndexK(perm);
    	}
    	return perms;
	}
	
	public static boolean divide(String s){
		int[] n = {2,3,5,7,11,13,17};
		int j = 0;
		for(int i = 1; i < s.length() - 2; i++){
			if( Long.parseLong((s.substring(i, i+3))) % n[j++] == 0 );
			else
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		int[] number = {0,1,2,3,4,5,6,7,8,9};
		String[] perms = findPerms(number);
		
		long sum = 0;
		for(int i = 0; i < perms.length - 1; i++){
			if(divide(perms[i]))
				sum += Long.parseLong((perms[i]));
		}
		System.out.println(sum);
		System.out.println("Time " + (System.currentTimeMillis() - now) / 1000.0 + " second(s).");
	}
}
