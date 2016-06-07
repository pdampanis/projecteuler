import java.math.BigInteger;
import java.util.Arrays;
/**
 *
 * @author Gofoboso
 */
public class Problem104 {
    public static void main(String[] args){
        String start = "";
        String end = "";
        String str2 = "";
        String str = "";       
        int i = 100000;

       while(!(isPan(str) && isPan(str2))){
        start = fib(++i).toString();
        end = start.substring(start.length() - 9, start.length());

        char[] ch2 = end.toCharArray();
        Arrays.sort(ch2);
        str2 = "";
        for(int j = 0; j < ch2.length; j++)
               str2 += ch2[j];
        
        start = start.substring(0, 9);
        char[] ch = start.toCharArray();
        Arrays.sort(ch);
        str = "";
        for(int j = 0; j < ch.length; j++)
               str += ch[j];
       }
        System.out.println(i);
    }
    
    public static BigInteger fib(int n) {
        if(n == 1) return BigInteger.ONE;
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");
        BigInteger c = new BigInteger("0");

        for (int i = 1; i < n; i++) {
          c = BigInteger.ZERO;
          c = c.add(a);
          c = c.add(b);
          a = b;
          b = c;    
        }

        return c;
  }
    
  public static boolean isPan(String str){
      return str.equals("123456789");
  }

}
