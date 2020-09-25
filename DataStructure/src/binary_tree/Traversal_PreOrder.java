package binary_tree;

import structure.BTNode;

public class Traversal_PreOrder
{
    private static final int MAXSIZE=500;

    public static void recursion(BTNode bt)
    {
        if(bt!=null)
        {
            System.out.println(bt.value);
            recursion(bt.lChild);
            recursion(bt.rChild);
        }
    }

    public static void nonRecursion(BTNode root)
    {
        BTNode stack[]=new BTNode[MAXSIZE];
        int top=-1;

        stack[++top]=root;
        BTNode p=null;
        while(top!=-1)
        {
            p=stack[top--];
            if(p!=null)
            {
                System.out.println(p.value);
                stack[++top]=p.rChild;
                stack[++top]=p.lChild;
            }
        }
    }
}
