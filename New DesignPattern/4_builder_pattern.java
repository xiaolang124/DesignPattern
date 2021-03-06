//步骤 1
//创建一个表示食物条目和食物包装的接口。
//	Item.java
public interface Item {
   public String name();
   public Packing packing();
   public float price();	
}
//	Packing.java
public interface Packing {
   public String pack();
}
//步骤 2
//创建实现 Packing 接口的实体类。
//	Wrapper.java
public class Wrapper implements Packing {

   @Override
   public String pack() {
      return "Wrapper";
   }
}
//	Bottle.java
public class Bottle implements Packing {

   @Override
   public String pack() {
      return "Bottle";
   }
}
//步骤 3
//创建实现 Item 接口的抽象类，该类提供了默认的功能。
//	Burger.java
public abstract class Burger implements Item {

   @Override
   public Packing packing() {
      return new Wrapper();
   }

   @Override
   public abstract float price();
}
//	ColdDrink.java
public abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
       return new Bottle();
	}

	@Override
	public abstract float price();
}
//步骤 4
//创建扩展了 Burger 和 ColdDrink 的实体类。
//	VegBurger.java
public class VegBurger extends Burger {

   @Override
   public float price() {
      return 25.0f;
   }

   @Override
   public String name() {
      return "Veg Burger";
   }
}
//	ChickenBurger.java
public class ChickenBurger extends Burger {

   @Override
   public float price() {
      return 50.5f;
   }

   @Override
   public String name() {
      return "Chicken Burger";
   }
}
//	Coke.java
public class Coke extends ColdDrink {

   @Override
   public float price() {
      return 30.0f;
   }

   @Override
   public String name() {
      return "Coke";
   }
}
//	Pepsi.java
public class Pepsi extends ColdDrink {

   @Override
   public float price() {
      return 35.0f;
   }

   @Override
   public String name() {
      return "Pepsi";
   }
}
//步骤 5
//创建一个 Meal 类，带有上面定义的 Item 对象。
//	Meal.java
import java.util.ArrayList;
import java.util.List;

public class Meal {
   private List<Item> items = new ArrayList<Item>();	

   public void addItem(Item item){
      items.add(item);
   }

   public float getCost(){
      float cost = 0.0f;
      for (Item item : items) {
         cost += item.price();
      }		
      return cost;
   }

   public void showItems(){
      for (Item item : items) {
         System.out.print("Item : "+item.name());
         System.out.print(", Packing : "+item.packing().pack());
         System.out.println(", Price : "+item.price());
      }		
   }	
}
//步骤 6
//创建一个 MealBuilder 类，实际的 builder 类负责创建 Meal 对象。
//	MealBuilder.java
public class MealBuilder {

   public Meal prepareVegMeal (){
      Meal meal = new Meal();
      meal.addItem(new VegBurger());
      meal.addItem(new Coke());
      return meal;
   }   

   public Meal prepareNonVegMeal (){
      Meal meal = new Meal();
      meal.addItem(new ChickenBurger());
      meal.addItem(new Pepsi());
      return meal;
   }
}
//步骤 7
//BuiderPatternDemo 使用 MealBuider 来演示建造者模式（Builder Pattern）。
//	BuilderPatternDemo.java
public class BuilderPatternDemo {
   public static void main(String[] args) {
      MealBuilder mealBuilder = new MealBuilder();

      Meal vegMeal = mealBuilder.prepareVegMeal();
      System.out.println("Veg Meal");
      vegMeal.showItems();
      System.out.println("Total Cost: " +vegMeal.getCost());

      Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
      System.out.println("\n\nNon-Veg Meal");
      nonVegMeal.showItems();
      System.out.println("Total Cost: " +nonVegMeal.getCost());
   }
}
//步骤 8
//验证输出。
Veg Meal
Item : Veg Burger, Packing : Wrapper, Price : 25.0
Item : Coke, Packing : Bottle, Price : 30.0
Total Cost: 55.0


Non-Veg Meal
Item : Chicken Burger, Packing : Wrapper, Price : 50.5
Item : Pepsi, Packing : Bottle, Price : 35.0
Total Cost: 85.5