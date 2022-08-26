package mod4;

import reactor.core.publisher.Flux;
import util.Util;

public class Lec04LimitRate {

  public static void main(String[] args) {

      Flux.range(1, 1000)
              .log()
              .limitRate(100)
              .subscribe(Util.subscriber());
  }
}
