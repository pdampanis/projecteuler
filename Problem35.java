
public class Problem35 {
	
	public static int binary_search(int A[], int key, int imin, int imax)
	{
	  // test if array is empty
	  if (imax < imin)
	    // set is empty, so return value showing not found
	    return -1;
	  else
	    {
	      // calculate midpoint to cut set in half
	      int imid = (imin + imax) / 2;
	 
	      // three-way comparison
	      if (A[imid] > key)
	        // key is in lower subset
	        return binary_search(A, key, imin, imid-1);
	      else if (A[imid] < key)
	        // key is in upper subset
	        return binary_search(A, key, imid+1, imax);
	      else
	        // key has been found
	        return imid;
	    }
	}
	
	
	public static String intToString(int[] a){
		String temp = "";
		for(int i = 0; i < a.length; i++)
			temp += Integer.toString(a[i]);
		return temp;
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
		int index = -1;
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
	
	public static void main(String[] args) {
		int[] number = {1,9,7};
		String[] perms = findPerms(number);

		char c = Character.forDigit(number[0], 10);
		System.out.println(c);
		for(int i = 0; i < perms.length - 1; i++){
			if( perms[i].charAt(0) == c ) // || perms[i].charAt(0) == number[1] || perms[i].charAt(0) == number[2]  )
				System.out.println(perms[i]);
		}
	}

}
