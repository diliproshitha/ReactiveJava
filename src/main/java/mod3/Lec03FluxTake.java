package mod3;

import reactor.core.publisher.Flux;
import util.Util;

public class Lec03FluxTake {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .take(3)
                .log()
                .subscribe(Util.subscriber());
    }
}
