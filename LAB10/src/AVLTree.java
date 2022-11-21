public class AVLTree extends BST {
    public AVLTree() {
        super();
    }

    public int max(int a, int b) {
        if (a < b) return b;
        return a;
    }

    public void updateHeight(AVLNode r){
        AVLNode pLeft, pRight;
        pRight = (AVLNode) r.getRight();
        pLeft = (AVLNode) r.getLeft();
        if (pLeft != null)
            r.setLH(max(pLeft.getLH(),pLeft.getRH())+1);
        else
            r.setLH(0);
        if (pRight != null)
            r.setRH(max(pRight.getLH(),pRight.getRH())+1);
        else
            r.setRH(0);
        r.setW(r.getLH()-r.getRH());
    }

    public AVLNode adjustHeight(AVLNode start, AVLNode p, Stack s){
        updateHeight(start);
        if (Math.abs(start.getW())>1){
            if (start.getW() > 0)
                if (p.getW() >= 0)
                    start = singleRightRotate(start,p);
                else
                    start = doubleRightRotate(start,p);
        else
            if (p.getW() <= 0)
                start = singleLeftRotate(start,p);
            else
                start = doubleLeftRotate(start,p);
            updatePreNode(s,start);
        }
        return start;
    }
    public void updatePreNode(Stack s, AVLNode start){
        AVLNode pre;
        if (!s.isEmpty()){
            pre = (AVLNode) s.peek();
            if ((Integer) start.getElement() < (Integer)
                    pre.getElement())
                pre.setLeft(start);
            else
                pre.setRight(start);
        }
        else root = start;
    }
    public AVLNode singleRightRotate(AVLNode start, AVLNode p){
        start.setLeft(p.getRight());
        p.setRight(start);
        updateHeight(start);
        updateHeight(p);
        start = p;
        return start;
    }
    public AVLNode singleLeftRotate(AVLNode start, AVLNode p){
        start.setRight(p.getLeft());
        p.setLeft(start);
        updateHeight(start);
        updateHeight(p);
        start = p;
        return start;
    }
    public AVLNode doubleRightRotate(AVLNode start, AVLNode p){
        AVLNode q;
        q = (AVLNode) p.getRight();
        p.setRight(q.getLeft());
        start.setLeft(q.getRight());
        q.setRight(start);
        q.setLeft(p);
        updateHeight(start);
        updateHeight(p);
        updateHeight(q);
        start = q;
        return start;
    }
    public AVLNode doubleLeftRotate(AVLNode start, AVLNode p){
        AVLNode q;
        q = (AVLNode) p.getLeft();
        p.setLeft(q.getRight());
        start.setRight(q.getLeft());
        q.setLeft(start);
        q.setRight(p);
        updateHeight(start);
        updateHeight(p);
        updateHeight(q);
        start = q;
        return start;
    }
    public void add(int e){
        AVLNode start, t, p;
        t = new AVLNode(e,null,null,0,0,0);
        Stack s = new Stack();
        if (root == null) root = t;
        else{
            start = (AVLNode) root;
            while (start != null){
                s.push(start);
                if ((Integer)t.getElement()<(Integer) start.getElement())
                    start = (AVLNode) start.getLeft();
                else
                    start = (AVLNode) start.getRight();
            }
            start = (AVLNode) s.pop();
            if ((Integer) t.getElement()<(Integer) start.getElement())
                start.setLeft(t);
            else
                if ((Integer) t.getElement() != (Integer) start.getElement()) start.setRight(t);
            updateHeight(start);
            p = start;
            while (!s.isEmpty()){
                start = (AVLNode) s.pop();
                start = adjustHeight(start,p,s);
                p = start;
            }
        }
    }

    public void remove(int e){
        AVLNode start, pre, cur;
        start = (AVLNode) root;
        Stack s = new Stack();
        pre = start;
        boolean d = false;
        while((start != null) && (!d)){
            s.push(start);
            if (start.getElement() == e) d = true;
            else if((Integer) start.getElement() > (Integer) e){
                pre = start;
                start = (AVLNode) start.getLeft();
            }
            else{
                pre = start;
                start = (AVLNode) start.getRight();
            }
        }
        if(start == null) return;
        if ((start.getLeft() == null) &&
                (start.getRight() == null))
            if(start == root)
                root = null;
            else
            if(pre.getLeft() == start)
                pre.setLeft(null);
            else
                pre.setRight(null);
        else if ((start.getLeft() != null) &&
                (start.getRight() != null)){
            pre = start;
            cur = (AVLNode) start.getLeft();
            s.push(cur);
            while (cur.getRight() != null){
                pre = cur;
                s.push(cur);
                cur = (AVLNode) cur.getRight();
            }
            start.setElement(cur.getElement());
            if (pre == start)
                pre.setLeft(cur.getLeft());
            else
                pre.setRight(cur.getLeft());
        }
        else
        if(start.getLeft() != null)
            if(start == root)
                root = start.getLeft();
            else
            if(pre.getLeft() == start)
                pre.setLeft(start.getLeft());
            else
                pre.setRight(start.getLeft());
        else
        if(start == root)
            root = start.getRight();
        else
        if(pre.getRight() == start)
            pre.setRight(start.getRight());
        else
            pre.setLeft(start.getRight());
        size--;
        s.pop();
        AVLNode p;
        while (!s.isEmpty()){
            start = (AVLNode) s.pop();
            updateHeight((AVLNode) start);
            if (Math.abs(start.getW()) > 1){
                if (start.getLH() < start.getRH())
                    p = (AVLNode) start.getRight();
                else
                    p = (AVLNode) start.getLeft();
                adjustHeight(start,p,s);
            }
        }
    }
    public class Stack {
        private Object[] s;
        private int top;
        public Stack(){
            s = new Object[10];
            top = -1;
        }
        public int size(){
            return top+1;
        }
        public void push(Object o){
            if(top == s.length-1)
                s = doubleSize(s);
            top++;
            s[top] = o;
        }
        private static Object[] doubleSize(Object[] origin){
            Object[] temp = new Object[origin.length*2];
            System.arraycopy(origin,0,temp,0,origin.length);
            return temp;
        }
        public Object pop(){
            if(isEmpty()) return null;
            Object e = s[top];
            top--;
            return e;
        }
        public boolean isEmpty(){
            return top == -1;
        }
        public void printStack(){
            while (!(isEmpty())){
                System.out.println(pop());
            }
        }
        public Object peek(){
            Object e = s[top];
            return e;
        }
    }
    public void printTree(){
        BTNode r = root;
        inOrder(r);
        System.out.println();
    }
    public void inOrder(BTNode r) {
        if (r != null){
            inOrder(r.getLeft());
            System.out.print(r.getElement() + ",");
            inOrder(r.getRight());
        }
    }

}
