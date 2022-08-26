package mod6;

import reactor.core.publisher.Flux;
import util.Util;

import java.time.Duration;

public class Lec07FluxInterval {

    public static void main(String[] args) {

        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(2);
    }
}
