
//prims algo
import java.util.*;

class edge {
    int src;
    int dest;
    int wt;

    public edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }

}

public class prims {
    static class pair implements Comparable<pair> {
        int loc;
        int wt;

        public pair(int loc, int wt) {
            this.loc = loc;
            this.wt = wt;
        }

        @Override
        public int compareTo(pair p1) {
            return this.wt - p1.wt;
        }
    }

    public static int primsAlgo(ArrayList<edge> graph[]) {

        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(0, 0));

        boolean vis[] = new boolean[graph.length];
        int cost = 0;
        // vis[0]=true;

        while (!pq.isEmpty()) {
            pair p1 = pq.remove();
            if (!vis[p1.loc]) {
                vis[p1.loc] = true;
                // edge e1=graph[p1.loc].get(0);
                System.out.print(p1.loc+"->");
                // System.out.println();
                cost += p1.wt;
                for (int i = 0; i < graph[p1.loc].size(); i++) {
                    edge e = graph[p1.loc].get(i);
                    // System.out.print(p1.loc+" "+e.dest+" "+e.wt);
                    // System.out.println();
                    pq.add(new pair(e.dest, e.wt));
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        ArrayList<edge> graph[] = new ArrayList[5];

        for (int i = 0; i < 5; i++) {
            graph[i] = new ArrayList<>();

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

        graph[0].add(new edge(0, 1, 2));
        graph[0].add(new edge(0, 3, 2));

        graph[1].add(new edge(1, 0, 2));
        graph[1].add(new edge(1, 2, 7));
        graph[1].add(new edge(1, 3, 3));

        graph[2].add(new edge(2, 1, 7));
        graph[2].add(new edge(2, 3, 3));

        graph[3].add(new edge(3, 0, 2));
        graph[3].add(new edge(3, 1, 3));
        graph[3].add(new edge(3, 2, 3));

        int cost = primsAlgo(graph);
        System.out.println(cost);
    }
}