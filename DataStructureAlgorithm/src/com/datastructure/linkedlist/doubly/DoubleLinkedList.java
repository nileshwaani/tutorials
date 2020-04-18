package com.datastructure.linkedlist.doubly;

public class DoubleLinkedList {

  private DoubleLinkedListNode head = null;
  private DoubleLinkedListNode tail = null;

  public DoubleLinkedListNode getHead() {
    return head;
  }

  public void setHead(DoubleLinkedListNode head) {
    this.head = head;
  }

  public DoubleLinkedListNode getTail() {
    return tail;
  }

  public void setTail(DoubleLinkedListNode tail) {
    this.tail = tail;
  }

  /**
   * Creates a new Single Linked List with single node
   */
  public DoubleLinkedList(int value) {
    createFirstNode(value);
  }

  private void createFirstNode(int value) {
    // Create node
    DoubleLinkedListNode node = new DoubleLinkedListNode();
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

    DoubleLinkedListNode node = new DoubleLinkedListNode();
    node.setValue(value);

    node.setNextNode(head);
    head.setPrevNode(node);
    
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

    DoubleLinkedListNode node = new DoubleLinkedListNode();
    node.setValue(value);

    node.setPrevNode(tail);
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
    DoubleLinkedListNode tempNode = head;

    while (currentLocation < location - 1 && tempNode != tail) {
      tempNode = tempNode.getNextNode();
      currentLocation++;
    }

    if (tempNode == tail) {
      addNodeAtEnd(value);
      return;
    }

    DoubleLinkedListNode node = new DoubleLinkedListNode();
    node.setValue(value);

    node.setPrevNode(tempNode);
    node.setNextNode(tempNode.getNextNode());
    tempNode.setNextNode(node);
    node.getNextNode().setPrevNode(node);
  }

  /**
   * Returns the location of first node with given value. Returns 0 if not found
   */
  public int findNode(int value) {
    int location = 0;

    DoubleLinkedListNode temp = head;

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

    head.getNextNode().setPrevNode(null);
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

    tail = tail.getPrevNode();
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
    
    if(head == tail) {
      head = tail = null;
      return;
    }

    int currentLocation = 1;
    DoubleLinkedListNode temp = head;

    while (currentLocation < location - 1 && temp.getNextNode() != tail) {
      temp = temp.getNextNode();
      currentLocation++;
    }

    if (temp.getNextNode() == tail) {
      deleteNodeAtEnd();
      return;
    }

    temp.setNextNode(temp.getNextNode().getNextNode());
    temp.getNextNode().setPrevNode(temp);
  }

  public void print() {
    if (head == null) {
      System.out.println("Empty list");
      return;
    }

    DoubleLinkedListNode temp = head;
    DoubleLinkedListNode previous = null;

    while (temp != tail) {
      System.out.printf("%s %s %s %s ", 
        previous != null && temp.getPrevNode() == previous ? "<-" : "",
        temp.getValue(), 
        temp == head && temp == tail ? "HT" : temp == head ? "H" : temp == tail ? "T" : "",
          "->");
      previous = temp;
      temp = temp.getNextNode();
    }
    System.out.printf("%s %s %s %s ", 
      previous != null && temp.getPrevNode() == previous ? "<-" : "",
      temp.getValue(), 
      temp == head && temp == tail ? "HT" : temp == head ? "H" : temp == tail ? "T" : "",
        "->");
    if(temp.getNextNode() == head) {
      System.out.printf("C");
    }
    System.out.println();
  }

  public String toString() {
    if (head == null) {
      return "Empty list";
    }

    DoubleLinkedListNode temp = head;
    StringBuffer buffer = new StringBuffer();
    DoubleLinkedListNode previous = null;
    
    while (temp != tail) {
      buffer.append(previous != null && temp.getPrevNode() == previous ? "<-" : "")
            .append(temp.getValue())
            .append(temp == head && temp == tail ? "HT" : temp == head ? "H" : temp == tail ? "T" : "")
            .append("->");
      previous = temp;
      temp = temp.getNextNode();
    }
    buffer.append(temp.getValue())
          .append(temp == head && temp == tail ? "HT" : temp == head ? "H" : temp == tail ? "T" : "")
          .append(previous != null && temp.getPrevNode() == previous ? "<->" : "->");
    if(temp.getNextNode() == head) {
      buffer.append("C");
    }
    return buffer.toString();
  }
}
