// Team Acid: Yuki Feng, Tasnim Chowdhury, Faiyaz Rafee
// APCS pd08
// HW75: Node Recall
// 2022-03-09
// time spent: 0.5 hrs

public class LLNode {

    private String value;
    private LLNode cdr;

    public LLNode( String value, LLNode cdr){
         this.value = value;
         this.cdr = cdr;
    }

    public String car(){
        return value;
    }

    public LLNode cdr(){
        return cdr;
    }

    public void setCar( String value ){
        this.value = value;
    }

    public void setCdr( LLNode cdr ){
        this.cdr = cdr;
    }

}
