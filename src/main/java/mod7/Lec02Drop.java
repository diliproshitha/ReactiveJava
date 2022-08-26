package mod7;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.util.concurrent.Queues;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Lec02Drop {

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "16");

        List<Object> list = new ArrayList<>();

        Flux.create(fluxSink -> {
                    for (int i = 0; i < 501; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed : " + i);
                        Util.sleepMillis(1);
                    }

                    fluxSink.complete();
                })
                .onBackpressureDrop(list::add)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMillis(20);
                })
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
        System.out.println(list);
    }
}
