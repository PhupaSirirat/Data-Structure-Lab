

class BST {
    public BTNode root;
    public int size;
    BST(){
        this.root=null;
        size = 0;
    }

    /**
     * @return the root
     */
    private BTNode getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    private void setRoot(BTNode root) {
        this.root = root;
    }


}