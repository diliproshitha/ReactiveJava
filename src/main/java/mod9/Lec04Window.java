package mod9;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import util.Util;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lec04Window {

  private static AtomicInteger atomicInteger = new AtomicInteger(1);

  public static void main(String[] args) {
    eventStream()
            .window(Duration.ofSeconds(2))
            .flatMap(Lec04Window::saveEvents)
            .subscribe(Util.subscriber());

    Util.sleepSeconds(60);
  }

  private static Flux<String> eventStream() {
    return Flux.interval(Duration.ofMillis(500))
            .map(i -> "event " + i);
  }

  private static Mono<Integer> saveEvents(Flux<String> flux) {
    return flux
            .doOnNext(e -> System.out.println("Saving " + e))
            .doOnComplete(() -> {
              System.out.println("saved this batch");
              System.out.println("-----------------");
            })
            .then(Mono.just(atomicInteger.getAndIncrement()));
  }
}
