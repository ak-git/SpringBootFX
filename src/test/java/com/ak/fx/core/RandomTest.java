package com.ak.fx.core;

import java.util.Random;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class RandomTest {
  @Test
  void test() {
    Random random = new Random();
    System.out.println(
        random.ints(1, 25 + 1).distinct().limit(2)
            .mapToObj("%d"::formatted).collect(Collectors.joining("\n"))
    );
  }
}