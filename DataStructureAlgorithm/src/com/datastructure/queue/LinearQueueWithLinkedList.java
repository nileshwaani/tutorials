package com.datastructure.queue;

import com.datastructure.linkedlist.single.SingleLinkedList;
import com.datastructure.linkedlist.single.SingleLinkedListNode;

public class LinearQueueWithLinkedList {

  private SingleLinkedList linkedList = null;

  public LinearQueueWithLinkedList() {
    linkedList = new SingleLinkedList();
  }

  /**
   * Enqueue an element in the queue
   */
  public void enqueue(int value) {
    if (linkedList.getHead() == null) {
      linkedList = new SingleLinkedList(value);
    }
    else {
      linkedList.addNodeAtEnd(value);
    }
  }

  /**
   * Dequeue an element from the queue
   */
  public int dequeue() throws Exception {
    if (isEmpty()) {
      throw new Exception("Queue is empty!");
    }

    int value = linkedList.getHead().getValue();
    linkedList.deleteNodeAtStart();
    return value;
  }

  /**
   * Peek an element from the queue
   */
  public int peek() throws Exception {
    if (isEmpty()) {
      throw new Exception("Queue is empty!");
    }

    return linkedList.getHead().getValue();
  }

  /**
   * Check if the queue is empty
   */
  public boolean isEmpty() {
    return linkedList.getHead() == null;
  }

  public void print() {
    if (isEmpty()) {
      System.out.println("Empty Queue");
      return;
    }

    System.out.print("Queue => ");
    
    SingleLinkedListNode node = linkedList.getHead();
    
    while(node != null) {
      System.out.printf("%s | ", node.getValue());
      node = node.getNextNode();
    }
    System.out.println();

  }
}
