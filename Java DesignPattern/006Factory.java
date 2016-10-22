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

public interface IFactory {
	Operation creationOperation();
}

public class AddFactory implements IFactory{

	public Operation creationOperation() {
		return new OperationAdd();
	}
}

public class SubFactory implements IFactory{

	public Operation creationOperation() {
		return new OperationSub();
	}
}

public class MulFactory implements IFactory{

	public Operation creationOperation() {
		return new OperationMul();
	}
}

public class DivFactory implements IFactory{

	public Operation creationOperation() {
		return new OperationDiv();
	}

}

public static void main(String[] args) {
	IFactory operFactory=new AddFactory();
	Operation oper=operFactory.creationOperation();
	oper.set_numberA(1);
	oper.set_numberB(2);
	double result=oper.getResult();
}

//对比简单工厂
public class OperationFactory{
    public static Operation creationOperation(String operate){
        Operation oper=null;
        switch(operate){
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

public static void main(String[] args) {
	Operation oper;
    oper=operFactory.creationOperation("+");
	oper.set_numberA(1);
	oper.set_numberB(2);
	double result=oper.getResult();
}