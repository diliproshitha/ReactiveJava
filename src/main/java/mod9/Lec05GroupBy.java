package mod9;

import reactor.core.publisher.Flux;
import util.Util;

import java.time.Duration;

public class Lec05GroupBy {

  public static void main(String[] args) {
    Flux.range(1, 30)
            .delayElements(Duration.ofSeconds(1))
            .groupBy(i -> i % 2)
            .subscribe(gf -> process(gf, gf.key()));

    Util.sleepSeconds(60);
  }

  private static void process(Flux<Integer> flux, Integer key) {

    flux.subscribe(i -> System.out.println("Key : " + key + ", Item: " + i));
  }
}
