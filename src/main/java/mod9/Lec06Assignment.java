package mod9;

import mod5.assignment.PurchaseOrder;
import mod9.helper.OrderFlux;
import mod9.helper.OrderProcessor;
import reactor.core.publisher.Flux;
import util.Util;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Lec06Assignment {

  public static void main(String[] args) {

      Map<String, Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>>> map = Map.of(
              "Kids", OrderProcessor.kidsProcessor(),
              "Automotive", OrderProcessor.automotiveProcessor()
      );

      Set<String> keySet = map.keySet();

      OrderFlux.orderFlux()
              .filter(p -> keySet.contains(p.getCategory()))
              .groupBy(PurchaseOrder::getCategory)
              .flatMap(gf -> map.get(gf.key()).apply(gf))
              .subscribe(Util.subscriber());

      Util.sleepSeconds(60);
  }
}
