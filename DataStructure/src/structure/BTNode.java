package structure;

public class BTNode
{
    public Integer value;
    public BTNode lChild;
    public BTNode rChild;

    public BTNode(){}
    public BTNode(Integer value)
    {
        this.value=value;
    }
    public BTNode(Integer value, BTNode lChild, BTNode rChild)
    {
        this.value = value;
        this.lChild = lChild;
        this.rChild = rChild;
    }
}
