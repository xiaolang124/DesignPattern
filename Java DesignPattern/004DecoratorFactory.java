public abstract class Component{
    public abstract void Operation();
}

public class ConcreteComponent extends Component{
    @Override
    public void Operation(){
        //具体对象的操作
    }
}

public abstract class Decorator extends Component{
    protected Component component;

    public void SetComponent(Component component){
        this.component=component;
    }

    @Override
    public void Operation(){
        if(component!=null){
            component.Operation();
        }
    }
}

public class ConcreteDecoratorA extends Decorator{
    @Override
    public void Operation(){
        base.Operation();
        //具体装饰对象A的操作
    }

    //A独有的方法
}

public class ConcreteDecoratorB extends Decorator{
    @Override
    public void Operation(){
        base.Operation();
        //具体装饰对象B的操作
    }

    //B独有的方法
}

public static Main(String[] args){
    ConcreteComponent c=new ConcreteComponent();
    ConcreteDecoratorA d1=new ConcreteDecoratorA();
    ConcreteDecoratorB d2=new ConcreteDecoratorB();

    d1.SetComponent(c);
    d2.SetComponent(d1);
    d2.Operation();
    /*
    装饰的方法是：首先用ConcreteComponent实例化对象c，然后用ConcreteDecoratorA的
    实例化对象d1来包装c,再用ConcreteDecoratorB的对象d2包装d1，最终执行d2的Operation()
    */
}