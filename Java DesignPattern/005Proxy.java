public interface GiveGift{
    public void GiveDolls();
    public void GiveFlowers();
    public void GiveChocolate();
}

public class Pursuit implements GiveGift{
    SchoolGirl mm;

    public Pursuit(){
        //此构造函数不可少，否则Proxy的构造函数报错
    }

    public Pursuit(SchoolGirl mm){
        this.mm=mm;
    }

    public void GiveDolls(){
        System.out.println(mm.name+" get dolls");
    }

    public void GiveFlowers(){

    }

    public void GiveChocolate(){

    }
}

public Proxy extends Pursuit{
    Pursuit gg;

    public Proxy(SchoolGirl mm){
        gg=new Pursuit(mm);
    }

    public void GiveDolls(){
        gg.GiveDolls();
    }

    public void GiveFlowers(){
        gg.GiveFlowers();
    }

    public void GiveChocolate(){
        gg.GiveChocolate();
    }
}

static void Main(string[] args){
    SchoolGirl mm=new SchoolGirl();
    mm.name="mm";

    Proxy daili=new Proxy(mm);

    daili.GiveDolls();
    daili.GiveFlowers();
    daili.GiveChocolate();


}