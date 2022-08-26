package mod11;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import util.Util;

public class Lec01SinkOne {

  public static void main(String[] args) {


      // mono 1 value / empty / error
      Sinks.One<Object> sink = Sinks.one();
      Mono<Object> mono = sink.asMono();

    mono.subscribe(Util.subscriber("sam"));

    sink.tryEmitValue("hey");
  }
}
