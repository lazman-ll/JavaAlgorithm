package com.lilong.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetectCycle {
    /**
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * @param head 链表的头节点
     * @return 返回入环的第一个节点，无环返回null
     */
    public ListNode detectCycle(ListNode head) {
        ListNode cur = head;
        Set<ListNode> set = new HashSet<>();
        set.add(cur);
        while(cur!=null){
            cur = cur.next;
            if(set.contains(cur)){
                return cur;
            }
            set.add(cur);
        }
        return null;
    }

    /**
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * @param head 链表的头节点
     * @return 返回入环的第一个节点，无环返回null
     * 方法二：使用快慢指针
     */
    public ListNode detectCycle2(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null){
            //fast一次移动两格
            fast = fast.next.next;
            //slow一次移动一格
            slow = slow.next;
            //fast和slow相交，表示有环
            if(fast == slow){
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index2!=index1){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index2;
            }

        }
        Set set =new HashSet<>();
        return null;

    }

}
