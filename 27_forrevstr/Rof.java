public class Rof {
  public static String fenceF(int posts){
    String fence = "|";

    for(int i = 1; i < posts; i++){
      fence = fence + "--|";
    }
    return fence;
  }

  public static String reverseF(String s){
    String a = "";
    for(int i=s.length()-1; i>=0; i--){
      a += s.substring(i);
      s = s.substring(0,i);
    }
    return a;
  }

  public static String reverseR(String s){
    String a = "";
    int length = s.length() - 1;
    if(s.length()==1){
      a += s;
    }
    a += s.substring(length );
    return a + reverseR(s.substring(0, length - 1);
  }

  public static void main( String [] args) {
    System.out.println(fenceF(5));
    System.out.println(reverseF("stressed"));
		System.out.println(reverseR("stressed"));
  }
}

