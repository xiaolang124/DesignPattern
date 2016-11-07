合成/聚合

public interface HandsetSoft {
	public void run();
}

public class HandsetGame implements HandsetSoft{

	@Override
	public void run() {
		System.out.println("game");
	}
}

public class HandsetAddressList implements HandsetSoft{

	@Override
	public void run() {
		System.out.println("AddressList");
	}
}

public abstract class HandsetBrand {
	protected HandsetSoft soft;
	
	public void setHandsetSoft(HandsetSoft soft){
		this.soft=soft;
	}
	
	public abstract void run();
}

public class HandsetBrandN extends HandsetBrand{

	@Override
	public void run() {
		soft.run();
	}
}

public class HandsetBrandM extends HandsetBrand{

	@Override
	public void run() {
		soft.run();
	}
}

public class Test {

	public static void main(String[] args) {
		HandsetBrand ab;
		ab=new HandsetBrandM();
		
		ab.setHandsetSoft(new HandsetGame());
		ab.run();
		
		ab.setHandsetSoft(new HandsetAddressList());
		ab.run();
	}
}