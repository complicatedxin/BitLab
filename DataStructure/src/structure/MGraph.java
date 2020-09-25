package structure;

import java.util.Arrays;

/**
 *  邻接矩阵 表示 无向图
 */

public class MGraph
{
    public class Vertex
    {
        public final int no;//顶点编号
        private String info;//顶点信息

        public Vertex(int vno)
        {
            this.no=vno;
        }

        public void setInfo(String info)
        {
            this.info=info;
        }
        public String getInfo()
        {
            return info;
        }
    }

    private static final int MAXSIZE=500;

    public int[][] edges =new int[MAXSIZE][MAXSIZE];
    public int n;//顶点数
    public int e;//边数
    public Vertex[] vex =new Vertex[MAXSIZE];

    {
        n=0;
        e=0;
        Arrays.fill(vex, null);
        for(int i=0;i<edges.length;i++)
            for(int j=0;j<edges.length;j++)
                edges[i][j]=0;
    }//初始化

    public void addVertex(int vno)
    {
        if(!isExist(vno))
        {
            vex[vno]=new Vertex(vno);
            n++;
        }
    }
    public void removeVertex(int vno)
    {
        if(vex[vno]==null) return;
        for(int i=0;i<edges.length;i++)
        {
            this.joint(vno,i,0);
            e--;
        }
        vex[vno]=null;
        n--;
    }
    public boolean isExist(int vno)
    {
        return vex[vno]!=null;
    }
    public void link(int vno,int... to)
    {
        if(!isExist(vno)) return;
        for (int value : to)
        {
            if (isExist(value)) continue;
            this.joint(vno, value, 1);
            e++;
        }
    }
    public void link(int vno,int to,int weight)
    {
        this.link(vno,to);
        this.joint(vno,to,weight);
    }
    public boolean isLinked(int i,int j)
    {
        return edges[i][j]!=0 && edges[i][j]!=Integer.MAX_VALUE;
    }
    public void setWeight(int i,int j,int weight)
    {
        if(isLinked(i,j))
            this.joint(i,j,weight);
    }
    private void joint(int i,int j,int weight)
    {
        if(!isExist(i) || !isExist(j)) return;
        edges[i][j]=weight;
        edges[j][i]=weight;
    }
    public void forceJoint(int i,int j,int weight)
    {
        if(!isExist(i)) addVertex(i);
        if(!isExist(j)) addVertex(j);
        e++;
        joint(i,j,weight);
    }
    public void unLink(int vno,int... to)
    {
        if(!isExist(vno)) return;
        for (int value : to)
        {
            if (!isExist(value)) continue;
            this.joint(vno, value, 0);
            e--;
        }
    }
    public MGraph transformWeightG()
    {
        for(int i=0;i<edges.length;i++)
            for(int j=0;j<edges.length;j++)
                if(edges[i][j]==0)
                    edges[i][j]=Integer.MAX_VALUE;
        return this;
    }
}
