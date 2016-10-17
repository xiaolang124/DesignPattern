public class SubSystemOne{
    public void methodOne(){
        //方法一
    }
}

public class SubSystemTwo{
    public void methodTwo(){
        //方法二
    }
}

public class SubSystemThree{
    public void methodThree(){
        //方法三
    }
}

public class SubSystemFour{
    public void methodFour(){
        //方法四
    }
}

//外观类
public class Facade{
    SubSystemOne one;
    SubSystemTwo two;
    SubSystemThree three;
    SubSystemFour four;

    public Facade(){
        one=new SubSystemOne();
        two=new SubSystemTwo;
        three=new SubSystemThree();
        four=new SubSystemFour();
    }

    public void methodA(){
        one.methodOne();
        two.methodTwo();
    }

    public void methodB(){
        three.methodThree();
        four.methodFour();
    }
}

static void Main(String[] args){
    Facade facade=new Facade();

    facade.methodA();
    facade.methodB();
}