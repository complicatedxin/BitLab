package structure;

/**
 *  邻接表 表示 有向图
 */

@SuppressWarnings("all")
public class AGraph
{
    public class ArcNode
    {
        public int adjvex;
        public ArcNode nextArc;
        public int weight;

        public ArcNode(){}
        public ArcNode(int adjvex)
        {
            this.adjvex=adjvex;
        }
    }
    public class VNode
    {
        public int no;
        public ArcNode firstArc;
        private String info;

        public VNode(int vno)
        {
            this.no=vno;
        }
        public VNode(int vno,ArcNode firstArc)
        {
            this.no=vno;
            this.firstArc=firstArc;
        }

        public String getInfo()
        {
            return info;
        }
        public void setInfo(String info)
        {
            this.info = info;
        }
    }

    private static final int MAXSIZE=500;

    public VNode adjList[]=new VNode[MAXSIZE];
    public int n;
    public int e;

    {
        n=0;
        e=0;
        for(int i=0;i<adjList.length;i++)
            adjList[i]=null;
    }

    public void addVNode(int vno)
    {
        if(adjList[vno]==null)
        {
            adjList[vno]=new VNode(vno);
            n++;
        }
    }
    public void removeVNode(int vno)
    {
        if(adjList[vno]==null) return;
        adjList[vno]=null;
        n--;
    }
    private boolean isLinked(int vno,int to)
    {
        ArcNode p=adjList[vno].firstArc;
        while(p!=null)
        {
            if(p.adjvex==to)
                return true;
            p=p.nextArc;
        }
        return false;
    }
    public void link(int vno,int to)
    {
        if(adjList[vno]==null || adjList[to]==null) return;
        if(isLinked(vno,to)) return;
        ArcNode r=new ArcNode(to);
        ArcNode p=adjList[vno].firstArc;
        r.nextArc=p;
        adjList[vno].firstArc=r;
        e++;
    }
    public void link(int vno,int... to)
    {
        for(int i=0;i<to.length;i++)
            this.link(vno,to[i]);
    }
    public void unLink(int vno,int to)
    {
        if(adjList[vno]==null) return;
        ArcNode p=adjList[vno].firstArc;
        if(p!=null && p.adjvex==to)
            adjList[vno].firstArc=p.nextArc;
        ArcNode q=null;
        if(p!=null) q=p.nextArc;
        while(q!=null)
        {
            if(q.adjvex==to)
            {
                p.nextArc=q.nextArc;
                e--;
                break;
            }
            p=q;
            q=q.nextArc;
        }
    }
    public void unLink(int vno,int... to)
    {
        for(int i=0;i<to.length;i++)
            this.unLink(vno,to[i]);
    }

    public int[] getVisit()
    {
        int visit[]=new int[this.adjList.length];
        for(int i=0;i<visit.length;i++)
        {
            if(this.adjList[i]==null) visit[i]=0;
            else visit[i]=1;
        }
        return visit;
    }
}
