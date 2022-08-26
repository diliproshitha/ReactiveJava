package mod9.helper;

import mod5.assignment.PurchaseOrder;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class OrderProcessor {

    public static Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>> automotiveProcessor() {
        return flux -> flux
                .doOnNext(p -> p.setPrice(p.getPrice() * 1.1))
                .doOnNext(p -> p.setItem("{{ " + p.getItem() + " }}"));
    }

    public static Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>> kidsProcessor() {
        return flux -> flux
                .doOnNext(p -> p.setPrice(p.getPrice() * 0.5))
                .flatMap(p -> Flux.just(p, getFreeKidsOrder()));
    }

    private static PurchaseOrder getFreeKidsOrder() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setItem("Free product");
        purchaseOrder.setPrice(0);
        purchaseOrder.setCategory("Kids");
        return purchaseOrder;
    }
}
