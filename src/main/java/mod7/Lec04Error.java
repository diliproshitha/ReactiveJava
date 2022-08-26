package mod7;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import util.Util;

public class Lec04Error {

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "16");


        Flux.create(fluxSink -> {
                    for (int i = 0; i < 201 && !fluxSink.isCancelled(); i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed : " + i);
                        Util.sleepMillis(1);
                    }

                    fluxSink.complete();
                })
                .onBackpressureError()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMillis(20);
                })
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
