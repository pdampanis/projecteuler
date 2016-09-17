public class Problem47 {

   //has 4 distinct prime factors
   public static boolean hasDistPF(int[] p, int number){
      int prime = p[0];
      int i = 1, prev = 1;
      int count = 0;
      while((number != 1) && (i < p.length) ){
         
         if(number % prime == 0){
            if(prev != prime) count++;
            if(count > 4) return false;
            number /= prime;
            prev = prime;
         }
         else
            prime = p[i++];
         
         if((number == 1) && (count < 4))
            return false;
      }
      return true;
   }
   
   public static void main(String[] args) {
      long now = System.currentTimeMillis();
      
      int n = 1000000;
      boolean[] a = new boolean[n];
      for(int i = 0; i < n; i++)
         a[i] = true;
      
      for(int i = 2; i <= Math.sqrt(n-1); i++){
         if(a[i] == true){
            for(int j = (i*i); j <= n-1; j+=i)
               a[j] = false;
         }
      }
      
      int count = 0;
      for(int i = 2; i<=n-1; i++){
         if(a[i] == true) count++;
      }
      
      int[] primes = new int[count];
      int i,j = 0;
      for(i = 2; (i <= n-1) ; i++){
         if(a[i] == true){ primes[j++] = i; }
      }
      
      
      int[] numbers = new int[1000000];
      int num = 1;
      for(i = 0; i < numbers.length; i++)
         numbers[i] = num++;
      
      
      int c = 0;
      outerloop:
      for(i = 0; i < numbers.length; i++){
         for(j = i; j < i + 4; j++){
            if(hasDistPF(primes, numbers[j])) c++;
            else break;
         }
         if(c == 4){
            System.out.println("First " + numbers[i]);
            break outerloop;
         }
         c = 0;
      }
      System.out.println("Time " + (System.currentTimeMillis() - now) / 1000.0 + " second(s).");

   }

}