package tree.binary_tree;

import structure.BTNode;

public class Traversal_LevelOrder
{
    private static final int MAXSIZE=500;

    public static void nonRecursion(BTNode root)
    {
        if(root!=null)
        {
            BTNode queue[]=new BTNode[MAXSIZE];
            int front=0, rear=0;
            BTNode p=null;

            rear=(rear+1)%MAXSIZE;
            queue[rear]=root;
            while(front!=rear)
            {
                front=(front+1)%MAXSIZE;
                p=queue[front];
                System.out.println(p.value);
                if(p.lChild!=null)
                {
                    rear=(rear+1)%MAXSIZE;
                    queue[rear]=p.lChild;
                }
                if(p.rChild!=null)
                {
                    rear=(rear+1)%MAXSIZE;
                    queue[rear]=p.rChild;
                }
            }
        }
    }

}
