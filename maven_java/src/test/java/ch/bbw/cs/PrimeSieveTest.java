package ch.bbw.cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimeSieveTest {

  @Test
  public void testPrimeSieve1() {
    System.out.println("PrimeSieveTest.testPrimeSieve1");
    int limit = 1;
    List<Integer> primes = PrimeSieve.findPrimes(limit);

    Assertions.assertTrue(primes.isEmpty());
  }

  @Test
  public void testPrimeSieve2() {
    System.out.println("PrimeSieveTest.testPrimeSieve2");
    int limit = 2;
    List<Integer> primes = PrimeSieve.findPrimes(limit);
    List<Integer> validPrimes = new ArrayList<>();
    validPrimes.add(2);

    Assertions.assertFalse(primes.isEmpty());
    Assertions.assertEquals(primes, validPrimes);
  }

  @Test
  public void testPrimeSieveWithZero() {
    System.out.println("PrimeSieveTest.testPrimeSieveWithZero");
    int limit = 0;
    List<Integer> primes = PrimeSieve.findPrimes(limit);

    Assertions.assertTrue(primes.isEmpty());
  }

  @Test
  public void testPrimeSieveWithNegative() {
    System.out.println("PrimeSieveTest.testPrimeSieveWithNegative");
    int limit = -5;
    List<Integer> primes = PrimeSieve.findPrimes(limit);

    Assertions.assertTrue(primes.isEmpty());
  }

  @Test
  public void testPrimeSieveWithLargeNumber() {
    System.out.println("PrimeSieveTest.testPrimeSieveWithLargeNumber");
    int limit = 100;
    List<Integer> primes = PrimeSieve.findPrimes(limit);

    // Test some known primes in this range
    List<Integer> knownPrimes = Arrays.asList(
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
        89, 97);
    Assertions.assertTrue(primes.containsAll(knownPrimes));
    Assertions.assertEquals(knownPrimes.size(), primes.size());
  }

  @Test
  public void testPrimeSieveForKnownRange() {
    System.out.println("PrimeSieveTest.testPrimeSieveForKnownRange");
    int limit = 10;
    List<Integer> primes = PrimeSieve.findPrimes(limit);
    List<Integer> validPrimes = Arrays.asList(2, 3, 5, 7);

    Assertions.assertEquals(validPrimes, primes);
  }

  @Test
  public void testPrimeSieveForNoPrimes() {
    System.out.println("PrimeSieveTest.testPrimeSieveForNoPrimes");
    int limit = 24;
    List<Integer> primes = PrimeSieve.findPrimes(limit);
    int higherLimit = 28;
    List<Integer> primesInHigherRange = PrimeSieve.findPrimes(higherLimit);

    Assertions.assertEquals(primes, primesInHigherRange);
  }
}
