package mod4;

import mod4.helper.OrderService;
import mod4.helper.UserService;
import util.Util;

public class Lec12FlatMap {

  public static void main(String[] args) {

      UserService.getUsers()
              .flatMap(user -> OrderService.getOrders(user.getUserId()))
              .subscribe(Util.subscriber());
  }
}
