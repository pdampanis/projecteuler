import java.io.BufferedReader;
import java.io.FileReader;



public class Problem59 {
	
	public static int fact(int a){
		int g = 1;
		for(int i = 0; i < a; i++){
			g *= (i + 1);
		}
		return g;
	}

	public static void doSomething(){
		String[] ab = { "a", "b", "c", "d", "e", "f", "g",
				"h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z" };
		int count = 0;
		String[] comb = new String[2600];
		for(int i = 0; i < ab.length - 2; i++){
			for(int j = i+1; j < ab.length - 1; j++){
				for(int k = j+1; k < ab.length; k++){
					comb[count++] = ab[i]+ab[j]+ab[k];
				}
			}
		}

		for(int i = 0; i < comb.length; i++)
			System.out.println(comb[i] + " ");
		
	}
	
	public static String intToString(int[] a){
		String temp = "";
		for(int i = 0; i < a.length; i++)
			temp += Integer.toString(a[i]);
		return temp;
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
	
	public static void permute(String beginningString, String endingString) {
	    if (endingString.length() <= 1)
	      System.out.println(beginningString + endingString);
	    else
	      for (int i = 0; i < endingString.length(); i++) {
	        try {
	          String newString = endingString.substring(0, i) + endingString.substring(i + 1);

	          permute(beginningString + endingString.charAt(i), newString);
	        } catch (StringIndexOutOfBoundsException exception) {
	          System.out.println(exception);
	        }
	      }
	}
	      
	
	
	public static void main(String[] args) {
		
		char ch = 'a';
		System.out.println(ch);
		int c = ch;
		int k = c^42;
		char s = (char)k;
		int p = s;
		System.out.println(c+" "+k+" "+s+" "+p);
		try{
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/Panos/jworkspace/Euler - Problems/src/cipher1.txt"));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            //sb.append('\n');
	            line = br.readLine();
	        }
	        String everything = sb.toString();
	        br.close();
	    	System.out.println(everything);
	    	System.out.println(everything.length());
	    	
	    	int[] array = new int[everything.length()];
	    	int j = 0, i = 0, l =0;
	    	int[] arr = new int[2];
	    	int count = 0;
	    	
	    	while(i < everything.length()){
	    		if( everything.charAt(i) != ',' ){
	    			
	    			arr[l++] = Character.getNumericValue(everything.charAt(i++));
	    			count++;
	    		}
	    		else
	    		{
	    			if(count == 1) array[j++] = arr[0];
	    			if(count == 2) array[j++] = arr[0]*10 + arr[1];
	    			count = 0;
	    			i++;
	    			l = 0;
	    			arr[0] = 0;
	    			arr[1] = 0;
	    			
	    			}
	    		
	    	}
	    	array[j++] = arr[0]*10 + arr[1];
	    	System.out.println("j = "+j);
	    	
	    	for(i = 0; i < j; i++)
	    		System.out.print(array[i]+" ");
	    	i = 0;
	    	count = 0;
	    	while(i < everything.length()){
	    		if(everything.charAt(i++) == ',')
	    			count++;
	    	}
	    	System.out.println();
	    	System.out.println(everything.length() - count);
	    	
	    	//doSomething();
	    	int[] number = new int[3];
	    	for(i = 0; i < number.length; i++)
	    		number[i] = i+1;
	    	
	    	
	    	String[] perms = findPerms(number);
	    	for(i = 0; i < perms.length; i++)
	    			System.out.println(i+1+". "+perms[i]);
	    	char c1 = 'a',c2 = 'b', c3 = 'c';
	    	int x1 = c1, x2 = c2, x3 = c3;
	    	int[] x = {x1,x2,x3};
	    	for(i = 0; i < x.length; i++)
	    		System.out.print(x[i]+" ");
	    	String[] perms2 = findPerms(x);
	    	for(i = 0; i < perms2.length; i++)
	    		System.out.println(i+1+". "+perms2[i]);
	    	
	    } catch(Exception e) {
	        System.out.println(e);
	    }
		
	
		

	}

}
