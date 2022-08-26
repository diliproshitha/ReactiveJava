package mod9;

import reactor.core.publisher.Flux;
import util.Util;

import java.time.Duration;

public class Lec01Buffer {

  public static void main(String[] args) {
    eventStream()
            .bufferTimeout(5, Duration.ofSeconds(2))
            .subscribe(Util.subscriber());

    Util.sleepSeconds(60);
  }

  private static Flux<String> eventStream() {
    return Flux.interval(Duration.ofMillis(10))
            .map(i -> "event " + i);
  }
}
