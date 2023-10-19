package GBTest_home_work.Second_task;

/*
 * Класс позволяющий создавать экземляры игрушек
 */
public class Toy {
  private Integer id;
  private String name;
  private Integer weight;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public Toy(Integer id, String name, Integer weight) {
    this.id = id;
    this.name = name;
    this.weight = weight;
  }

  public String getInfo() {
    return " Игрушка с id: " + id + " названием: " + name + " с частотой выпадения: " + weight;
  }

}
