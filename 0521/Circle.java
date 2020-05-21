package homework0521;

public class Circle extends  Shape {
    public Circle(){
        this.type="circle";
    }
    protected double radius;
    public void calculate(){
        double s= Math.PI *Math.pow(radius,2);
        area=s;
    }
    public  void description() {
        System.out.println("圆的半径为：" + radius);
        show();
    }
}