// /kruskal algorithm
import java.util.*;
public class kruskals
{
        static int n=4;
		static int par[]=new int[4];
		static int rank[]=new int[4];
		
		public static void init(){
		    for(int i=0;i<par.length;i++){
		        par[i]=i;
		    }
		}
		
		public static int find(int x){
		    if(x==par[x]){
		        return x;
		    }
		    return par[x]=find(par[x]);
		}
		
		public static void union(int a,int b){
		    int parA=find(a);
		    int parB=find(b);
		    
		    if(rank[parB]==rank[parA]){
		        par[parB]=parA;
		        rank[parA]++;
		    }else if(rank[parB]<rank[parA]){
		        par[parB]=parA;
		    }else{
		        par[parA]=parB;
		    }
		}
		static class edge implements Comparable<edge>{
		    int src;
		    int dest;
		    int wt;
		    public edge(int src,int dest,int wt){
		        this.src=src;
		        this.dest=dest;
		        this.wt=wt;
		        
		    }
		    @Override
		    public int compareTo(edge e){
		        return this.wt-e.wt;
		    }
		}
		public static void createGraph(ArrayList<edge> edges){
			// Scanner sc=new Scanner(System.in);
			// int choice=1;
			// while(choice==1){
			//     System.out.println("enter src:");
			//     int src=sc.nextInt();
			//     System.out.println("enter dest:");
			//     int dest=sc.nextInt();
			//     System.out.println("Enter the weight:");
			//     int wt=sc.nextInt();
			
			//     edges.add(new edge(src,dest,wt));

			//     System.out.println("You wont to add more edge: 1 or 0");

			//     choice=sc.nextInt();

			// }
		    edges.add(new edge(0,1,2));
		    edges.add(new edge(0,3,2));
		    edges.add(new edge(1,3,3));
		    edges.add(new edge(2,3,3));
		    edges.add(new edge(1,2,7));
		}
		public static void kruskalAlgo(ArrayList<edge> edges,int v){
		    init();
		    Collections.sort(edges);
		    int mst=0;
		    // int count=0;
		    for(int i=0;i<=v-1;i++){
		        edge e=edges.get(i);
		        if(par[e.src]!=par[e.dest]){
		            union(e.src,e.dest);
		            // count++;
					System.out.print(e.src+" "+e.dest+" "+e.wt);
					System.out.println();
		            mst+=e.wt;
		        }
		    }
		    System.out.println(mst);
		}
	public static void main(String[] args) {
	    ArrayList<edge> edges=new ArrayList<>();
	    int v=4;
	    createGraph(edges);
	    kruskalAlgo(edges,v);
	}
}