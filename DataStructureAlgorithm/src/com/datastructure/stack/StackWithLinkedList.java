package com.datastructure.stack;

import com.datastructure.linkedlist.single.SingleLinkedList;

public class StackWithLinkedList {

  private SingleLinkedList linkedList = null;

  /**
   * Push a value into the stack
   */
  public void push(int value) {
    if (linkedList == null) {
      linkedList = new SingleLinkedList(value);
    }
    else {
      linkedList.addNodeAtStart(value);
    }
  }

  /**
   * Pop value from the stack
   */
  public int pop() throws Exception {
    if (isEmpty()) {
      throw new Exception("Stack is empty..");
    }
    int value = linkedList.getHead().getValue();
    linkedList.deleteNodeAtStart();
    return value;
  }

  /**
   * Peek value from the stack
   */
  public int peek() throws Exception {
    if (isEmpty()) {
      throw new Exception("Stack is empty..");
    }
    return linkedList.getHead().getValue();
  }

  /**
   * Check if stack is empty
   */
  public boolean isEmpty() {
    return linkedList == null || linkedList.getHead() == null;
  }

  /**
   * Check if stack is empty
   */
  public boolean isFull() {
    return false;
  }

  public void print() {
    if (linkedList == null) {
      System.out.println("Empty Stack");
      return;
    }
    System.out.print("Stack => ");
    linkedList.print();
    System.out.println();
  }
}