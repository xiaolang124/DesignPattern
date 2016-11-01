public abstract class Component {
	protected String name;
	
	public Component(String name){
		this.name=name;
	}
	
	public abstract void add(Component c);
	public abstract void remove(Component c);
	public abstract void display(int depth);
}

public class Leaf extends Component{
	public Leaf(String name){
		super(name);
	}

	@Override
	public void add(Component c) {
		System.out.println("Cannot add to a leaf");
	}

	@Override
	public void remove(Component c) {
		System.out.println("Cannot remove from a leaf");
	}

	@Override
	public void display(int depth) {
		System.out.println(depth+"-"+name);
	}
}

public class Composite extends Component{
	private List<Component> children=new LinkedList<Component>();
	
	public Composite(String name){
		super(name);
	}

	@Override
	public void add(Component c) {
		children.add(c);
	}

	@Override
	public void remove(Component c) {
		children.remove(c);
	}

	@Override
	public void display(int depth) {
		System.out.println(depth+"-"+name);
		for(Component component:children){
			component.display(depth+2);
		}
	}
}

public static void main(String[] args) {
	Composite root=new Composite("root");
	root.add(new Leaf("Leaf A"));
	root.add(new Leaf("Leaf B"));
		
	Composite comp=new Composite("Composite X");
	comp.add(new Leaf("Leaf XA"));
	comp.add(new Leaf("Leaf XB"));
	root.add(comp);
		
	Composite comp2=new Composite("Composite XY");
	comp.add(new Leaf("Leaf XYA"));
    comp.add(new Leaf("Leaf XYB"));
    root.add(comp2);
		
    root.add(new Leaf("Leaf C"));
		
	Leaf leaf=new Leaf("Leaf D");
	root.add(leaf);
	root.remove(leaf);
		
	root.display(1);
}

1-root
3-Leaf A
3-Leaf B
3-Composite X
5-Leaf XA
5-Leaf XB
5-Leaf XYA
5-Leaf XYB
3-Composite XY
3-Leaf C