package com.datastructure.linkedlist.single;

public class SingleLinkedList {

  private SingleLinkedListNode head = null;
  private SingleLinkedListNode tail = null;

  public SingleLinkedListNode getHead() {
    return head;
  }

  public void setHead(SingleLinkedListNode head) {
    this.head = head;
  }

  public SingleLinkedListNode getTail() {
    return tail;
  }

  public void setTail(SingleLinkedListNode tail) {
    this.tail = tail;
  }

  public SingleLinkedList() {
  }

  /**
   * Creates a new Single Linked List with single node
   */
  public SingleLinkedList(int value) {
    createFirstNode(value);
  }

  private void createFirstNode(int value) {
    // Create node
    SingleLinkedListNode node = new SingleLinkedListNode();
    // Set value
    node.setValue(value);
    // Point head to the node
    head = node;
    // Point tail to the node
    tail = node;
  }

  /**
   * Add a new node at the beginning
   */
  public void addNodeAtStart(int value) {
    if (head == null) {
      createFirstNode(value);
      return;
    }

    SingleLinkedListNode node = new SingleLinkedListNode();
    node.setValue(value);

    node.setNextNode(head);
    head = node;
  }

  /**
   * Add a new node at the end
   */
  public void addNodeAtEnd(int value) {
    if (head == null) {
      createFirstNode(value);
      return;
    }

    SingleLinkedListNode node = new SingleLinkedListNode();
    node.setValue(value);
    node.setNextNode(null);

    tail.setNextNode(node);
    tail = node;
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
    SingleLinkedListNode tempNode = head;

    while (currentLocation < location - 1 && tempNode != tail) {
      tempNode = tempNode.getNextNode();
      currentLocation++;
    }

    if (tempNode == tail) {
      addNodeAtEnd(value);
      return;
    }

    SingleLinkedListNode node = new SingleLinkedListNode();
    node.setValue(value);

    node.setNextNode(tempNode.getNextNode());
    tempNode.setNextNode(node);
  }

  /**
   * Returns the location of first node with given value. Returns 0 if not found
   */
  public int findNode(int value) {
    int location = 0;

    SingleLinkedListNode temp = head;

    while (temp != tail) {
      location++;

      if (temp.getValue() == value) {
        return location;
      }

      temp = temp.getNextNode();
    }

    if (temp.getValue() == value) {
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

    SingleLinkedListNode temp = head;

    // traversing till the node before tail node
    while (temp.getNextNode() != tail) {
      temp = temp.getNextNode();
    }

    tail = temp;
    tail.setNextNode(null);
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

    if (head == tail) {
      head = tail = null;
      return;
    }

    int currentLocation = 1;
    SingleLinkedListNode temp = head;

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

    SingleLinkedListNode temp = head;

    while (temp != tail) {
      System.out.printf("%s %s -> ", temp.getValue(), temp == head && temp == tail ? "HT" : temp == head ? "H" : temp == tail ? "T" : "");
      temp = temp.getNextNode();
    }
    System.out.printf("%s %s -> ", temp.getValue(), temp == head && temp == tail ? "HT" : temp == head ? "H" : temp == tail ? "T" : "");
    if (temp.getNextNode() == head) {
      System.out.printf("C");
    }
    System.out.println();
  }

  public String toString() {
    if (head == null) {
      return "Empty list";
    }

    SingleLinkedListNode temp = head;
    StringBuffer buffer = new StringBuffer();

    while (temp != tail) {
      buffer.append(temp.getValue()).append(temp == head && temp == tail ? "HT" : temp == head ? "H" : temp == tail ? "T" : "").append(" -> ");
      temp = temp.getNextNode();
    }
    buffer.append(temp.getValue()).append(temp == head && temp == tail ? "HT" : temp == head ? "H" : temp == tail ? "T" : "").append(" -> ");
    if (temp.getNextNode() == head) {
      buffer.append("C");
    }
    return buffer.toString();
  }
}
