package com.datastructure.linkedlist.circulardoubly;

public class CircularDoubleLinkedListNode {
  private int value;
  private CircularDoubleLinkedListNode nextNode;
  private CircularDoubleLinkedListNode prevNode;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public CircularDoubleLinkedListNode getNextNode() {
    return nextNode;
  }

  public void setNextNode(CircularDoubleLinkedListNode nextNode) {
    this.nextNode = nextNode;
  }

  public CircularDoubleLinkedListNode getPrevNode() {
    return prevNode;
  }

  public void setPrevNode(CircularDoubleLinkedListNode prevNode) {
    this.prevNode = prevNode;
  }

}
