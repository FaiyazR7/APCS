// Blue Steaks - Max Schneider, Faiyaz Rafee, David Deng
// APCS pd7
// HW41 -- Be Rational
// 2021-11-30
/**
Disco:
  Something in our plan was bad, but we got lucky and it didn't translate to the code
  Keep-Change-Flip remains top-tier
QCC:
  Is "this" important?
time spent: 0
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
    return ("(" + numerator + ", " + denominator + ")");
  }
  public float floatValue () {
    return (float)numerator/(float)denominator;
  }
  public void multiply (Rational r) {
    this.numerator=this.numerator*r.numerator;
    this.denominator=this.denominator*r.denominator;
  }
  public void divide (Rational r) {
    this.numerator=this.numerator*r.denominator;
    this.denominator=this.denominator*r.numerator;
  }
  public static void main(String[] args) {
    Rational r1 = new Rational();
    Rational r2 = new Rational(1,2);
    Rational r3 = new Rational(1,3);
    Rational r5 = new Rational(2,2);
    Rational r6 = new Rational(3,3);
    Rational r7 = new Rational(8,1);
    Rational r8 = new Rational(4,1);

    System.out.println(r1.toString());
    System.out.println(r2.toString());
    System.out.println(r3.toString());

    System.out.println(r1.floatValue());
    System.out.println(r2.floatValue());
    System.out.println(r3.floatValue());

    r5.multiply(r6);
    System.out.println(r5.toString());

    r7.divide(r8);
    System.out.println(r8.toString());
  }
}
