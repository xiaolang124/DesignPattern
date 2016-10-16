public interface TemplateMethod{
    public void primitiveOperation1();
    public void primitiveOperation2();

    public void method();
}

public class ConcreteClass1 implements TemplateMethod{
    public void primitiveOperation1(){
        //具体实现方法1
    }

    public void primitiveOperation2(){
        //具体实现方法2
    }

    public void method(){
        primitiveOperation1();
        primitiveOperation2();
    }
}

public class ConcreteClass2 implements TemplateMethod{
    public void primitiveOperation1(){
        //具体实现方法1
    }

    public void primitiveOperation2(){
        //具体实现方法2
    }

    public void method(){
        primitiveOperation1();
        primitiveOperation2();
    }
}

static void Main(String[] args){
    TemplateMethod c;

    c=new ConcreteClass1();
    c.method();

    c=new ConcreteClass2();
    c.method();
}