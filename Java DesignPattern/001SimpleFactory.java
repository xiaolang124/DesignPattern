public abstract class Operation{
    private double _numberA=0;
    private double _numberB=0;

    public double get_numberA(){
        return _numberA;
    }

    public void set_numberA(double _numberA){
        this._numberA=_numberA;
    }

    public double get_numberB(){
        return _numberB;
    }

    public void set_numberB(double _numberB){
        this._numberB=_numberB;
    }

    public abstract double getResult();
}

public class OperationAdd extends Operation{
    @Override
    public double getResult(){
        double result=0;
        result=get_numberA()+get_numberB();
        return result;
    }
}

public class OperationSub extends Operation{
    @Override
    public double getResult(){
        double result=0;
        result=get_numberA()-get_numberB();
        return result;
    }
}

public class OperationMul extends Operation{
    @Override
    public double getResult(){
        double result=0;
        result=get_numberA()*get_numberB();
        return result;
    }
}

public class OperationDiv extends Operation{
    @Override
    public double getResult(){
        double result=0;
        result=get_numberA()/get_numberB();
        return result;
    }
}

//简单工厂模式
public class OperationFactory{
    public static Operation creationOperation(String type){
        Operation oper=null;
        switch(type){
            case "+":
            oper=new OperationAdd();
            break;
            case "-":
            oper=new OperationSub();
            break;
            case "*":
            oper=new OperationMul();
            break;
            case "/":
            oper=new OperationDiv();
            break;
        }
        return oper;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Operation operation=OperationFactory.creationOperation("+");
        operation.set_numberA(1);
        operation.set_numberB(2);
        System.out.println(operation.getResult());
    }

}