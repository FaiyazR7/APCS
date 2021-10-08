/*
Purple Turtle- Faiyaz Rafee (Pivot and Atlas), Yuki Feng (Paul), Ivina Wang (Sealie) 
APCS
HW14 -- Customize your creation/Overloaded and default constructors
2021/10/7

DISCO:
Static cannot be used as that would set the constructors the same in all 4 instances of BigSib.
Overloaded constructors have to come after the default constructor if using multiple constructors.

QCC:
How do you use one constructor for all 4 instances of BigSib?
Why does where the overloaded constructor is in the code matter if Java is a compiled language?
*/
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
