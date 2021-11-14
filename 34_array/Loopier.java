import java.lang.Object;
public class Loopier {
	public static void populateArray(int[] x,int num) {
		x = new int[num];
		for (int i = 0; i < num; i ++) {
			int e =(int)(Math.random()* 100);
			x[i] = e;
		}
	}

	public static String arrayToString(int[] x) {
		String t = "{";
		for (int i = 0; i < getLength(x);i ++) {
			t += x[i].toString();
			t += ", ";
		}
		t+="}";
		return t;
	}
	public static void main(String[] args) {
		int[] r;
		populateArray(r,5);
		System.out.println(arrayToString(r));
	}


}
