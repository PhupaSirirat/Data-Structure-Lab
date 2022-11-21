public class AVLNode extends BTNode {

    private int lefth, righth, weight;
//    AVLNode left, right;

    AVLNode(int element, BTNode left, BTNode right, int lh, int rh, int w) {
        super(element, left, right);
        lefth = lh;
        righth = rh;
        weight = w;
    }

    public int getLH() {return lefth;}
    public int getRH() {return righth;}
    public int getW() {return weight;}
    public void setLH(int l) {lefth = l;}
    public void setRH(int r) {righth = r;}
    public void setW(int w) {weight = w;}

}
