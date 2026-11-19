public class Solution {
    public  ListNode  addTwoNumbers(ListNode l1,ListNode l2){
        //哑节点
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        //进位
        int carry = 0;

        //只要l1还有 或者 l2还有 或者还有进位 就要继续算
        while (l1 != null || l2 != null || carry != 0) {
            //如果链表走完了 就取0
            int v1 = (l1 != null)? l1.val : 0;
            int v2 = (l2 != null)? l2.val : 0;

            //当前总和
            int sum = v1 + v2 + carry;

            //算出新进位
            carry = sum/10;
            //当前位的值
            int curVal = sum %10;

            //新建一个节点挂上去
            cur.next = new ListNode(curVal);
            //结果指针往后走
            cur = cur.next;

            //原链表指针往后移动（不为空才移动）
            if (l1 != null)l1 = l1.next;
            if (l2 != null)l2 = l2.next;

        }
        //dummy是假头; 真正链表从dummy.next开始
        return dummy.next;
    }
}
