package com.lilong.test;

import com.lilong.java.MyLinkedList;
import org.junit.jupiter.api.Test;

public class Test1 {

    @Test
    public void testMyLinkedList(){
        MyLinkedList list =new MyLinkedList();
        list.addAtHead(2);
        int length = list.getLength(list);
        list.deleteAtIndex(1);
    }
    @Test
    public void testRemoveNthFromEnd(){

    }
}
