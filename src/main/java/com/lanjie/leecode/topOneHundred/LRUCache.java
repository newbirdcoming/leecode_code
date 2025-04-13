package com.lanjie.leecode.topOneHundred;

import java.util.HashMap;

/**
 * @author Mr.Lan
 * @version 1.0
 * @ClassName LRC$
 * @description LRUcache cache 基于HashMap列表  双链表作为节点，并增加了 capicity head tail 《头插法 尾部删除》
 * @date 2025/4/8 20:55
 **/
public class LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.get(2);
        lruCache.put(5,5);
        for (Node value : lruCache.cache.values()) {
            System.out.println(value.value);
        }

    }
    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }

        public Node(){
        }
    }
    int capicity;
    int size;
    HashMap<Integer,Node> cache;
    Node head;
    Node tail;

    public LRUCache(int capicity){
        this.capicity=capicity;
        cache=new HashMap<>();
        head=new Node();
        tail=new Node();
        tail.pre=head;
        head.next=tail;
    }


    public int get(int key) {
        Node cur=cache.get(key);
        // 不存在
        if(cur==null){
            return -1;
        }
        // 存在
        movetohead(cur);
        return cur.value;
    }


    void movetohead(Node cur){
        // 修改链表连接
        cur.next.pre=cur.pre;
        cur.pre.next=cur.next;
        // 插入到头部并修改cur连接
        cur.pre=head;
        cur.next=head.next;
        head.next.pre=cur;
        head.next=cur;
    }

    public void put(int key, int value) {
        Node cur=cache.get(key);
        // 不存在 直接头插
        if(cur==null){
            Node newNode=new Node(key,value);
            newNode.next=head.next;
            newNode.pre=head;
            head.next.pre=newNode;
            head.next=newNode;
            cache.put(key,newNode);
            size++;
            if(size>capicity){
                // 删除链表连接
                Node deleteNode=tail.pre;
                tail.pre.pre.next=tail;
                tail.pre=tail.pre.pre;
                // 删除节点
                cache.remove(deleteNode.key);
                size--;
            }
        }
        // 存在直接更新并移到头部
        else{
            movetohead(cur);
            cur.value=value;
        }

    }

}
