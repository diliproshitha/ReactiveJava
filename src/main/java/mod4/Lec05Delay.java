package mod4;

import reactor.core.publisher.Flux;
import util.Util;

import java.time.Duration;

public class Lec05Delay {

  public static void main(String[] args) {

      Flux.range(1, 100)
              .log()
              .delayElements(Duration.ofSeconds(1))
              .subscribe(Util.subscriber());

      Util.sleepSeconds(60);
  }
}
