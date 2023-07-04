import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day91 {
    void inorder(TreeNode root, List<Integer> lst){
        if(root==null){
            return;
        }
        inorder(root.left, lst);
        lst.add(root.val);
        inorder(root.right, lst);
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> q) {
        List<Integer> kk = new ArrayList<>();
        inorder(root, kk);
        Collections.sort(kk);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<q.size();i++){
            int ele=q.get(i),s=-1,p=-1;
            int l=0,h=kk.size()-1;
            while(l<=h)
            {
                int mid=(l+h)/2;
                if(kk.get(mid)==ele) 
                {
                    s=ele;
                    break;
                }
                else if(kk.get(mid)<ele) 
                {
                    s=kk.get(mid);
                    l=mid+1;
                }
                else
                {
                    h=mid-1;
                }
            }
            l=0;
            h=kk.size()-1;
            while(l<=h)
            {
                int mid=(l+h)/2;
                if(kk.get(mid)==ele) 
                {
                    p=ele;
                    break;
                }
                else if(kk.get(mid)>ele) 
                {
                    p=kk.get(mid);
                    h=mid-1;
                }
                else
                {
                    l=mid+1;
                }
            }
            List<Integer> f=new ArrayList<>();
            f.add(s);
            f.add(p);
            result.add(new ArrayList<>(f));
            
        }
        return result;
    }

}
