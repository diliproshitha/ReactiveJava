package mod8.helper;

import reactor.core.publisher.Flux;
import util.Util;

public class QuatarFlights {

    public static Flux<String> getFlights() {
        return Flux.range(1, Util.faker().random().nextInt(1, 5))
                .map(i -> "Qatar " + Util.faker().random().nextInt(100, 999))
                .filter(i -> Util.faker().random().nextBoolean());
    }
}
