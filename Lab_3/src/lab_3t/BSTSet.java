/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3t;
/**
 *
 * @author TheYo
 */
public class BSTSet {
    private TNode root;
    
    public BSTSet(){
        root = null;
    }
    
    //n log(n)
    public BSTSet(int[] input){
        TNode p;
        root = null;
        
        for(int n : input)
            add(n);
        
    }
    
    private boolean isLeaf(TNode p){
        return p.left == null && p.right == null;
    }
    
    private int sizing(TNode newRoot){
        if(root == null) return 0; //empty sub-tree
        //current node is a leaf
        else if(newRoot.left == null && newRoot.right == null)
            return 1;
        //current node has two children
        else if(newRoot.left != null && newRoot.right != null)
            return 1 + sizing(newRoot.left) + sizing(newRoot.right);
        //current node only has one child
        else
            return 1 + sizing(newRoot.left != null ? newRoot.left : newRoot.right);
    }
    
    private int scaling(TNode newRoot){
        int leftSize, rightSize;

        //empty sub-tree
        if(root == null) return -1;
        
        //base case: current node is a leaf
        else if(newRoot.left == null && newRoot.right == null){
            return 1;
        }

        //current node has two children
        else if(newRoot.left != null && newRoot.right != null){
            leftSize = scaling(newRoot.left);
            rightSize = scaling(newRoot.right);
            return 1 + (leftSize > rightSize ? leftSize : rightSize);
        }
        
        //current node has only one child
        else
            return 1 + scaling(newRoot.left != null ? newRoot.left : newRoot.right);
        
    }
    
    private TNode findMin(TNode p){
        
        if(p.left != null)
            p = p.left;
        else if(p.right != null)
            p = p.right;
        
        while(p.left != null){
            p = p.left;
        }
        
        return p;
    }
    
    private void shiftProtocol(TNode p){
        TNode q;
        while(true){
            
            if(p.left != null){
                p.element = findMin(p).element;
                
                if(isLeaf(p.left)){
                    p.left = null;
                    return;
                }

                p = findMin(p);
            }
            
            else{
                q = findMin(p.right);
                p.element = q.element;
                
                if(isLeaf(q)){
                    p.right = null;
                    return;
                }
                
                p = q;
            }
        }
    }
    
    //log n
    public boolean isIn(int v){
        TNode p = root;
        
        while(p != null){
            if(v == p.element)
                return true;
            else 
                p = v < p.element ? p.left : p.right;
        }
        
        return false;
    }
    
    //log n
    public void add(int v){
        TNode p;
        
        if(isIn(v) == false){
            
            if(root == null){
                root = new TNode(v, null, null);
            }
            
            else{
                p = root;
                
                while(true){
                    if(v < p.element){
                        if(p.left == null){
                            p.left = new TNode(v, null, null);
                            break;
                        }
                        else p = p.left;
                    }

                    else{
                        if(p.right == null){
                            p.right = new TNode(v, null, null);
                            break;
                        }
                        else p = p.right;
                    }
                }
                
            }
        }
    }
    
    public boolean remove(int v){
        TNode p, q;
        
        if(isIn(v)){
            p = new TNode(v-1, null, root);
            
            //searching
            while(true){
                if(p.left != null && p.left.element == v)
                    break;
                else if(p.right != null && p.right.element == v)
                    break;
                else p = v < p.element ? p.left : p.right;
               
                
            }
            
            if((v < p.element ? p.left : p.right).left != null || (v < p.element ? p.left : p.right).right != null){
                
                if((v < p.element ? p.left : p.right).left != null && (v < p.element ? p.left : p.right).right != null){
                    p = v < p.element ? p.left : p.right;
                    
                    if(p.right.left != null){
                        q = p.right;
                        
                        while(q.left.left != null)
                            q = q.left;
                        
                        p.element = q.left.left.element;
                        shiftProtocol(q.left.left);
                    }
                    
                    else{
                        p.element = p.right.element;
                        shiftProtocol(p.right);
                    }
                }
                
                else if((v < p.element ? p.left : p.right).left != null){
                    (v < p.element ? p.left : p.right).element = (v < p.element ? p.left : p.right).left.element;
                    shiftProtocol((v < p.element ? p.left : p.right).left);
                }
                
                
                else{
                    (v < p.element ? p.left : p.right).element = (v < p.element ? p.left : p.right).right.element;
                    shiftProtocol((v < p.element ? p.left : p.right).right);
                }
            }
            
            else{
                if(v < p.element) p.left = null;
                else p.right = null;
            }
            
            return true;
        }
        
        else return false;
    }
    
