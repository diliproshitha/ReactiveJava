package mod6;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import util.Util;

public class Lec03SubscribeOnMultipleItems {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("Create");


                    for (int i = 0; i < 20; i++) {
                        fluxSink.next(i);
                        Util.sleepSeconds(1);
                    }

                    fluxSink.complete();
                })
                .doOnNext(i -> printThreadName("Next : " + i));

        flux
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(v -> printThreadName("Sub " + v));

        flux
                .subscribeOn(Schedulers.parallel())
                .subscribe(v -> printThreadName("Sub " + v));

        Util.sleepSeconds(20);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t : Thread : " + Thread.currentThread().getName());
    }
}
