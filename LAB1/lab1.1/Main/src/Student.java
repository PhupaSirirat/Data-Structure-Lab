public class Student {
    private String fname, lname, ID;
    private Float GPAX;

    public Student(String ID){
        this.ID = ID;
    }
    public Student(String ID, String fname, String lname, Float GPAX) {
        this.ID = ID;
        this.fname = fname;
        this.lname = lname;
        this.GPAX = GPAX;
    }

    public void setGPAX(Float GPAX){
        this.GPAX = GPAX;
    }
    public String getID(){
        return this.ID;
    }
    public String getFname(){
        return this.fname;
    }
    public String getLname(){
        return this.lname;
    }
    public Float getGPAX(){
        return this.GPAX;
    }

    public boolean equals(Object e){
        if(e.getClass().equals(this.getClass()) && ((Student) e).getID().equals(this.ID)){
            return true;
        }
        return false;
    }
    public String toString(){
        return ""+ID+","+fname+","+lname+","+GPAX;
    }
}
