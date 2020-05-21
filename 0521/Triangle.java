package homework0521;

public class Triangle extends  Shape {
    public  Triangle(){
        this.type="triangle";
    }
  protected double firstEdge;
  protected double secondEdge;
  protected double thirdEdge;
    public void calculate(){
        double p =(firstEdge + secondEdge +thirdEdge )/2;
        double s = Math.sqrt(p * (p-firstEdge) *(p-secondEdge) * (p-thirdEdge));
        area=s;
    }
    public  void description(){
        System.out.println("三角形三边长分别为：" + firstEdge + "," +secondEdge + "," +thirdEdge );
        show();
    }
}
