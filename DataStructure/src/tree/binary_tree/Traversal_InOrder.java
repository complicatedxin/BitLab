package tree.binary_tree;

import structure.BTNode;

public class Traversal_InOrder
{
    private static final int MAXSIZE=500;

    public static void recursion(BTNode bt)
    {
        if(bt!=null)
        {
            recursion(bt.lChild);
            System.out.println(bt.value);
            recursion(bt.rChild);
        }
    }

    public static void nonRecursion(BTNode root)
    {
        if(root!=null)
        {
            BTNode stack[]=new BTNode[MAXSIZE];
            int top=-1;

            BTNode p=root;
            while(top!=-1 || p!=null)
            {
                while(p!=null)
                {
                    stack[++top]=p;
                    p=p.lChild;
                }
                if(top!=-1)
                {
                    p=stack[top--];
                    System.out.println(p.value);
                    p=p.rChild;
                }
            }
        }
    }
}
