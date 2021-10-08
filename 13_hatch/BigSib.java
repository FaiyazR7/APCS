/*
Faiyaz Rafee and Perry Huang
APCS
HW13 -- Where do BigSibs come from?/Working with constructors
2021-10-6
DISCOS
A constructor is a method that runs whenever a class is called to another class using the NEW command.
QCC
Why does constructors not use any keywords such as static or void. Why cant i use void if void returns no value and it is the same with constructors?
*/
public class BigSib{
	public BigSib() {
	System.out.print("Word up ");
	}
	public static void setHelloMsg(String str) {
		System.out.print(str + " ");
	}
	public static String greet(String str) {
		return str;
	}}
