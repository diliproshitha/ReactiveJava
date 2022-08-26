package mod2;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import util.Util;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {

    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();

        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Recieved sub: " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError: " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });

        Util.sleepSeconds(3);
        atomicReference.get().request(3);
        Util.sleepSeconds(3);
        atomicReference.get().request(3);
        Util.sleepSeconds(3);
        atomicReference.get().request(3);
        System.out.println("Going to cancel");
        atomicReference.get().cancel();
        Util.sleepSeconds(3);
        atomicReference.get().request(3);
        Util.sleepSeconds(3);

    }
}
