package mod7;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import util.Util;

public class Lec01Demo {

    public static void main(String[] args) {


        Flux.create(fluxSink -> {
            for (int i = 0; i < 501; i++) {
                fluxSink.next(i);
                System.out.println("Pushed : " + i);
            }

            fluxSink.complete();
        })
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMillis(20);
                })
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
