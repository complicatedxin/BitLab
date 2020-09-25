package binary_tree;

import structure.BTNode;

public class SortTree
{
    public BTNode root;

    public SortTree(){}
    public SortTree(BTNode root)
    {
        this.root=root;
    }

    //插入
    public void add(Integer value)
    {
        if(value==null) return;
        this.insertNode(value,root);
    }
    public void add(Integer value, BTNode bt)
    {
        if(value!=null) insertNode(value,bt);
    }
    private BTNode insertNode(int value, BTNode bt)
    {
        if(bt==null) return new BTNode(value);
        if(value==bt.value) return bt;
        else if(value<bt.value) bt.lChild=insertNode(value,bt.lChild);
        else bt.rChild=insertNode(value,bt.rChild);
        return bt;
    }

    //删除
    public void remove(Integer value)
    {
        if(value==null) return;
        this.removeNode(value,root);
    }
    public void remove(Integer value, BTNode bt)
    {
        if(value!=null) removeNode(value,bt);
    }
    private BTNode removeNode(int value, BTNode bt)
    {
        if(bt==null) return null;
        if(bt.value==value)
            bt=excisionNode(bt);
        else if(value<bt.value)
            bt.lChild=removeNode(value,bt.lChild);
        else bt.rChild=removeNode(value,bt.rChild);
        return bt;
    }
    private BTNode excisionNode(BTNode bt)//先左后右
    {
        BTNode r=bt.lChild;
        if(r==null)
        {
            r=bt.rChild;
            if(r==null) return null;
            else
            {
                BTNode p=bt;
                while(r.lChild!=null)
                {
                    p=r;
                    r=r.lChild;
                }
                bt.value=r.value;
                p.lChild=null;
            }
        }
        else
        {
            BTNode p=bt;
            while(r.rChild!=null)
            {
                p=r;
                r=r.rChild;
            }
            bt.value=r.value;
            p.rChild=null;
        }
        return bt;
    }

    //查找
    public boolean isExist(Integer value)
    {
        if(value==null) return false;
        return search(value,root);
    }
    public boolean isExist(Integer value, BTNode bt)
    {
        if(value!=null) return search(value,bt);
        return false;
    }
    private boolean search(int value, BTNode bt)
    {
        if(bt==null) return false;
        else
        {
            if(bt.value==value) return true;
            else if(value<bt.value) return search(value,bt.lChild);
            else return search(value,bt.rChild);
        }
    }

}
