package mod2;

import reactor.core.publisher.Flux;
import util.Util;

public class Lec05FromRange {

    public static void main(String[] args) {

        Flux<Integer> range = Flux.range(1, 10);

        range
                .log()
                .map(i -> Util.faker().name().fullName())
                .subscribe(Util.onNext());
    }
}
