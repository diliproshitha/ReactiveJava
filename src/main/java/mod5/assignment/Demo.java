package mod5.assignment;

import util.Util;

public class Demo {

  public static void main(String[] args) {

      OrderService orderService = new OrderService();
      RevenueService revenueService = new RevenueService();
      InventoryService inventoryService = new InventoryService();

      orderService.orderStream().subscribe(revenueService.subscribeOrderStream());
      orderService.orderStream().subscribe(inventoryService.subscribeInventoryStream());

      inventoryService.inventoryStream().subscribe(Util.subscriber("inventory"));
      revenueService.revenueStream().subscribe(Util.subscriber("revenue"));

      Util.sleepSeconds(60);
  }
}
