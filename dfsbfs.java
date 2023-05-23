import java.util.*;
class edge {
    int src;
    int dest;

    public edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

public class dfsbfs {
    public static void dfs(ArrayList<edge> graph[]) {
        // vis[curr] = true;
        // System.out.print(curr + " ");
        // for (int i = 0; i < graph[curr].size(); i++) {
        //     // System.out.print(curr+" ");
        //     edge e = graph[curr].get(i);
        //     if (!vis[e.dest]) {
        //         dfs(graph, vis, e.dest);
        //     }
        // }
        boolean vis[] = new boolean[graph.length];

        Stack<Integer> s1 = new Stack<>();

        s1.push(1);
        vis[1] = true;

        while (!s1.isEmpty()) {
            int curr = s1.pop();
            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                edge e = graph[curr].get(i);
                if (!vis[e.dest]) {
                    vis[e.dest] = true;
                    s1.push(e.dest);
                }
            }
        }
    }

    public static void bfs(ArrayList<edge> graph[]) {
        boolean vis[] = new boolean[graph.length];

        Queue<Integer> q1 = new LinkedList<>();

        q1.add(1);
        vis[1] = true;

        while (!q1.isEmpty()) {
            int curr = q1.remove();
            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                edge e = graph[curr].get(i);
                if (!vis[e.dest]) {
                    vis[e.dest] = true;
                    q1.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<edge> graph[] = new ArrayList[5];
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
        
        
        graph[0].add(new edge(0, 1));
        graph[0].add(new edge(0, 4));
        
        graph[1].add(new edge(1, 2));
        graph[1].add(new edge(1, 0));

        // graph[2].add(new edge(2, 0));
        graph[2].add(new edge(2, 1));
        graph[2].add(new edge(2, 3));
        // graph[2].add(new edge(2, 4));

        graph[3].add(new edge(3, 2));
        // graph[3].add(new edge(3, 4));

        graph[4].add(new edge(4, 0));
        // graph[4].add(new edge(4, 3));

        // boolean vis[] = new boolean[5];

        dfs(graph);
        System.out.println();
        bfs(graph);

    }
}