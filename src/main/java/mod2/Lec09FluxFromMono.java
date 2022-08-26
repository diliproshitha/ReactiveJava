package mod2;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import util.Util;

public class Lec09FluxFromMono {

    public static void main(String[] args) {

        Mono<String> a = Mono.just("a");
        Flux.from(a)
                .subscribe(Util.onNext());

        Flux.range(0, 10)
                .next()
                .subscribe(Util.onNext());

    }

    private static void doSomething(Flux<String> flux) {

    }
}
