

class BST {
    private BTNode root;

    BST(){
        this.root=null;
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

    public void add(int newElement) {
        //TODO:HERE
        root = recursive_add(this.root, newElement);
    }

    public void printTree(){
        //TODO:HERE
        recursive_printTree(this.root);
    }

//  additional method
    private BTNode recursive_add(BTNode root, int newElement){
        //tree is empty
        if (root == null) {
            root = new BTNode(newElement,null,null);
            return root;
        }
        //traverse the tree
        if (newElement < root.getElement())     //insert in the left subtree
            root.left = recursive_add(root.getLeft(), newElement);
        else if (newElement > root.getElement())    //insert in the right subtree
            root.right = recursive_add(root.getRight(), newElement);
        return root;
    }
    private void recursive_printTree(BTNode node){
        if (node != null) {
            recursive_printTree(node.getLeft());
            System.out.print(node.getElement() + ",");
            recursive_printTree(node.getRight());
        }
    }


}