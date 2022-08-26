package mod6;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import util.Util;

public class Lec05PubSubOn {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("Create");

                    for (int i = 0; i < 4; i++) {
                        fluxSink.next(i);
                    }

                    fluxSink.complete();
                })
                .doOnNext(i -> printThreadName("Next : " + i));

        flux
                .publishOn(Schedulers.parallel())
                .doOnNext(i -> printThreadName("Next : " + i))
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(v -> printThreadName("Sub " + v));

        Util.sleepSeconds(20);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t : Thread : " + Thread.currentThread().getName());
    }
}
