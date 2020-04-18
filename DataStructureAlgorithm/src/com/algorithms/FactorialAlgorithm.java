package com.algorithms;

/**
 * This program implements algorithm for finding the factorial of given number using recursion.
 */
public class FactorialAlgorithm {

  public static void main(String[] args) {
    FactorialAlgorithm algorithm = new FactorialAlgorithm();
    System.out.println("Factorial of 0 = " + algorithm.calculateFactorialRecursively(0));
    System.out.println("Factorial of 0 = " + algorithm.calculateFactorialWithIteration(0));
    
    System.out.println("Factorial of 1 = " + algorithm.calculateFactorialRecursively(1));
    System.out.println("Factorial of 1 = " + algorithm.calculateFactorialWithIteration(1));
    
    System.out.println("Factorial of 5 = " + algorithm.calculateFactorialRecursively(5));
    System.out.println("Factorial of 5 = " + algorithm.calculateFactorialWithIteration(5));
    
    System.out.println("Factorial of 7 = " + algorithm.calculateFactorialRecursively(7));
    System.out.println("Factorial of 7 = " + algorithm.calculateFactorialWithIteration(7));
    
    System.out.println("Factorial of 10 = " + algorithm.calculateFactorialRecursively(10));
    System.out.println("Factorial of 10 = " + algorithm.calculateFactorialWithIteration(10));
    
    System.out.println("Factorial of 20 = " + algorithm.calculateFactorialRecursively(20));
    System.out.println("Factorial of 20 = " + algorithm.calculateFactorialWithIteration(20));
  }

  private long calculateFactorialRecursively(long number) {
    if (number <= 0)
      return 1;
    if (number == 1)
      return 1;
    return number * calculateFactorialRecursively(number - 1);
  }

  private long calculateFactorialWithIteration(long number) {
    long factorial = 1;

    for (int num = 1; num <= number; num++) {
      factorial *= num;
    }
    
    return factorial;
  }

}
