package com.lilong.java;

public class RemoveEle {

    /**
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     * @param head 头节点
     * @param val 要删除的元素的值
     * @return 返回的链表
     */
    public ListNode removeElements(ListNode head, int val) {
        //为其设置一个虚拟的头节点
        ListNode vHead = new ListNode();
        vHead.next = head;
        ListNode cur = vHead;
        while (cur.next!=null){
            //其下一个节点的值为要删除的值
            if(cur.next.val == val){
                //将该元素删除
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return vHead.next;
    }


}
