import java.util.ArrayList;
import java.util.List;

public class day75 {
    int pairs = 0;
    public int countPairs(TreeNode root, int distance) {
        helper(root, distance);
        return pairs;
    }
    List<Integer> helper(TreeNode root, int distance){
        if(root==null){
            return new ArrayList();
        }
        if(root.left==null && root.right==null){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            return temp;
        }

        List<Integer> l = helper(root.left, distance);
        List<Integer> r = helper(root.right, distance);

        for(int x : l){
            for(int y : r){
                if(x+y<=distance){
                    pairs++;
                }
            }
        }

        List<Integer> arr = new ArrayList<>();
        for(int x : l){
            arr.add(x+1);
        }
        for(int x : r){
            arr.add(x+1);
        }
        return arr;
    }
}
