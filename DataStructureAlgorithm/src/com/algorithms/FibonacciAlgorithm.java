package com.algorithms;

/**
 * This program implements algorithm for finding nth number in Fibonacci series using recursion.
 */
public class FibonacciAlgorithm {

  public static void main(String[] args) {
    FibonacciAlgorithm algorithm = new FibonacciAlgorithm();
    System.out.println("Number at position 0 - " + algorithm.fibonacciNumberAtRecursively(0));
    System.out.println("Number at position 0 - " + algorithm.fibonacciNumberAtUsingIteration(0));
    
    System.out.println("Number at position 1 - " + algorithm.fibonacciNumberAtRecursively(1));
    System.out.println("Number at position 1 - " + algorithm.fibonacciNumberAtUsingIteration(1));
    
    System.out.println("Number at position 2 - " + algorithm.fibonacciNumberAtRecursively(2));
    System.out.println("Number at position 2 - " + algorithm.fibonacciNumberAtUsingIteration(2));
    
    System.out.println("Number at position 5 - " + algorithm.fibonacciNumberAtRecursively(5));
    System.out.println("Number at position 5 - " + algorithm.fibonacciNumberAtUsingIteration(5));

    System.out.println("Number at position 10 - " + algorithm.fibonacciNumberAtRecursively(10));
    System.out.println("Number at position 10 - " + algorithm.fibonacciNumberAtUsingIteration(10));
    
    System.out.println("Number at position 15 - " + algorithm.fibonacciNumberAtRecursively(15));
    System.out.println("Number at position 15 - " + algorithm.fibonacciNumberAtUsingIteration(15));

  }

  private int fibonacciNumberAtRecursively(int position) {
    if (position == 0)
      return 0;
    if (position == 1)
      return 1;

    return fibonacciNumberAtRecursively(position - 1) + fibonacciNumberAtRecursively(position - 2);
  }

  private int fibonacciNumberAtUsingIteration(int position) {
    int prevFibonacciNumber = 0;
    int currentFibonacciNumber = 1;
    
    if(position == 0) return prevFibonacciNumber;
    if(position == 1) return currentFibonacciNumber;
    
    for(int pos = 2; pos <= position; pos++) {
      int tempCurrentFibonacciNumber = currentFibonacciNumber; 
      currentFibonacciNumber = currentFibonacciNumber + prevFibonacciNumber;
      prevFibonacciNumber = tempCurrentFibonacciNumber;
    }
    return currentFibonacciNumber;
  }

}
