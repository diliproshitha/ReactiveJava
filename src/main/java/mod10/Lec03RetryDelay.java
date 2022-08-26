package mod10;

import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;
import util.Util;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lec03RetryDelay {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {

        getInteger()
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(3)))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<Integer> getInteger() {
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscribed"))
                .doOnComplete(() -> System.out.println("--Completed"))
                .map(i -> i / 0)
                .doOnError(err -> System.out.println("Error : " + err));
    }
}
