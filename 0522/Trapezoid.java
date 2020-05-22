package demo03;

public class Trapezoid extends Shape {
    private double top;
    private double bottom;
    private double height;
    public Trapezoid(double top ,double bottom , double height){
        super("矩形");
        this.top =top;
        this.bottom=bottom;
        this.height =height;
    }
    public Trapezoid(){}
    public void calculate(){
        super.calculate();
        double s=(top + bottom)*height/2;
        area=s;
    }
    public void show(){
        System.out.println("上底：" + top +", 下底：" + bottom + ", 高：" +height);
        super.show();
    }
}
