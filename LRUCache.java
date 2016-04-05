package marshal.practice.com;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    
    
    int capacity;
    
    HashMap<Integer,Node> map;
    LinkedList<Node> list;
    Node head;
    Node end;
    
    public LRUCache(int capacity) {
     
     this.capacity = capacity;
     this.map = new HashMap<Integer,Node>();
     this.list = new LinkedList<Node>();
     this.head = null;
     this.end = null;
        
    }
    
    public int get(int key) {
        
    	int val = -1;
        if(this.map.containsKey(key)){
            val = this.map.get(key).value;
            Node tNode = this.map.get(key);
            this.map.remove(key);
            remove(tNode);
            set(tNode.key, tNode.value);
            return val;
        }
        //return this.map.get(key).value;
        
        else
        return val;
        
 
    }
    
    public void set(int key, int value) {
        
        Node newNode = new Node(key,value);
        //System.out.println(this.map.size());
        if(!(this.map.containsKey(key))){
            
            if(this.map.size()<this.capacity){
                this.map.put(key, newNode);
                //this.list.offer(newNode);
                insert(newNode);
                
            }
            else{
                
                //System.out.println(this.head.key);
                Node tNode = this.head;
                this.head = tNode.next;
                
                
                
                if(this.head!=null)
                this.head.prev = null;
                else
                	this.end=null;
                
                
                this.map.remove(tNode.key);
                
                //this.list.offer(newNode);
                insert(newNode);
                this.map.put(newNode.key, newNode);
            }
            
        }
        else{
            
            Node tNode = this.map.get(key);
            this.map.remove(key);
            //this.list.remove(tNode);
            this.map.put(newNode.key,newNode);
           // this.list.offer(newNode);
           remove(tNode);
           insert(newNode);
            
        }
        
    }
    
    private void insert(Node n){
        
        if(this.head==null && this.end==null){
            this.head = n;
            this.end = n;
        }
        else if(this.head!=null && this.end!=null){
            this.end.next=n;
            n.prev = this.end;
            this.end = n;
        }
        
    }
    
    private void remove(Node n){
        
        if(n.prev == null){
            this.head = n.next;
            
            if(n.next!=null)
            n.next.prev = null;
        }
        
         if(n.next==null){
            this.end = n.prev;
            
            if(n.prev!=null)
            n.prev.next=null;
            
        }
         
        if(n.next!=null && n.prev!=null){
            
            Node p = n.prev;
            Node nxt = n.next;
            
            p.next = nxt;
            nxt.prev = nxt;
        }
        
    }
}

class Node{
    
    int key;
    int value;
    Node next;
    Node prev;
    
    public Node(int k, int v){
        
        this.key=k;
        this.value=v;
    }
}