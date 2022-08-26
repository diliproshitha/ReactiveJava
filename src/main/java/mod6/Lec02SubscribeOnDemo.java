package mod6;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import util.Util;

public class Lec02SubscribeOnDemo {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("Create");
                    ;
                    fluxSink.next(1);
                })
                .subscribeOn(Schedulers.newParallel("vins"))
                .doOnNext(i -> printThreadName("Next : " + i));

        Runnable runnable = () -> flux
                .doFirst(() -> printThreadName("first 2"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> printThreadName("first 1"))
                .subscribe(v -> printThreadName("Sub " + v));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }

        Util.sleepMillis(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t : Thread : " + Thread.currentThread().getName());
    }
}
