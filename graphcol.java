import java.util.*;
class edge{
    int src;
    int dest;
    public edge(int src,int dest){
        this.src=src;
        this.dest=dest;
        
    }
}
public class graphcol{
    public static int[] graphCol(ArrayList<edge> graph[]){
        //boolean vis[]= new boolean[graph.length];
        
        int col[]=new int[graph.length];
        for(int i=0;i<col.length;i++){
            col[i]=-1;
        }
        Queue<Integer> q1= new LinkedList<>();
        boolean vis[]= new boolean[graph.length];
        q1.add(0);
        col[0]=1;
        vis[0]=true;
        while(!q1.isEmpty()){
            int curr=q1.remove();
            for(int i=0;i<graph[curr].size();i++){
                edge  e = graph[curr].get(i);
                if(!vis[e.dest]){
                    int newCol=col[curr]==1?0:1;
                    col[e.dest]=newCol;
                    q1.add(e.dest);
                    vis[e.dest]=true;
                    
                }
                else if(vis[e.dest] && col[e.dest]==col[curr]){
                    col[e.dest]=2;
                }
            }
        }
        return col;
    }
    public static void main (String[] args) {
        ArrayList<edge> graph[]=new ArrayList[5];
        for(int i=0;i<5;i++){
            graph[i]=new ArrayList<>();
        }

        // Scanner sc=new Scanner(System.in);
        // int choice=1;
        // while(choice==1){
        //     System.out.println("enter src:");
        //     int src=sc.nextInt();
        //     System.out.println("enter dest:");
        //     int dest=sc.nextInt();
        //     graph[src].add(new edge(src,dest));
        //     System.out.println("You wont to add more edge: 1 or 0");
        //     choice=sc.nextInt();
        // }

        graph[0].add(new edge(0,1));
		graph[0].add(new edge(0,2));
		graph[0].add(new edge(0,4));
		
		graph[1].add(new edge(1,0));
		graph[1].add(new edge(1,3));
		
		
		graph[2].add(new edge(2,0));
		graph[2].add(new edge(2,3));
		
		graph[3].add(new edge(3,1));
		graph[3].add(new edge(3,2));
		graph[3].add(new edge(3,4));
		
		graph[4].add(new edge(4,0));
		graph[4].add(new edge(4,3));
		
		int col[]=graphCol(graph);
		for(int i=0;i<col.length;i++){
		    System.out.print(col[i]+" ");
		}
    }
}