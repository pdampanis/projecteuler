import java.math.BigInteger;
import java.util.Arrays;


public class Problem29 {
	
	public static int partition(BigInteger arr[], int left, int right)

	{

		int i = left, j = right;

	      BigInteger tmp;

	      BigInteger pivot = arr[(left + right) / 2];

	     

	      while (i <= j) {
	    	  
	            while (arr[i].compareTo(pivot) < 0)

	                  i++;

	            while (arr[j].compareTo(pivot) > 0)

	                  j--;

	            if (i <= j) {

	                  tmp = arr[i];

	                  arr[i] = arr[j];

	                  arr[j] = tmp;

	                  i++;

	                  j--;

	            }

	      }

	     

	      return i;

	}

	 

	public static void quickSort(BigInteger arr[], int left, int right) {

	      int index = partition(arr, left, right);

	      if (left < index - 1)

	            quickSort(arr, left, index - 1);

	      if (index < right)

	            quickSort(arr, index, right);

	}
	
	public static BigInteger pow(int b, int e){
	      BigInteger r = BigInteger.ONE;
	      for(int i = 1; e >= i; i++)
	         r = r.multiply(BigInteger.valueOf(b));
	      return r;
	   }

	public static void main(String[] args) {
		
		BigInteger[] b = new BigInteger[98*98];
		int k = 0;
		for(int i = 2; i < 100; i++){
			for(int j = 2; j < 100; j++){
				b[k++] = BigInteger.valueOf(i).pow(j);
			}
			
		}

		
		quickSort(b, 0, b.length - 1);
		//System.out.println(Arrays.toString(b));
		int n = 98*98;
		BigInteger prev = b[0];
		for(int i = 1; i < b.length; i++){
			if(b[i] == prev) n--;
			prev = b[i];
		}
			System.out.println(98*98+" "+n);
		

	}

}