    public BSTSet union(BSTSet s){
        BSTSet rslt = new BSTSet();
        MyStack stack;
        
        //traversing first Set
        stack = new MyStack(height());
        stack.push(new MyQueue(root, 2));
        while(!(stack.isEmpty())){
            
            if(stack.top().isEmpty()){
                stack.pop();
                rslt.add(stack.top().dequeue().element);
                continue;
            }
            
            if(stack.top().getFront().right != null)
                stack.top().enqueue(stack.top().getFront().right);
            
            if(stack.top().getFront().left != null)
                stack.push(new MyQueue(stack.top().getFront().left, 2));
            else rslt.add(stack.top().dequeue().element);
        }
        
        //traversing second set
        stack = new MyStack(s.height());
        stack.push(new MyQueue(s.root, 2));
        while(!(stack.isEmpty())){
            
            if(stack.top().isEmpty()){
                stack.pop();
                rslt.add(stack.top().dequeue().element);
                continue;
            }
            
            if(stack.top().getFront().right != null)
                stack.top().enqueue(stack.top().getFront().right);
            
            if(stack.top().getFront().left != null)
                stack.push(new MyQueue(stack.top().getFront().left, 2));
            else rslt.add(stack.top().dequeue().element);
        }
        
        return rslt;
        
    }
    
    public BSTSet intersection(BSTSet s){
        BSTSet rslt = new BSTSet();
        MyStack stack;
        
        //traversing first Set
        stack = new MyStack(height());
        stack.push(new MyQueue(root, 2));
        while(!(stack.isEmpty())){
            
            if(stack.top().isEmpty()){
                stack.pop();
                
                if(s.isIn(stack.top().getFront().element))
                    rslt.add(stack.top().dequeue().element);
                else stack.top().dequeue();
                continue;
            }
            
            if(stack.top().getFront().right != null)
                stack.top().enqueue(stack.top().getFront().right);
            
            if(stack.top().getFront().left != null)
                stack.push(new MyQueue(stack.top().getFront().left, 2));
            else{
                if(s.isIn(stack.top().getFront().element))
                    rslt.add(stack.top().dequeue().element);
                else stack.top().dequeue();
            }
        }
        
        return rslt;
    }
    
    
    public BSTSet difference(BSTSet s){
        BSTSet rslt = new BSTSet();
        MyStack stack;
        
        //traversing first Set
        stack = new MyStack(height());
        stack.push(new MyQueue(root, 2));
        while(!(stack.isEmpty())){
            
            if(stack.top().isEmpty()){
                stack.pop();
                
                if(s.isIn(stack.top().getFront().element) == false)
                    rslt.add(stack.top().dequeue().element);
                else stack.top().dequeue();
                continue;
            }
            
            if(stack.top().getFront().right != null)
                stack.top().enqueue(stack.top().getFront().right);
            
            if(stack.top().getFront().left != null)
                stack.push(new MyQueue(stack.top().getFront().left, 2));
            else{
                if(s.isIn(stack.top().getFront().element) == false)
                    rslt.add(stack.top().dequeue().element);
                else stack.top().dequeue();
            }
        }
        
        stack = new MyStack(s.height());
        stack.push(new MyQueue(s.root, 2));
        while(!(stack.isEmpty())){
            
            if(stack.top().isEmpty()){
                stack.pop();
                
                if(isIn(stack.top().getFront().element) == false)
                    rslt.add(stack.top().dequeue().element);
                else stack.top().dequeue();
                continue;
            }
            
            if(stack.top().getFront().right != null)
                stack.top().enqueue(stack.top().getFront().right);
            
            if(stack.top().getFront().left != null)
                stack.push(new MyQueue(stack.top().getFront().left, 2));
            else{
                if(isIn(stack.top().getFront().element) == false)
                    rslt.add(stack.top().dequeue().element);
                else stack.top().dequeue();
            }
        }
        
        return rslt;
    }
    
    public int size(){
        return sizing(root);
    }
    
    public int height(){
        return scaling(root);
    }
    
    public void printBSTSet(){
        printBSTSet(root);
        System.out.println();
    }
    
    private void printBSTSet(TNode t){
        //tree is empty
        if(root == null) return;
        
        
        //reduction protocol
        if(t.left != null) printBSTSet(t.left);
        System.out.print(t.element + ", ");
        if(t.right != null) printBSTSet(t.right);
    }
    
    public void printNonRec(){
        MyStack stack = new MyStack(height());
        
        stack.push(new MyQueue(root, 2));
        
        while(!(stack.isEmpty())){
            
            if(stack.top().isEmpty()){
                stack.pop();
                System.out.print(stack.top().dequeue().element + " ");
                continue;
            }
            
            if(stack.top().getFront().right != null)
                stack.top().enqueue(stack.top().getFront().right);
            
            if(stack.top().getFront().left != null)
                stack.push(new MyQueue(stack.top().getFront().left, 2));
            else System.out.print(stack.top().dequeue().element + " ");
        }
        
        System.out.println();
        
    }
}
