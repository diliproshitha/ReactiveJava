package mod2;

import reactor.core.publisher.Flux;
import util.Util;

public class Lec01FluxIntro {

    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5);

        flux.subscribe(Util.onNext());
    }
}
