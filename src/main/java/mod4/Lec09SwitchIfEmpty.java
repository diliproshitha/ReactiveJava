package mod4;

import reactor.core.publisher.Flux;
import util.Util;

import java.time.Duration;

public class Lec09SwitchIfEmpty {

    public static void main(String[] args) {
        //

        getOrderNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(fallback())
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10);
    }

    private static Flux<Integer> fallback() {
        return Flux.range(100, 10);
    }
}
