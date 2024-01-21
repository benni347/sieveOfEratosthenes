package ch.bbw.cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeSieve {
  public static List<Integer> findPrimes(int limit) {
    if (limit <= 0) {
      return new ArrayList<>();
    }

    List<Integer> list = new ArrayList<>();
    boolean[] isPrime = new boolean[limit + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;

    for (int i = 2; i <= Math.sqrt(limit); i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= limit; j += i) {
          isPrime[j] = false;
        }
      }
    }

    for (int i = 2; i <= limit; i++) {
      if (isPrime[i]) {
        list.add(i);
      }
    }

    return list;
  }
}
