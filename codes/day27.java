import java.util.*;
public class day27 {
    class node{
        String key;
        double val;
        
        node(String key , double val){
            this.key = key;
            this.val = val;
        }
    }
     public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>>queries){ 
         Map<String , List<node>> graph = buildgraph(equations , values);
         
         double[] result = new double[queries.size()];
         
         for(int i=0;i<queries.size();i++){
             result[i] = dfs(queries.get(i).get(0) , queries.get(i).get(1) , new HashSet() , graph);
         }
         return result;
     }
     
     double dfs(String s , String d , Set<String> visited , Map<String , List<node>> graph){
         if(!(graph.containsKey(s) && graph.containsKey(d))){
             return -1.0;
         }
         if(s.equals(d)){
             return 1.0;
         }
         visited.add(s);
         
         for(node ng : graph.get(s)){
             if(!visited.contains(ng.key)){
                 double ans = dfs(ng.key , d , visited , graph);
                 if(ans!=-1){
                     return ans*ng.val;
                 }
             }
         }
         return -1.0;
     }
     
     private Map<String , List<node>> buildgraph(List<List<String>> eq , double[] va){
         Map<String , List<node>> graph = new HashMap<>();
         
         for(int i=0;i<eq.size();i++){
             String src = eq.get(i).get(0);
             String dest = eq.get(i).get(1);
             graph.putIfAbsent(src , new ArrayList());
             graph.putIfAbsent(dest , new ArrayList());
             graph.get(src).add(new node(dest , va[i]));
             graph.get(dest).add(new node(src , 1/va[i]));
         }
         return graph;
     }
}
