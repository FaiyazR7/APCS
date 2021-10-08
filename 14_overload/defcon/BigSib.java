public class BigSib{
  private String helloMsg;

  public BigSib(){
    helloMsg = "Word up";
  }

  public String greet(String name){
    return (helloMsg + " " + name);
  }

  public void change(String HelloMsg2) {
    helloMsg = HelloMsg2; 
  }
}
