package com.lilong.java;

public class RemoveNthFromEnd {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * @param head 链表的头节点
     * @param n 正整数，表示倒数第几个节点
     * @return 返回删除节点后的链表的头节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //虚拟头节点
        ListNode vHead = new ListNode();
        vHead.next = head;
        //cur用来遍历
        ListNode cur = head;
        //pre用来表示最后要删除的节点的前一个节点
        ListNode pre = vHead;
        //用作引导，表示什么时候pre向后
        int index = 0;

        while(cur!=null){
            cur = cur.next;
            index++;
            //当index大于等于n时，表示pre节点为cur节点的往前n个节点
            if(index > n){
                pre = pre.next;
            }
        }
        if(pre.next!=null){
            pre.next = pre.next.next;
        }else {
            pre.next = cur;
        }
        return vHead.next;
    }
}
