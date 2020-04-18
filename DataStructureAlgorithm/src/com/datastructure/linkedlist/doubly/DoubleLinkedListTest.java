package com.datastructure.linkedlist.doubly;

public class DoubleLinkedListTest {
  public static void main(String[] args) {
    testFind(3);
  }
  
  public static void testAddAtBeginning() {
    DoubleLinkedList linkedList = oneNodeList();
    linkedList.print();
    System.out.println("Adding 5 at the begining");
    linkedList.addNodeAtStart(5);
    linkedList.print();

    linkedList = twoNodeList();
    linkedList.print();
    System.out.println("Adding 5 at the begining");
    linkedList.addNodeAtStart(5);
    linkedList.print();

    linkedList = threeNodeList();
    linkedList.print();
    System.out.println("Adding 5 at the begining");
    linkedList.addNodeAtStart(5);
    linkedList.print();
  }

  public static void testAddAtEnd() {
    DoubleLinkedList linkedList = oneNodeList();
    linkedList.print();
    System.out.println("Adding 5 at the end");
    linkedList.addNodeAtEnd(5);
    linkedList.print();

    linkedList = twoNodeList();
    linkedList.print();
    System.out.println("Adding 5 at the end");
    linkedList.addNodeAtEnd(5);
    linkedList.print();

    linkedList = threeNodeList();
    linkedList.print();
    System.out.println("Adding 5 at the end");
    linkedList.addNodeAtEnd(5);
    linkedList.print();
  }
  
  public static void testAddAtLocation(int nodes) {
    DoubleLinkedList linkedList = createList(nodes);
    linkedList.print();
    System.out.println("Adding 5 at location 1");
    linkedList.addNodeAtLocation(5, 1);
    linkedList.print();

    linkedList = createList(nodes);
    linkedList.print();
    System.out.println("Adding 5 at location 2");
    linkedList.addNodeAtLocation(5, 2);
    linkedList.print();

    linkedList = createList(nodes);
    linkedList.print();
    System.out.println("Adding 5 at location 3");
    linkedList.addNodeAtLocation(5, 3);
    linkedList.print();

    linkedList = createList(nodes);
    linkedList.print();
    System.out.println("Adding 5 at location 4");
    linkedList.addNodeAtLocation(5, 4);
    linkedList.print();
  }
  
  public static void testDeleteAtStart() {
    DoubleLinkedList linkedList = oneNodeList();
    linkedList.print();
    System.out.println("Deleting node at the start");
    linkedList.deleteNodeAtStart();
    linkedList.print();

    linkedList = twoNodeList();
    linkedList.print();
    System.out.println("Deleting node at the start");
    linkedList.deleteNodeAtStart();
    linkedList.print();

    linkedList = threeNodeList();
    linkedList.print();
    System.out.println("Deleting node at the start");
    linkedList.deleteNodeAtStart();
    linkedList.print();
  }

  public static void testDeleteNodeAtEnd() {
    DoubleLinkedList linkedList = oneNodeList();
    linkedList.print();
    System.out.println("Deleting node at the end");
    linkedList.deleteNodeAtEnd();
    linkedList.print();

    linkedList = twoNodeList();
    linkedList.print();
    System.out.println("Deleting node at the end");
    linkedList.deleteNodeAtEnd();
    linkedList.print();

    linkedList = threeNodeList();
    linkedList.print();
    System.out.println("Deleting node at the end");
    linkedList.deleteNodeAtEnd();
    linkedList.print();
  }

  public static void testDeleteAtLocation(int nodes) {
    DoubleLinkedList linkedList = createList(nodes);
    linkedList.print();
    System.out.println("Deleting node at location 1");
    linkedList.deleteNodeAtLocation(1);
    linkedList.print();

    linkedList = createList(nodes);
    linkedList.print();
    System.out.println("Deleting node at location 2");
    linkedList.deleteNodeAtLocation(2);
    linkedList.print();

    linkedList = createList(nodes);
    linkedList.print();
    System.out.println("Deleting node at location 3");
    linkedList.deleteNodeAtLocation(3);
    linkedList.print();

    linkedList = createList(nodes);
    linkedList.print();
    System.out.println("Deleting node at location 4");
    linkedList.deleteNodeAtLocation(4);
    linkedList.print();
  }
  
  public static void testFind(int nodes) {
    DoubleLinkedList linkedList = createList(nodes);
    linkedList.print();
    System.out.println("Finding 10");
    int location = linkedList.findNode(10);
    System.out.println(location != 0 ? ("Found at location " + location) : "Not Found");

    linkedList = createList(nodes);
    System.out.println("Finding 20");
    location = linkedList.findNode(20);
    System.out.println(location != 0 ? ("Found at location " + location) : "Not Found");

    linkedList = createList(nodes);
    System.out.println("Finding 30");
    location = linkedList.findNode(30);
    System.out.println(location != 0 ? ("Found at location " + location) : "Not Found");

    linkedList = createList(nodes);
    System.out.println("Finding 40");
    location = linkedList.findNode(40);
    System.out.println(location != 0 ? ("Found at location " + location) : "Not Found");
}
  
  private static DoubleLinkedList createList(int nodes) {
    switch (nodes) {
      case 1:
        return oneNodeList();
      case 2:
        return twoNodeList();
      case 3:
        return threeNodeList();
      default:
        return threeNodeList();
    }      
  }

  private static DoubleLinkedList oneNodeList() {
    return new DoubleLinkedList(10);
  }

  private static DoubleLinkedList twoNodeList() {
    DoubleLinkedList linkedList = new DoubleLinkedList(10);
    linkedList.addNodeAtEnd(20);
    return linkedList;
  }

  private static DoubleLinkedList threeNodeList() {
    DoubleLinkedList linkedList = new DoubleLinkedList(10);
    linkedList.addNodeAtEnd(20);
    linkedList.addNodeAtEnd(30);
    return linkedList;
  }

}
