package com.datastructure.linkedlist.circulardoubly;

public class CirculaDoubleLinkedList {

  private CircularDoubleLinkedListNode head = null;
  private CircularDoubleLinkedListNode tail = null;

  public CircularDoubleLinkedListNode getHead() {
    return head;
  }

  public void setHead(CircularDoubleLinkedListNode head) {
    this.head = head;
  }

  public CircularDoubleLinkedListNode getTail() {
    return tail;
  }

  public void setTail(CircularDoubleLinkedListNode tail) {
    this.tail = tail;
  }

  /**
   * Creates a new Single Linked List with single node
   */
  public CirculaDoubleLinkedList(int value) {
    createFirstNode(value);
  }

  private void createFirstNode(int value) {
    // Create node
    CircularDoubleLinkedListNode node = new CircularDoubleLinkedListNode();
    // Set value
    node.setValue(value);
    // Point head to the node
    head = node;
    // Point tail to the node
    tail = node;
    
    head.setNextNode(tail);
    tail.setPrevNode(head);
  }

  /**
   * Add a new node at the beginning
   */
  public void addNodeAtStart(int value) {
    if (head == null) {
      createFirstNode(value);
      return;
    }

    CircularDoubleLinkedListNode node = new CircularDoubleLinkedListNode();
    node.setValue(value);

    node.setNextNode(head);
    head.setPrevNode(node);
    
    head = node;
    
    head.setPrevNode(tail);
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

    CircularDoubleLinkedListNode node = new CircularDoubleLinkedListNode();
    node.setValue(value);

    tail.setNextNode(node);
    node.setPrevNode(tail);
    
    tail = node;
    head.setPrevNode(tail);
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
    CircularDoubleLinkedListNode tempNode = head;

    while (currentLocation < location - 1 && tempNode != tail) {
      tempNode = tempNode.getNextNode();
      currentLocation++;
    }

    if (tempNode == tail) {
      addNodeAtEnd(value);
      return;
    }

    CircularDoubleLinkedListNode node = new CircularDoubleLinkedListNode();
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

    CircularDoubleLinkedListNode temp = head;

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
      head.setNextNode(null);
      head = tail = null;
      return;
    }

    head = head.getNextNode();
    head.setPrevNode(tail);
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
      head.setNextNode(null);
      head = tail = null;
      return;
    }

    tail = tail.getPrevNode();
    tail.setNextNode(head);
    head.setPrevNode(tail);
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
      head.setNextNode(null);
      head = tail = null;
      return;
    }

    int currentLocation = 1;
    CircularDoubleLinkedListNode temp = head;

    while (currentLocation < location - 1 && temp.getNextNode() != tail) {
      temp = temp.getNextNode();
      currentLocation++;
    }

    if (temp.getNextNode() == tail) {
      deleteNodeAtEnd();
      return;
    }
    
    CircularDoubleLinkedListNode nodeToDelete = temp.getNextNode();
    CircularDoubleLinkedListNode prevNode = nodeToDelete.getPrevNode();
    CircularDoubleLinkedListNode nextNode = nodeToDelete.getNextNode();
    
    prevNode.setNextNode(nextNode);
    nextNode.setPrevNode(prevNode);
  }

  public void print() {
    if (head == null) {
      System.out.println("Empty list");
      return;
    }

    CircularDoubleLinkedListNode temp = head;
    CircularDoubleLinkedListNode previous = null;

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

    CircularDoubleLinkedListNode temp = head;
    StringBuffer buffer = new StringBuffer();
    CircularDoubleLinkedListNode previous = null;
    
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
