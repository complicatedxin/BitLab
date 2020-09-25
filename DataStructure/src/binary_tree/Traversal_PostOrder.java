package binary_tree;

import structure.BTNode;

public class Traversal_PostOrder
{
    private static final int MAXSIZE=500;

    public static void recursion(BTNode bt)
    {
        if(bt!=null)
        {
            recursion(bt.lChild);
            recursion(bt.rChild);
            System.out.println(bt.value);
        }
    }

    public static void nonRecursion(BTNode root)
    {
        if(root!=null)
        {
            BTNode stack1[]=new BTNode[MAXSIZE];
            int top1=-1;
            BTNode stack2[]=new BTNode[MAXSIZE];
            int top2=-1;
            BTNode p=null;

            stack1[++top1]=root;
            while(top1!=-1)
            {
                p=stack1[top1--];
                stack2[++top2]=p;
                if(p.lChild!=null)
                    stack1[++top1]=p.lChild;
                if(p.rChild!=null)
                    stack1[++top1]=p.rChild;
            }
            while(top2!=-1)
                System.out.println(stack2[top2--].value);
        }
    }

}
