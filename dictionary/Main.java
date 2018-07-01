
import java.util.*;

class Main{

    static int[][] graph;
    static ArrayList<Integer> result;
    static boolean[] visit;
    static ArrayList<Integer> sorted;
    static int n;


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-->0){
            n = sc.nextInt();

            String[] words = new String[n];

            sc.nextLine();
            for(int i=0; i<n; i++){
                words[i] = sc.nextLine();
            }

            toGraph(words);
            result = sortGraph();


            if(result.size()==0){
                System.out.println("INVALID HYPOTHESIS");
            } else {
                for(int i = 0; i<result.size(); i++){
                    System.out.print(Character.toString((char)((int)result.get(i)+'a')));
                }
            }

        }

        sc.close();

    }

    public static void toGraph(String[] words){

        graph = new int[26][26];

        for(int i = 1; i<words.length; i++){
            int j = i-1;

            int minLength = Math.min(words[i].length(), words[j].length());

            for(int k=0; k<minLength; k++){
                if(words[i].charAt(k)!=words[j].charAt(k)){
                    int first = words[j].charAt(k) - 'a';
                    int second = words[i].charAt(k) - 'a';

                    graph[first][second] = 1;
                    break;
                }
            }
        }

    }

    public static ArrayList<Integer> sortGraph(){

        visit = new boolean[26];
        sorted = new ArrayList<Integer>();

        for(int i=0; i<visit.length; i++){
            if(!visit[i]){
                dfs(i);
            }
        }

        Collections.reverse(sorted.subList(0,sorted.size()));

        for(int i=0; i < n; i++){
            for(int j = i+1 ; j < n; j++){
                if(graph[sorted.get(j)][sorted.get(i)]==1) return new ArrayList<Integer>();
            }
        }

        return sorted;
    }

    public static void dfs(int i){
        visit[i] = true;
        for(int next = 0; next < graph.length; next++){
            if(graph[i][next]==1 && !visit[next]) dfs(next);
        }

        sorted.add(i);
    }
}

