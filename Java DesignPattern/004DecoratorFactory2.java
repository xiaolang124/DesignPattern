public abstract class Person{
    public Person(){

    }

    private String name;

    public Person(String name){
        this.name=name;
    }

    public abstract void show();
}

public class Finery extends Person{
    protected Person component;

    //打扮
    public void Decorate(Person component){
        this.component=component;
    } 

    @Override
    public void show(){
        if(component!=null){
            component.show();
        }
    }
}

public class TShirts extends Finery{
    @Override
    public void show(){
        System.out.println("大T恤");
        super.show();
    }
}

public class BigTrouser extends Finery{
    @Override
    public void show(){
        System.out.println("垮裤");
        super.show();
    }
}

...

static void Main(String[] args){
    Person xc=new Person("xc") {
			
			@Override
			public void show() {
				System.out.println("xc准备装扮");
			}
		};
    Sneakers pqx=new Sneakers();
    BigTrouser kk=new BigTrouser();
    TShirts dtx=new TShirts();

    pqx.Decorate(xc);
    kk.Decorate(pqx);
    dtx.Decorate(kk);
    dtx.show();
}
