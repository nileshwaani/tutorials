package com.datastructure.linkedlist.doubly;

public class DoubleLinkedListNode {
  private int value;
  private DoubleLinkedListNode nextNode;
  private DoubleLinkedListNode prevNode;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public DoubleLinkedListNode getNextNode() {
    return nextNode;
  }

  public void setNextNode(DoubleLinkedListNode nextNode) {
    this.nextNode = nextNode;
  }

  public DoubleLinkedListNode getPrevNode() {
    return prevNode;
  }

  public void setPrevNode(DoubleLinkedListNode prevNode) {
    this.prevNode = prevNode;
  }

}
