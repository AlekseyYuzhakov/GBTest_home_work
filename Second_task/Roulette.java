package GBTest_home_work.Second_task;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

public class Roulette {

  public int FindePrizeRoulette(PriorityQueue<Toy> queue) {
    Integer prizeIndex = 0;
    Integer maxWeight = 0;
    Integer tempWeight = 0;
    for (Toy toy : queue) {
      maxWeight += toy.getWeight();
    }
    Random r = new Random();
    Integer stopWeight = r.nextInt(maxWeight) + 1;
    for (Toy toy : queue) {
      tempWeight += toy.getWeight();
      if (stopWeight <= tempWeight) {
        prizeIndex = toy.getId();
      }
    }
    return prizeIndex;
  }

  public void playRoulette(PriorityQueue<Toy> queue) {
    try (FileWriter writer = new FileWriter("LogResults.txt", true)) {
      if (queue.peek() != null) {
        Integer prizeID = FindePrizeRoulette(queue);
        for (Toy toy : queue) {
          if (toy.getId() == prizeID) {
            System.out.println(toy.getInfo());
            writer.write(toy.getInfo() + " разыгран " + "\n");
            queue.remove(toy);
          }
        }
      } else {
        System.out.println("Системное сообщение: В очереди нет игрушек к розыгришу ");
      }
    } catch (IOException e) {
      System.out.println("Системное сообщение: Произошла ошибка записи в файл ");
      e.printStackTrace();
    }
  }

}
