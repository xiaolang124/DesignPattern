
public class Context {
	private String input;

	private String output;
	
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}
}

public abstract class AbstractExpression {
	public abstract void intercept(Context context);
}

public class TerminalExpression extends AbstractExpression{

	@Override
	public void intercept(Context context) {
		System.out.println("终端解释器");
	}
}

public class NonterminalExpression extends AbstractExpression{

	@Override
	public void intercept(Context context) {
		System.out.println("非终端解释器");
	}
}

public class Test {

	public static void main(String[] args) {
		Context context=new Context();
		List<AbstractExpression> list=new ArrayList<>();
		list.add(new TerminalExpression());
		list.add(new NonterminalExpression());
		list.add(new TerminalExpression());
		
		for(AbstractExpression expression:list){
			expression.intercept(context);
		}
	}
}