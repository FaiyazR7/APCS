import java.lang.Object;
public class Loopier {
	public static void populateArray(int[] x) {
		x = new int[num];
		for (int i = 0; i < num; i ++) {
			int e =(int)(Math.random()* 100);
			x[i] = e;
		}
	}

	public static String arrayToString(int[] x) {
		String t = "{";
		for (int i = 0; i < x.length;i ++) {
			t += x[i];
			t += ", ";
		}
		t+="}";
		return t;
	}
	public static void main(String[] args) {
		int[] r = new int[5];
		populateArray(r);
		System.out.println(arrayToString(r));
	}


}
