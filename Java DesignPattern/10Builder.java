public class Product{
    private String part1;
    private String part2;

    public String getPart1() {
        return part1;
    }
    public void setPart1(String part1) {
        this.part1 = part1;
    }
    public String getPart2() {
        return part2;
    }
    public void setPart2(String part2) {
        this.part2 = part2;
    }
}

public interface Builder(){
    public void buildPartA();
    public void buildPartB();

    public Product retrieveResult();
}

public class ConcreteBuilder implements Builder{
    private Product product=new Product();

    @Override
    public void buildPartA(){
        //
    }

    @Override
    public void buildPartB(){
        //
    }

    @Override
    public Product retrieveResult(){
        return product;
    }
}

public class Director{
    private Builder builder;

    public Director(Builder builder){
        this.builder=builder;
    }

    public void construct(){
        builder.buildPartA();
        builder.buildPartB();
    }
}

public static void main(String[] args){
    Builder builder=new ConcreteBuilder();
    Director director=new Director(builder);
    director.construct();
    Product product=builder.retrieveResult();
    product.getPart1();
    product.getPart2();
}

/*
 客户端负责创建导演者和具体建造者对象。然后，客户端把具体建造者对象交给导演者，导演者操作具体建造者，开始创建产品。当产品完成后，建造者把产品返还给客户端。
 把创建具体建造者对象的任务交给客户端而不是导演者对象，是为了将导演者对象与具体建造者对象的耦合变成动态的，从而使导演者对象可以操纵数个具体建造者对象中的任何一个。
 建造模式分成两个很重要的部分：

　　1. 一个部分是Builder接口，这里是定义了如何构建各个部件，也就是知道每个部件功能如何实现，以及如何装配这些部件到产品中去；

　　2. 另外一个部分是Director，Director是知道如何组合来构建产品，也就是说Director负责整体的构建算法，而且通常是分步骤地来执行。

　　不管如何变化，建造模式都存在这么两个部分，一个部分是部件构造和产品装配，另一个部分是整体构建的算法。认识这点是很重要的，因为在建造模式中，强调的是固定整体构建的算法，而灵活扩展和切换部件的具体构造和产品装配的方式。

　　再直白点说，建造模式的重心在于分离构建算法和具体的构造实现，从而使得构建算法可以重用。具体的构造实现可以很方便地扩展和切换，从而可以灵活地组合来构造出不同的产品对象。
*/