import java.util.*;
class job implements Comparable<job>{
    char id;
    int dead;
    int profit;
    
    public job(char id,int dead,int profit){
        this.id=id;
        this.dead=dead;
        this.profit=profit;
        
    }
    
    @Override
    public int compareTo(job a){
        return this.profit-a.profit;
    }
}
public class jobscheduling
{
    public static void getJobInfo(ArrayList<job> jobInfo){
        // Scanner sc=new Scanner(System.in);
        // int choice=1;
        // while(choice==1){
        //     System.out.println("enter id:");
        //     char id=sc.next().charAt(0);
        //     System.out.println("enter dead:");
        //     int dead=sc.nextInt();
        //     System.out.println("Enter the profit:");
        //     int profit=sc.nextInt();
        
        //     jobInfo.add(new job(id,dead,profit));

        //     System.out.println("You wont to add more jobs: 1 or 0");

        //     choice=sc.nextInt();

        // }
        jobInfo.add(new job('a',2,100));
        jobInfo.add(new job('b',1,19));
        jobInfo.add(new job('c',2,27));
        jobInfo.add(new job('d',1,25));
        jobInfo.add(new job('e',3,15));
    }
    public static char[] getJobId(ArrayList<job> jobInfo){
        Collections.sort(jobInfo,Collections.reverseOrder());
        int maxdead=0;
        for(int i=0;i<jobInfo.size();i++){
            job j=jobInfo.get(i);
            if(maxdead<j.dead){
                maxdead=j.dead;
            }
        }
        
        char result[]=new char[maxdead];
        
        
        for(int i=0;i<result.length;i++){
            result[i]='/';
        }
        int i=0;int j=0;
        while(j!=maxdead &&i<jobInfo.size()){
            job J=jobInfo.get(i);
            if(result[J.dead-1]=='/'){
                result[J.dead-1]=J.id;
                // System.out.println(result[J.dead-1]);
                j++;
            }else{
                for(int k=J.dead-2;k>=0;k--){
                    if(result[k]=='/'){
                        result[k]=J.id;
                        j++;
                        break;
                    }
                    j++;
                }
                
            }
            i++;
        }
        return result;
    }
	public static void main(String[] args) {
		ArrayList<job> jobInfo= new ArrayList<>();
		getJobInfo(jobInfo);
		char result[]=getJobId(jobInfo);
		for(int i=0;i<result.length;i++){
		    System.out.print(result[i]+" ");
		}
	}
}