package tree.binary_tree;

import structure.BTNode;

public class AVL_SortTree
{
    public SortTree sortTree;

    public AVL_SortTree(SortTree sortTree)
    {
        this.sortTree=sortTree;
        sortTree.root= adjust(sortTree.root);
    }
    
    public class BTAndFlag
    {
        BTNode bt;
        boolean isChanged;
        public BTAndFlag(BTNode bt, boolean isChanged)
        {
            this.bt = bt;
            this.isChanged = isChanged;
        }
    }

    public void add(Integer value)
    {
        sortTree.add(value,sortTree.root);
        sortTree.root= adjust(sortTree.root);
    }
    public BTNode adjust(BTNode bt)
    {
        BTAndFlag result=equilibrate(bt);
        while(result.isChanged)
            result=equilibrate(result.bt);
        return result.bt;
    }
    private BTAndFlag equilibrate(BTNode bt)
    {
        if(bt.lChild!=null) bt.lChild=equilibrate(bt.lChild).bt;
        if(bt.rChild!=null) bt.rChild=equilibrate(bt.rChild).bt;
        return isBalanced(bt);
    }
    private BTNode eq(int avlNum, BTNode bt)
    {
        if(avlNum>=2)
        {
            BTNode q=bt.lChild;
            int lCHeight=height(q);
            BTNode r=q.rChild;
            if(lCHeight>=0)//LL型
            {
                bt.lChild=q.rChild;
                q.rChild=bt;
                return q;
            }
            else    //LR型
            {
                q.rChild=r.lChild;
                bt.lChild=r.rChild;
                r.lChild=q;
                r.rChild=bt;
                return r;
            }
        }
        //avlNum<=-2
        BTNode q=bt.rChild;
        int rCHeight=height(q);
        BTNode r=q.lChild;
        if(rCHeight<=0)//RR型
        {
            bt.rChild=q.lChild;
            q.lChild=bt;
            return q;
        }
        //RL型
        q.lChild=r.rChild;
        bt.rChild=r.lChild;
        r.rChild=q;
        r.lChild=bt;
        return r;
    }
    private BTAndFlag isBalanced(BTNode bt)
    {
        if(bt==null) return new BTAndFlag(null,false);
        int n=avlNum(bt);
        if(n==-1 || n==0 || n==1) return new BTAndFlag(bt,false);
        return new BTAndFlag(eq(n,bt),true);
    }
    private int avlNum(BTNode bt)
    {
        return height(bt.lChild)-height(bt.rChild);
    }
    private int height(BTNode bt)
    {
        if(bt==null)
            return 0;
        int height=1;
        return Math.max(height+height(bt.lChild),height+height(bt.rChild));
    }
    
}
