package tree.binary_tree;

import structure.BTNode;

import java.util.Arrays;

public class RestoreBT_Pre_In
{
    private static int getIndex(int arr[],int target)
    {
        for(int i=0;i<arr.length;i++)
            if(arr[i]==target)
                return i;
        return -1;
    }
    public static BTNode restore(int preOrder[], int inOrder[])
    {
        if(preOrder==null || preOrder.length==0
                || inOrder==null || inOrder.length==0
                || preOrder.length!=inOrder.length)
            return null;
        BTNode bt=new BTNode(preOrder[0]);
        int index=getIndex(inOrder,bt.value);
        int lTreePre[]= Arrays.copyOfRange(preOrder,1,index+1);
        int lTreeIn[]=Arrays.copyOfRange(inOrder,0,index);
        int rTreePre[]=Arrays.copyOfRange(preOrder,index+1,preOrder.length);
        int rTreeIn[]=Arrays.copyOfRange(inOrder,index+1,inOrder.length);
        bt.lChild=restore(lTreePre,lTreeIn);
        bt.rChild=restore(rTreePre,rTreeIn);
        return bt;
    }
}
