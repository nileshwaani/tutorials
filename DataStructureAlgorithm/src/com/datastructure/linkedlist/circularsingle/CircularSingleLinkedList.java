package com.datastructure.linkedlist.circularsingle;

public class CircularSingleLinkedList {

  private CircularSingleLinkedListNode head = null;
  private CircularSingleLinkedListNode tail = null;

  public CircularSingleLinkedListNode getHead() {
    return head;
  }

  public void setHead(CircularSingleLinkedListNode head) {
    this.head = head;
  }

  public CircularSingleLinkedListNode getTail() {
    return tail;
  }

  public void setTail(CircularSingleLinkedListNode tail) {
    this.tail = tail;
  }

  /**
   * Creates a new Single Linked List with single node
   */
  public CircularSingleLinkedList(int value) {
    createFirstNode(value);
  }

  private void createFirstNode(int value) {
    // Create node
    CircularSingleLinkedListNode node = new CircularSingleLinkedListNode();
    // Set value
    node.setValue(value);
    // Point head to the node
    head = node;
    // Point tail to the node
    tail = node;
    // For circular linked list, tail refers back to head
    tail.setNextNode(head);
  }

  /**
   * Add a new node at the beginning
   */
  public void addNodeAtStart(int value) {
    if (head == null) {
      createFirstNode(value);
      return;
    }

    CircularSingleLinkedListNode node = new CircularSingleLinkedListNode();
    node.setValue(value);

    node.setNextNode(head);
    head = node;
    
    tail.setNextNode(head);
  }

  /**
   * Add a new node at the end
   */
  public void addNodeAtEnd(int value) {
    if (head == null) {
      createFirstNode(value);
      return;
    }

    CircularSingleLinkedListNode node = new CircularSingleLinkedListNode();
    node.setValue(value);

    tail.setNextNode(node);
    tail = node;
    
    tail.setNextNode(head);
  }

  /**
   * Add a new node at the given location
   */
  public void addNodeAtLocation(int value, int location) {

    if (head == null) {
      createFirstNode(value);
      return;
    }

    if (location == 1) {
      addNodeAtStart(value);
      return;
    }

    if (head == tail) {
      addNodeAtEnd(value);
      return;
    }

    int currentLocation = 1;
    CircularSingleLinkedListNode tempNode = head;

    while (currentLocation < location - 1 && tempNode != tail) {
      tempNode = tempNode.getNextNode();
      currentLocation++;
    }

    if (tempNode == tail) {
      addNodeAtEnd(value);
      return;
    }

    CircularSingleLinkedListNode node = new CircularSingleLinkedListNode();
    node.setValue(value);

    node.setNextNode(tempNode.getNextNode());
    tempNode.setNextNode(node);
  }

  /**
   * Returns the location of first node with given value. Returns 0 if not found
   */
  public int findNode(int value) {
    int location = 0;

    CircularSingleLinkedListNode temp = head;

    while (temp != tail) {
      location++;

      if (temp.getValue() == value) {
        return location;
      }

      temp = temp.getNextNode();
    }
    
    if(temp.getValue() == value) {
      return location + 1;
    }

    return 0;
  }

  /**
   * Delete the node at the beginning
   */
  public void deleteNodeAtStart() {
    if (head == null) {
      return;
    }

    if (head == tail) {
      head = tail = null;
      return;
    }

    head = head.getNextNode();
    tail.setNextNode(head);
  }

  /**
   * Delete the node at the end
   */
  public void deleteNodeAtEnd() {
    if (head == null) {
      return;
    }

    if (head == tail) {
      head = tail = null;
      return;
    }

    CircularSingleLinkedListNode temp = head;

    // traversing till the node before tail node
    while (temp.getNextNode() != tail) {
      temp = temp.getNextNode();
    }

    tail = temp;
    tail.setNextNode(head);
  }

  /**
   * Delete the node at given location
   */
  public void deleteNodeAtLocation(int location) {
    if (head == null) {
      return;
    }      

    if (location == 1) {
      deleteNodeAtStart();
      return;
    }
    
    if(head == tail) {
      head = tail = null;
      return;
    }

    int currentLocation = 1;
    CircularSingleLinkedListNode temp = head;

    while (currentLocation < location - 1 && temp.getNextNode() != tail) {
      temp = temp.getNextNode();
      currentLocation++;
    }

    if (temp.getNextNode() == tail) {
      deleteNodeAtEnd();
      return;
    }

    temp.setNextNode(temp.getNextNode().getNextNode());
  }

  public void print() {
    if (head == null) {
      System.out.println("Empty list");
      return;
    }

    CircularSingleLinkedListNode temp = head;

    while (temp != tail) {
      System.out.printf("%s %s -> ", temp.getValue(), temp == head && temp == tail ? "HT" : temp == head ? "H" : temp == tail ? "T" : "");
      temp = temp.getNextNode();
    }
    System.out.printf("%s %s -> ", temp.getValue(), temp == head && temp == tail ? "HT" : temp == head ? "H" : temp == tail ? "T" : "");
    if(temp.getNextNode() == head) {
      System.out.printf("C");
    }
    System.out.println();
  }

  public String toString() {
    if (head == null) {
      return "Empty list";
    }

    CircularSingleLinkedListNode temp = head;
    StringBuffer buffer = new StringBuffer();

    while (temp != tail) {
      buffer.append(temp.getValue()).append(temp == head && temp == tail ? "HT" : temp == head ? "H" : temp == tail ? "T" : "").append(" -> ");
      temp = temp.getNextNode();
    }
    buffer.append(temp.getValue()).append(temp == head && temp == tail ? "HT" : temp == head ? "H" : temp == tail ? "T" : "").append(" -> ");
    if(temp.getNextNode() == head) {
      buffer.append("C");
    }
    return buffer.toString();
  }
}
