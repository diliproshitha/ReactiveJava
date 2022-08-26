package mod10;

import reactor.core.publisher.Flux;
import util.Util;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec02Retry {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {

        getInteger()
                .retry(2)
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getInteger() {
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscribed"))
                .doOnComplete(() -> System.out.println("--Completed"))
                .map(i -> i / 0)
                .doOnError(err -> System.out.println("Error : " + err));
    }
}
