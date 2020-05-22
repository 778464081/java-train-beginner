package demo03;

public class Sector extends Shape {
    private double radius;
    private double arcLength;

    public Sector( double radius,double arcLength) {
        super("扇形");
        this.radius = radius;
        this.arcLength =arcLength;
    }

    public Sector() {
    }
    public void calculate(){
        double s = radius *arcLength /2;
        area =s;
    }
    public void  show(){
        System.out.println("扇形的半径为：" + radius + ",弧长为：" + arcLength);
        super.show();
    }
}
