package mod9;

import reactor.core.publisher.Flux;
import util.Util;

import java.time.Duration;

public class Lec02OverlapAndDrop {

    public static void main(String[] args) {
        eventStream()
                .buffer(3, 1)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> "event " + i);
    }
}
