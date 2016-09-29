public interface Strategy {
    public void AlgorithmInterface();
}

public class ConcreteStrategyA implements Strategy{

    @Override
    public void AlgorithmInterface() {
        System.out.println("Strategy A");
    }
}

public class ConcreteStrategyB implements Strategy{

    @Override
    public void AlgorithmInterface() {
        System.out.println("Strategy B");
    }
}

public class ConcreteStrategyC implements Strategy{

    @Override
    public void AlgorithmInterface() {
        System.out.println("Strategy C");
    }
}

public class Context{
    Strategy Strategy;

    public Context(Strategy strategy){
        this.strategy=strategy;
    }
    
    public void ContextInterface(){
        strategy.AlgorithmInterface();
    }
}

public class Main {

    public static void main(String[] args) {
        Context context;
        context=new Context(new ConcreteStrategyA());
        context.ContextInterface();

        context=new Context(new ConcreteStrategyB());
        context.ContextInterface();

        context=new Context(new ConcreteStrategyC());
        context.ContextInterface();
    }
}