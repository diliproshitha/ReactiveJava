package mod4;

import reactor.core.publisher.Flux;
import util.Util;

public class Lec03DoCallbacks {

    public static void main(String[] args) {


        Flux.create(fluxSink -> {
            System.out.println("Inside create");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }

            fluxSink.complete();
            System.out.println("Complete");
        })
                .doOnComplete(() -> System.out.println("do on complete"))
                .doFirst(() -> System.out.println("Do first"))
                .doOnNext(o -> System.out.println("Do next : " + o))
                .doOnSubscribe(s -> System.out.println("Do on subscribe " + s))
                .doOnRequest(value -> System.out.println("Do on request " + value))
                .doOnError(err -> System.out.println("Do on error " + err.getMessage()))
                .doOnTerminate(() -> System.out.println("Do on Terminate "))
                .doFinally(signalType -> System.out.println("Do Finally " + signalType))
                .doOnDiscard(Object.class, o -> System.out.println("Do on discard " + o))
                .take(2)
                .doFinally(signalType -> System.out.println("Do Finally 2 " + signalType))
                .subscribe(Util.subscriber());

    }
}
