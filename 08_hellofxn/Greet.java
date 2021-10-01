/*Faiyaz Rafee
APCS
HW08 -- Refractor Freshie Zero/Printing strings
2021-09-30

Notes: You need to use javac first to save the changes otherwise the file runs as it was before editing.
*/
	public class Greet {
		public static void main (String [] args){
			greet("Max");
			greet("May");
			greet("Salaj");
		}
		static void greet(String str){
			System.out.println("Hi, how was your day " + str + " ?");
	}
	}
