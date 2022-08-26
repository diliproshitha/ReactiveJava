package mod6;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import util.Util;

public class Lec06Parallel {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .parallel()
                .runOn(Schedulers.boundedElastic())
                .doOnNext(i -> printThreadName("Next : " + i))
                .subscribe(v -> printThreadName("Sub " + v));

        Util.sleepSeconds(20);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t : Thread : " + Thread.currentThread().getName());
    }
}
