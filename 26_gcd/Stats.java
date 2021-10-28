/*
THE CATS: Perry Huang, Faiyaz Rafee, Xinqing Lin
APCS
HW26 -- Recursive vs Iterative vs Brute force/3 ways of figuring out GCD/summary
2021-10-27
time spent: started 9:22 ended ____
DISCO:

QCC:

*/
public class Stats {

  public static int gcd( int a, int b) {
    int i = 0;
  	while (i % a != 0 && i % b != 0){
      i = i + 1;
    
    }
  }
 
 public static int gcdER( int a, int b) {
    if (a == b) {
      return a;
    }
    else if (a > b) {
      return gcdER(a-b, b);
    }
    else {
      return gcdER(a, b-a);
    }
  } 
  public static int gcdEW( int a, int b) {
    while (a != b){
      if (a > b) {
        a = a - b;
      }
      if (b > a) {
        b = b - a;
      }
    }  
    return a;
  } 
  
  public static void main(String args[]) {
    System.out.println(gcdER(15, 18));
    System.out.println(gcdER(16, 28));
    System.out.println(gcdEW(15, 18));
    System.out.println(gcdEW(16, 28));
    System.out.println(gcd(15, 18));
    System.out.println(gcd(16, 28));
	}
}
