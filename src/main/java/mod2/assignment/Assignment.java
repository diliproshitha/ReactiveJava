package mod2.assignment;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import util.Util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Assignment {

    public static void main(String[] args) throws InterruptedException {


        CountDownLatch latch = new CountDownLatch(1);

        StockPricePublisher.getPrice().subscribeWith(new Subscriber<Integer>() {

            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer price) {
                System.out.println(LocalDateTime.now() + " : Price : " + price);

                if (price > 110 || price < 90) {
                    this.subscription.cancel();
                    latch.countDown();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                latch.countDown();
            }

            @Override
            public void onComplete() {
                latch.countDown();
            }
        });

        latch.await();
    }
}
