package com.lilong.java;

public class GetIntersectionNode {
    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
     * @param headA 链表A
     * @param headB 链表B
     * @return 返回相交的起始节点，没有则返回null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        int diff = lengthB - lengthA;
        if(diff < 0){
            //A大,将链表A往后移动diff的绝对值长度
            ListNode curA = removeIndex(headA, Math.abs(diff));
            ListNode curB = headB;
            return getPoint(curA,curB);

        }else {
            ListNode curB = removeIndex(headB, diff);
            ListNode curA = headA;
            return getPoint(curA,curB);
        }

    }

    /**
     * 获取链表的长度
     * @return 返回一个正整数，表示链表的长度
     */
    private int getLength(ListNode head){
        ListNode cur = head;
        int index = 0;
        while(cur!=null){
            index++;
            cur = cur.next;
        }
        return index;
    }

    private ListNode removeIndex(ListNode head,int index){
        ListNode cur = head;
        while(index > 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    private ListNode getPoint(ListNode curA, ListNode curB){
        while(curA !=null&& curB != null){
            if(curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
