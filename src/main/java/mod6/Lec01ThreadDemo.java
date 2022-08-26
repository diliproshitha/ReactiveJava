package mod6;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import util.Util;

public class Lec01ThreadDemo {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("Create");
                    ;
                    fluxSink.next(1);
                })
                .doOnNext(i -> printThreadName("Next : " + i));

        Runnable runnable = () -> flux.subscribe(v -> printThreadName("sub " + v));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }

        Util.sleepMillis(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t : Thread : " + Thread.currentThread().getName());
    }
}
