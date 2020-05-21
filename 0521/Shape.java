package homework0521;
class Shape{
    protected double area;
    protected String type;
    public  void show(){
        System.out.println(this.type + "的面积" + this.area);
    }
}