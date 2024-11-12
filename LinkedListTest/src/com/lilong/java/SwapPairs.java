package com.lilong.java;

import java.lang.invoke.VarHandle;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode vHead = new ListNode();
        vHead.next = head;
        ListNode cur = vHead;

        while(cur.next!=null&&cur.next.next!=null){
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            cur.next = node2;
            ListNode temp = node2.next;
            node2.next = node1;
            node1.next = temp;
            cur = cur.next.next;
        }
        return vHead.next;
    }
}
