package map;

import java.util.*;
public class myDFS {

	public static void main(String[] args) {
		new myDFS(1);
	}
//---------------------------------核心代码-------------------------------
	public void doDFS(int start,vertex[] v, int[][] adjArr){
			v[start].setDeal();			//标记处理
			System.out.print(v[start].getVertexName());			//打印路径
			List<vertex> adjList=v[start].getAdjacentList();	//获取邻接矩阵	
			if(adjList!=null){			//如果一个点没有邻接矩阵了则停止，不进行回溯
				Iterator<vertex> iterator=adjList.iterator();	
				if(iterator.hasNext()){	//判断是否为null不然iterator.next()会异常
					vertex cur=iterator.next();	//头结点
					while(cur.isDealed()){		//找到还没有处理过的第一个节点
						cur=iterator.next();
					}
					System.out.print("-");
					doDFS(cur.getNum(), v, adjArr);//递归调用
				}
			}
	}
//----------------------------------------------------------------------
	
	public myDFS(int start){		//
			initial(start);
	}
	public void initial(int start) {
//---------------------------------邻接矩阵---------------------------------
		int[][] linkedarr=new int[][]{
					//0,1,2,3,4, 5,6,7   进点          //出点
					 {0,0,0,0,0, 0,0,0}, 	//0
					 {0,0,2,0,1, 0,0,0},	//1
					 {0,0,0,0,3,10,0,0},	//2
					 {0,4,0,0,0, 0,5,0},	//3
					 {0,0,0,2,0, 2,8,4},	//4
					 {0,0,0,0,0, 0,0,6},	//5
					 {0,0,0,0,0, 0,0,0},	//6
					 {0,0,0,0,0, 0,1,0}		//7
				};
		vertex[] v=new vertex[linkedarr.length];
		v[0]=new vertex();				//为了方便的下标等于点的序号
//---------------------------------创建每个节点-------------------------------		
		for(int m=1;m<=linkedarr.length-1;m++){
				v[m]=new vertex("v"+m,m);
		}
//---------------------------------邻接链表赋值-------------------------------
		List<vertex> adjList;
		for(int m=1;m<=linkedarr.length-1;m++){
				adjList=new LinkedList<vertex>();
			for(int n=1;n<=linkedarr[0].length-1;n++){
				if(linkedarr[m][n]!=0){
					adjList.add(v[n]);				//每个节点加入邻接矩阵
				}
			}
			v[m].setAdjList(adjList);
		}
//---------------------------------打印邻接链表-------------------------------
		System.out.println("---------AdjacentMatrix---------------");
		for(int m=1;m<=linkedarr.length-1;m++){	//打印每个vertex中的邻接矩阵
			v[m].printadjList();
			System.out.println();
		}
//---------------------------------执行BFS-------------------------------
		System.out.println("---------result---------------");
		doDFS(start,v,linkedarr);
		printVertex(v);
		}
//---------------------------------打印结果-------------------------------
		public void printVertex(vertex[] v){
			System.out.println("\n---------vertex table----------");
			for(int i=1;i<=v.length-1;i++){
				String path=(v[i].getPath()==null)?null:v[i].getPath().getVertexName();
				System.out.println(
						v[i].getVertexName()+": Deal-"+v[i].isDealed()+" dis-"+v[i].getDistance()
						+" path-"+path
						);
			}
		}
//---------------------------------节点类-------------------------------
	private class vertex implements Comparable<vertex>{
		private String name;
		private int num;
		private List<vertex> adjacenctlist=new LinkedList<vertex>();	//邻接点
		private boolean hasDeal=false;			//处理标志
		private int distance=Integer.MAX_VALUE;	//到初始点的距离
		private vertex path=null;				//上一个点的路径
		
		public vertex(){}
		public vertex(String name,int num){
			this.name=name;
			this.num=num;
		}
		public void setAdjList(List<vertex> adjList){
			this.adjacenctlist=adjList;
		}
		public void setDeal(){
			this.hasDeal=true;
		}
		public boolean isDealed(){
			return this.hasDeal;
		}
		public void setDistance(int m){
			this.distance=m;
		}
		public int getDistance(){
			return this.distance;
		}
		public void setPath(vertex v){
			this.path=v;
		}
		public vertex getPath(){
			return this.path;
		}
		public String getVertexName(){
			return this.name;
		}
		public List<vertex> getAdjacentList(){
			return adjacenctlist;
		}
		public void add(vertex v){
			this.adjacenctlist.add(v);
		}
		@Override
		public int compareTo(vertex o) {
			return (this.getDistance()>o.getDistance())?1:-1;
		};
		@Override
		public int hashCode() {
			return distance;
		}
		@Override
		public boolean equals(Object obj) {
			return (this.hashCode()==obj.hashCode())?true:false;
		}
		public void printadjList(){
			System.out.print(name);
			for(vertex v:this.adjacenctlist){
				System.out.print("-"+v.name);
			}
		}
		public int getNum(){
			return this.num;
		}
	}
}
