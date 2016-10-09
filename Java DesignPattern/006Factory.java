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

public interface IFactory{
    public Operation CreateOperation();
}


class AddFactory extends IFactory{
    public Operation CreateOperation(){
        return new OperationAdd();
    }
}

class SubFactory extends IFactory{
    public Operation CreateOperation(){
        return new OperationSub();
    }
}

class MulFactory extends IFactory{
    public Operation CreateOperation(){
        return new OperationMul();
    }
}

class DivFactory extends IFactory{
    public Operation CreateOperation(){
        return new OperationDiv();
    }
}


IFactory operFactory=new AddFactory();
Operation oper=oper.CreateOperation();
oper.NumberA=1;
oper.NumberB=2;
double result=oper.GetResult();