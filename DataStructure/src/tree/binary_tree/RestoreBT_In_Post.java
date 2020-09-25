package tree.binary_tree;

import structure.BTNode;

import java.util.Arrays;

public class RestoreBT_In_Post
{
    private static int getIndex(int arr[],int target)
    {
        for(int i=0;i<arr.length;i++)
            if(arr[i]==target)
                return i;
        return -1;
    }
    public static BTNode restore(int inOrder[], int postOrder[])
    {
        if(inOrder==null || inOrder.length==0
                || postOrder==null || postOrder.length==0
                || inOrder.length!=postOrder.length)
            return null;
        BTNode bt=new BTNode(postOrder[postOrder.length-1]);
        int index=getIndex(inOrder,bt.value);
        int rTreeIn[]= Arrays.copyOfRange(inOrder,index+1,inOrder.length);
        int rTreePost[]=Arrays.copyOfRange(postOrder,index,postOrder.length-1);
        int lTreeIn[]=Arrays.copyOfRange(inOrder,0,index);
        int lTreePost[]=Arrays.copyOfRange(postOrder,0,index);
        bt.rChild=restore(rTreeIn,rTreePost);
        bt.lChild=restore(lTreeIn,lTreePost);
        return bt;
    }
}
