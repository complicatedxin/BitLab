package binary_tree;

import structure.BTNode;

public class CompareBT
{
    public static boolean compareAbsolute(BTNode bt1, BTNode bt2)
    {
        if(bt1==null && bt2==null) return true;
        else if(bt1!=null && bt2!=null)
        {
            if(compareValue(bt1, bt2))
                if(compareAbsolute(bt1.lChild,bt2.lChild))
                    return compareAbsolute(bt1.rChild,bt2.rChild);
        }
        return false;
    }
    private static boolean compareValue(BTNode bt1, BTNode bt2)
    {
        return bt1.value.equals(bt2.value);
    }

    public static boolean compareRelative(BTNode bt1, BTNode bt2)
    {
        if(bt1==null && bt2==null) return true;
        else if(bt1!=null && bt2!=null)
        {
            if(compareValue(bt1, bt2))
                return (compareRelative(bt1.lChild,bt2.lChild) && compareRelative(bt1.rChild,bt2.rChild))
                        || (compareRelative(bt1.lChild,bt2.rChild) && compareRelative(bt1.rChild,bt2.lChild));
        }
        return false;
    }
}
