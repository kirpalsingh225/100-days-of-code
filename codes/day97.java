import java.util.ArrayList;
import java.util.Stack;

public class day97 {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> array = new ArrayList<>();
        
        while(head!=null){
            array.add(head.val);
            head = head.next;
        }
        int[] answer = new int[array.size()];
        Stack<Integer> s = new Stack<>();
        for(int i=array.size()-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=array.get(i)){
                s.pop();
            }
            if(s.isEmpty()){
                answer[i] = 0;
            }
            else{
                answer[i] = s.peek();
            }
            s.push(array.get(i));
        }
        
        return answer;
    }
}
