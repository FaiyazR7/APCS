// Blue Steaks - Max Schneider, Faiyaz Rafee, David Deng
// APCS pd7
// HW42 -- Be Rational
// 2021-12-02
/**
Disco:
  Power of a dummy instance of a class
  Power of this
  Importance of organized main method to see if code works
  Importance of java visualizer
QCC:
  More efficient ways to copy an instance
  Better methods to add and subtract
time spent: .2
**/

public class Rational {
  private int numerator;
  private int denominator;

  public Rational (){
    numerator = 0;
    denominator = 1;
  }
  public Rational (int a, int b) {
    numerator=a;
    denominator=b;
  }

  public String toString() {
    return ("(" + numerator + " / " + denominator + ")");
  }

  public void add (Rational r) {
    Rational dummy2 = new Rational(r.numerator,r.denominator);
    Rational dummy = new Rational(this.numerator,this.denominator);
    this.numerator*=r.denominator;
    this.denominator*=r.denominator;
    dummy2.numerator*=dummy.denominator;
    dummy2.denominator*=dummy.denominator;
    this.numerator+=dummy2.numerator;
  }


  public void subtract (Rational r) {
    Rational dummy2 = new Rational(r.numerator,r.denominator);
    Rational dummy = new Rational(this.numerator,this.denominator);
    this.numerator*=r.denominator;
    this.denominator*=r.denominator;
    dummy2.numerator*=dummy.denominator;
    dummy2.denominator*=dummy.denominator;
    this.numerator-=dummy2.numerator;
  }

  public int GCD () {
    int a = this.numerator;
    int b = this.denominator;
    int c = 1;
    int answer = 0;
    while (c <= a) {
      if (a%c==0 && b%c==0) {
        answer=c;
        }
      c++;
      }
    return answer;
  }

  public void reduce () {
    int divisor = this.GCD();
    this.numerator /= divisor;
    this.denominator /= divisor;
  }

  public int compareTo (Rational R) {
    Rational dummy = new Rational(this.numerator, this.denominator);
    dummy.subtract(R);
    return dummy.numerator;
  }

  public static void main(String[] args) {
   Rational r1 = new Rational(1,2);
   Rational r2 = new Rational(3,2);

   r1.add(r2);
   System.out.println("1/2 + 3/2 = 8/4: " + r1);

   System.out.println("GCD of 8 and 4 = 4: "+ r1.GCD());

   r1.reduce();
   System.out.println("8/4 = 2/1: "+r1);

   r1.subtract(r2);
   System.out.println("2/1 - 3/2 = 1/2: " + r1);

   Rational r3 = new Rational(1,4);
   Rational r4 = new Rational(2,4);
   Rational r5 = new Rational(3,4);

   System.out.println("1/2 > 1/4 yields 2: " + r1.compareTo(r3));
   System.out.println("1/2 = 2/4 yields 0: " + r1.compareTo(r4));
   System.out.println("1/2 < 3/4 yields -2: " + r1.compareTo(r5));
  }
}
