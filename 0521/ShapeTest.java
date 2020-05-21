package homework0521;

public class ShapeTest {
    public static void main(String[] args) {
        Triangle t = new Triangle(); // 创建 Triangle 实例
        t.firstEdge = 30 ; // 设置边长
        t.secondEdge = 40 ; // 设置边长
        t.thirdEdge = 50 ; // 设置边长
        t.calculate() ; // 计算三角形面积
        t.description(); // 输出三角形信息和三角形面积

        Circle c = new Circle();
        c.radius = 8 ; // 设置半径
        c.calculate() ; // 计算圆面积
        c.description(); // 输出圆半径和圆面积
    }
}
