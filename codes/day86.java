import java.util.ArrayList;
import java.util.List;

public class day86 {
    public int maxProduct(TreeNode root) {
        final int kMod = 1_000_000_007;
        long ans = 0;
        List<Integer> lst = new ArrayList<>();
        long totalsum = sum(root, lst);
        for(long sum : lst){
            ans = Math.max(ans, sum*(totalsum-sum));
        }
        return (int)(ans%kMod);
    }

    int sum(TreeNode root, List<Integer> lst){
        if(root==null){
            return 0;
        }
        int left = sum(root.left, lst);
        int right = sum(root.right, lst);
        int sum = root.val + left + right;
        lst.add(sum);
        return sum;
    }
}
