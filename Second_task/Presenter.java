package GBTest_home_work.Second_task;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

import cw_02_toy_store_java.exceptions.WrongSimbolInput;

public class Presenter {
  Scanner s = new Scanner(System.in, "Cp866");

  public Toy createToy() throws Exception {
    String tempInput = getUserInput("Введите ID игрушки с помощью цифр ");
    Integer tempId = 0;
    if (isNumber(tempInput)) {
      tempId = Integer.parseInt(tempInput);
    } else {
      System.out.println("Системное сообщение: В качестве ID можно предавать только числа ");
      throw new RuntimeException("Системное сообщение: Не корректный ввод данных ");
    }
    String tempName = "";
    tempInput = getUserInput("Введите название игрушки ");
    if (!tempInput.isEmpty()) {
      tempName = tempInput;
    } else {
      System.out.println("Системное сообщение: Название игрушки не может быть пустым ");
      throw new NullPointerException("Системное сообщение: Не корректный ввод данных ");
    }
    Integer tempWeight = 0;
    tempInput = getUserInput("Введите шанс выпадение игрушки в % от 1-99 ");
    if (isNumber(tempInput)) {
      if (Integer.parseInt(tempInput) > 0 & Integer.parseInt(tempInput) < 100) {
        tempWeight = Integer.parseInt(tempInput);
      } else {
        System.out.println("Системное сообщение: Шанс выпадения должен быть от 1 до 99");
        throw new RuntimeException("Системное сообщение: Не корректный ввод данных ");
      }
    } else {
      System.out.println("Системное сообщение: В качестве ID можно предавать только числа ");
      throw new RuntimeException("Системное сообщение: Не корректный ввод данных ");
    }
    Toy t = new Toy(tempId, tempName, tempWeight);
    System.out.println(t.getInfo());
    return t;
  }

  public PriorityQueue<Toy> fillQueWithRandomToys(PriorityQueue<Toy> queue) throws RuntimeException {
    ArrayList<String> arr = new ArrayList<String>();
    boolean flag = true;
    System.out.println("Введите набор имен требуемых игрушек ");
    String tempStr = "";
    while (flag) {
      try {
        tempStr = getUserInput("Введите навзвание игрушки ");
        arr.add(tempStr);
      } catch (NullPointerException e) {
        flag = false;
      }
    }
    try {
      tempStr = getUserInput("Введите количество сколько требуется создать игрушек ");
      if (!isNumber(tempStr)) {
        throw new WrongSimbolInput();
      }
    } catch (NullPointerException e) {
      flag = false;
    }
    Random r = new Random();
    Integer wall = Integer.parseInt(tempStr);
    Integer step = 1;
    while (step < wall) {
      Toy tempToy = new Toy(step, arr.get(r.nextInt(arr.size() - 1)), r.nextInt(99));
      queue.add(tempToy);
      step += 1;
    }
    return queue;
  }

  public String getUserInput(String msg) throws NullPointerException {
    System.out.printf("%s", msg);
    String str = s.nextLine();
    if (str.isEmpty()) {
      System.out.println("Системное сообщение: Вы ничего не ввели ((");
      throw new NullPointerException();
    }
    return str;
  }

  public boolean isNumber(String str) {
    String string = "0123456789";
    if (str.isEmpty()) {
      return false;
    }
    for (char elem : str.toCharArray()) {
      if (!string.contains(String.valueOf(elem))) {
        return false;
      }
    }
    return true;
  }

}
