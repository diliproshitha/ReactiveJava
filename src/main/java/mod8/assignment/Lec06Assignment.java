package mod8.assignment;

import reactor.core.publisher.Flux;
import util.Util;

import java.time.Duration;

public class Lec06Assignment {


    public static void main(String[] args) {

        final int carPrice = 10000;
        Flux.combineLatest(getMonthStream(), getDemandStream(), (month, demand) -> (carPrice - (month * 100)) * demand)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }

    private static Flux<Long> getMonthStream() {
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(1));
    }

    private static Flux<Double> getDemandStream() {
        return Flux.interval(Duration.ofSeconds(3))
                .map(i -> Util.faker().random().nextInt(80, 120) / 100d)
                .startWith(1d);
    }
}
