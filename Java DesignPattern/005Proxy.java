public interface GiveGift{
    public void giveDolls();
    public void giveFlowers();
    public void giveChocolate();
}

public class Pursuit implements GiveGift{
    SchoolGirl mm;

    public Pursuit(){
        //此构造函数不可少，否则Proxy的构造函数报错
    }

    public Pursuit(SchoolGirl mm){
        this.mm=mm;
    }

    public void giveDolls(){
        System.out.println(mm.name+" get dolls");
    }

    public void giveFlowers(){

    }

    public void giveChocolate(){

    }
}

public Proxy extends Pursuit{
    Pursuit gg;

    public Proxy(SchoolGirl mm){
        gg=new Pursuit(mm);
    }

    public void giveDolls(){
        gg.giveDolls();
    }

    public void giveFlowers(){
        gg.giveFlowers();
    }

    public void giveChocolate(){
        gg.giveChocolate();
    }
}

static void Main(string[] args){
    SchoolGirl mm=new SchoolGirl();
    mm.name="mm";

    Proxy daili=new Proxy(mm);

    daili.giveDolls();
    daili.giveFlowers();
    daili.giveChocolate();

}