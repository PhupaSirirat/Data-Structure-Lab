import java.util.LinkedList;
import java.util.Queue;

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

    public int getMax() {
        //TODO:HERE
        return findMax(this.root);
    }

    public void remove(int newElement) {
        //TODO:HERE
        delete(this.root, newElement);
    }

    public void printTree(){
        //TODO:HERE
        recursive_printTree(this.root);
        System.out.println();
    }



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
    private int findMax(BTNode root){
        if (root == null)
            return Integer.MIN_VALUE;

        int res = root.getElement();
        int lres = findMax(root.left);
        int rres = findMax(root.right);

        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }
    private BTNode delete(BTNode root, int element){
        if (root == null)
            return null;

        if (root.getLeft() == null && root.getRight() == null) {
            return root.getElement() == element ? root : null;
        }

        BTNode keyNode = null, temp = null, last = null;
        Queue<BTNode> q = new LinkedList<>();
        q.offer(root);

        // Do level order traversal to find deepest
        // node(temp), node to be deleted (key_node)
        // and parent of deepest node(last)
        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp.getElement() == element)
                keyNode = temp;

            if (temp.getLeft() != null) {
                last = temp; // storing the parent node
                q.offer(temp.getLeft());
            }

            if (temp.getRight() != null) {
                last = temp; // storing the parent node
                q.offer(temp.getRight());
            }
        }

        if (keyNode != null) {
            // replacing key_node's data to deepest node's data
            keyNode.setElement(temp.getElement());

            assert last != null;
            if (last.getRight() == temp) {
                last.setRight(null);
            }
            else {
                last.setLeft(null);
            }
        }
        return root;
    }


}