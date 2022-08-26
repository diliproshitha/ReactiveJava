package mod8;

import reactor.core.publisher.Flux;
import util.Util;

public class lec02Concat {

    public static void main(String[] args) {


        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.just("c", "d", "e");
        Flux<String> oops = Flux.error(new RuntimeException("oops"));

        Flux<String> stringFlux = Flux.concatDelayError(flux1, oops, flux2);

        stringFlux.subscribe(Util.subscriber());

    }
}
