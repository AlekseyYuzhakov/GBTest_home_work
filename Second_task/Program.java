package GBTest_home_work.Second_task;

import java.util.PriorityQueue;

public class Program {
  Presenter p = new Presenter();
  View v = new View();
  Roulette r = new Roulette();
  PriorityQueue<Toy> q = new PriorityQueue<Toy>((t1, t2) -> t2.getWeight() - t1.getWeight());

  public void starApp() {
    boolean flag = true;
    while (flag) {
      v.printMenu();
      String choice = "";
      try {
        choice = p.getUserInput("Введите номер опции меню ");
      } catch (NullPointerException e) {
      }
      if (p.isNumber(choice)) {
        if (Integer.parseInt(choice) == 1) {
          try {
            Toy tempToy = p.createToy();
            q.add(tempToy);
          } catch (Exception e) {
          }
          System.out.println(q);
        }
        if (Integer.parseInt(choice) == 2) {
          try {
            q = p.fillQueWithRandomToys(q);
          } catch (RuntimeException e) {
            System.out.println("");
          }
        }
        if (Integer.parseInt(choice) == 3) {
          r.playRoulette(q);
        }
        if (Integer.parseInt(choice) == 4) {
          flag = false;
        }
      } else {
        System.out.println("Системное сообщение: Введено не число ");
      }
    }
  }
}
