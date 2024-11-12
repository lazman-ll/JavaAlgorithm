package com.lilong.java;

public class MyLinkedList{
    private int val;
    private MyLinkedList next;

    public MyLinkedList() {
        
    }


    public int get(int index) {
        if(index < 0){
            return -1;
        }
        MyLinkedList cur = this;
        while (index >= 0){
            if(cur != null){
                cur = cur.next;
            }
            index--;
        }
        if(cur == null){
            return -1;
        }else {
            return cur.val;
        }
    }

    public void addAtHead(int val) {
        MyLinkedList cur = new MyLinkedList();
        cur.val = val;
        cur.next = this.next;
        this.next = cur;
    }
    
    public void addAtTail(int val) {
        MyLinkedList add = new MyLinkedList();
        add.val = val;
        MyLinkedList cur = this;
        while(cur.next!= null){
            cur = cur.next;
        }
        cur.next = add;
    }
    
    public void addAtIndex(int index, int val) {
        MyLinkedList add = new MyLinkedList();
        add.val = val;
        MyLinkedList cur = this;
        int length = getLength(this);
        if(length < index){
            return;
        }else if(length == index){
            addAtTail(val);
        }else {
            while(index > 0){
                cur = cur.next;
                index--;
            }
            add.next = cur.next;
            cur.next = add;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(this.next==null){
            return;
        }
        int length = getLength(this);
        if(index < 0||index >= length){
            return;
        }
        MyLinkedList cur = this;
        while (index > 0){
            cur = cur.next;
            index--;
        }
        cur.next = cur.next.next;
    }

    public int getLength(MyLinkedList list){
        if(list == null||list.next==null){
            return 0;
        }
        MyLinkedList cur = list;
        int index = 0;
        while (cur.next!= null){
            cur = cur.next;
            index++;
        }
        return index;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */