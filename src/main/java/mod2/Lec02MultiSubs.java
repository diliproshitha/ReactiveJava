package mod2;

import reactor.core.publisher.Flux;
import util.Util;

public class Lec02MultiSubs {

    public static void main(String[] args) {

        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);

        Flux<Integer> evenFlux = integerFlux.filter(i -> i % 2 == 0);

        integerFlux.subscribe(Util.onNext());
        evenFlux.subscribe(Util.onNext());
    }
}
