import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day70 {
    int freq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> lst = new ArrayList<>();
        int max = Collections.max(map.values());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()==max){
                lst.add(entry.getKey());
            }
        }
        int[] arr = new int[lst.size()];
        for(int i=0;i<lst.size();i++){
            arr[i] = lst.get(i);
        }
        return arr;
    }

    int dfs(TreeNode root, Map<Integer, Integer> map){
        if(root==null){
            return 0;
        }
        int left = dfs(root.left, map);
        int right = dfs(root.right, map);

        int sum = root.val+left+right;
        if(map.containsKey(sum)){
            map.put(sum, map.get(sum)+1);
        }
        else{
            map.put(sum, 1);
        }
        return sum;
        
    }
}
