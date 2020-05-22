package demo03;

public class Shape {

    protected double area;
    private String type;
    public Shape(String type){
        this.type = type;
    }
    public void calculate(){
        System.out.println("计算" + this.type + "的面积");
    }
    public void show(){
        System.out.println(this.type + "的面积为" + this.area);
    }

    public Shape() {
    }
}
