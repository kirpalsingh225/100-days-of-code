import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day84 {
    List<String> total = new ArrayList<>();
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public String smallestFromLeaf(TreeNode root) {
        helper(root, "");
        Collections.sort(total);
        return total.get(0);
    }

    void helper(TreeNode root, String str){
        if(root==null){
            return;
        }
        if(root.left == null && root.right == null){

            total.add(new StringBuilder(str+alphabet[root.val]).reverse().toString());
            return;
        }
        str+=alphabet[root.val];
        helper(root.left, str);
        helper(root.right, str);
        str = str.substring(0, str.length()-1);
    }
}
