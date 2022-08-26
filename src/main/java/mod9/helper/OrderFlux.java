package mod9.helper;

import mod5.assignment.PurchaseOrder;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class OrderFlux {

    public static Flux<PurchaseOrder> orderFlux() {
        return Flux.interval(Duration.ofMillis(10))
                .map(i -> new PurchaseOrder());
    }
}
