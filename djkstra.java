import java.util.*;

class edge{
    int src;
    int dest;
    int wt;
    
    public edge(int src,int dest,int wt){
        this.src=src;
        this.dest=dest;
        this.wt=wt;
        
    }
}
public class djkstra
{
    static class pair implements Comparable<pair>{
        int v;
        int dist;
        
        public pair(int v,int dist){
            this.v=v;
            this.dist=dist;
        }
        @Override
        public int compareTo(pair p1){
            return this.dist-p1.dist;
        }
    }
    public static int[] dijstraAlgo(ArrayList<edge> graph[]){
        boolean vis[]= new boolean[graph.length];
        PriorityQueue<pair> pq= new PriorityQueue<>();
        int dist[]=new int[graph.length];
        for(int i=0;i<dist.length;i++){
             if(i!=0){
	            dist[i]=Integer.MAX_VALUE;
	        }
        }
        pq.add(new pair(0,0));
        
        while(!pq.isEmpty()){
            pair curr=pq.remove();
            if(!vis[curr.v]){
                vis[curr.v]=true;
                for(int i=0;i<graph[curr.v].size();i++){
                    edge e= graph[curr.v].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[u]+wt<dist[v]){
                        
                        dist[v]=dist[u]+wt;
                        pq.add(new pair(v,dist[v]));
                    }
                }
            }
        }
        return dist;
    }
	public static void main(String[] args) {
		ArrayList<edge> graph[]=new ArrayList[6];
		for(int i=0;i<6;i++){
		    graph[i]=new ArrayList<>();
		}

        // Scanner sc=new Scanner(System.in);
        // int choice=1;
        // while(choice==1){
        //     System.out.println("enter src:");
        //     int src=sc.nextInt();
        //     System.out.println("enter dest:");
        //     int dest=sc.nextInt();
        //     System.out.println("Enter the weight:");
        //     int wt=sc.nextInt();
        
        //     graph[src].add(new edge(src,dest,wt));

        //     System.out.println("You wont to add more edge: 1 or 0");

        //     choice=sc.nextInt();

        // }
		
		graph[0].add(new edge(0,1,2));
		graph[0].add(new edge(0,2,4));
		graph[1].add(new edge(1,2,1));
		graph[1].add(new edge(1,3,7));
		graph[2].add(new edge(2,4,3));
		graph[3].add(new edge(3,5,1));
		graph[4].add(new edge(4,3,2));
		graph[4].add(new edge(4,5,5));
		
		int dist[]=dijstraAlgo(graph);
		for(int i=0;i<dist.length;i++){
		    System.out.print(dist[i]+" ");
		}
		
	}
}