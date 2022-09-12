package datastr;

public class ARI{

    String str, zero, subZero, rev;
    public ARI(String str, String zero, String subZero, String reversed){
        this.str = str;
        this.zero = zero;
        this.subZero = subZero;
        this.rev = reversed;
    }

    public void setRev(String reversed){
        this.rev = reversed;
    }

    @Override
    public String toString(){
        return "str\t = "+str+"\nzero = "+zero+"\nsubZ = "+subZero+"\nRev\t = "+rev+
                "\n------------------------";
    }
}
