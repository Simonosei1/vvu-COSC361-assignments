
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist;
import java.util.*;

/**
 *
 * @author 
 */
class DoublyLinkedList {    
    //A node class for doubly linked list
    class Node{  
        String name;  
        Node previous;  
        Node next;  
   
        public Node(String name) {  
            this.name = name;  
        }  
    }  
    //Initially, heade and tail is set to null
    Node head, tail = null;  
   
    //add a node to the list  
    public void addNode(String name) {  
        //Create a new node  
        Node newNode = new Node(name);  
   
        //if list is empty, head and tail points to newNode  
        if(head == null) {  
            head = tail = newNode;  
            //head's previous will be null  
            head.previous = null;  
            //tail's next will be null  
            tail.next = null;  
        }  
        else {  
            //add newNode to the end of list. tail->next set to newNode  
            tail.next = newNode;  
            //newNode->previous set to tail  
            newNode.previous = tail;  
            //newNode becomes new tail  
            tail = newNode;  
            //tail's next point to null  
            tail.next = null;  
        }  
    }  
   
//print all the nodes of doubly linked list  
    public void printNodes() {  
        //Node current will point to head  
        Node current = head;  
        if(head == null) {  
            System.out.println("The family Tree is empty.");  
            return;  
        }  
        System.out.println("Names of the Family : ");  
        while(current != null) {  
            //Print each node and then go to next.  
            System.out.print(current.name + " ");  
            current = current.next;  
        }  
    }  

    public static void main(String[] args) {  
        //create a DoublyLinkedList object
        DoublyLinkedList dl_List = new DoublyLinkedList();  
        Scanner Sparrow = new Scanner(System.in);
        int treesize;
        System.out.println("Please enter the tree size");
        treesize = Sparrow.nextInt();
         System.out.println("Please enter the names ");
        
        String node;
        int count =0;
        while(count<=treesize) 
        {
            //System.out.println("Name: " + count);
            node = Sparrow.nextLine();
            //Inserting the nodes
             dl_List.addNode(node);  
              count++;
        }
        
        //Add nodes to the list  
        /*dl_List.addNode(10);  
        dl_List.addNode(20);  
        dl_List.addNode(30);  
        dl_List.addNode(40);  
        dl_List.addNode(50);*/  
   
        //print the nodes of DoublyLinkedList  
        dl_List.printNodes();  
    } 
}