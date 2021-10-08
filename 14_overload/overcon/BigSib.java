public class BigSib{
  private String helloMsg;

  public BigSib(String hello){
    helloMsg = hello;
  }

  public String greet(String name){
    return (helloMsg + " " + name);
  }
}
