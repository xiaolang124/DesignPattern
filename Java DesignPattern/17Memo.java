public class Originator {
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Memento createMemento(){
		return new Memento(state);
	}
	
	public void setMemento(Memento memento){
		state=memento.getState();
	}
	
	public void show(){
		System.out.println("State="+state);
	}
}

public class Memento {
	private String state;
	
	public Memento(String state){
		this.state=state;
	}
	
	public String getState(){
		return state;
	}
}

public class Originator {
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Memento createMemento(){
		return new Memento(state);
	}
	
	public void setMemento(Memento memento){
		state=memento.getState();
	}
	
	public void show(){
		System.out.println("State="+state);
	}
}

public static void main(String[] args) {
	Originator originator=new Originator();
	originator.setState("On");
	originator.show();
		
	Caretaker caretaker=new Caretaker();
	caretaker.setMemento(originator.createMemento());
		
	originator.setState("Off");
	originator.show();
		
	originator.setMemento(caretaker.getMemento());
	originator.show();
}