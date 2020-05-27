package demo01;

public class Aircraft extends Machine implements Flyable,Roadable,Voyageable{
    public Aircraft(int x) {
        super(x);
    }

    @Override
    public void fly() {
        System.out.println("一个 Aircraft 实例在空中飞行一次所消耗的能量值为 25");
    }

    @Override
    public void run() {
        System.out.println("一个 Aircraft 实例在陆地中行驶一次所消耗的能量值为 10");

    }

    @Override
    public void voyage() {
        System.out.println("一个 Aircraft 实例在水中航行一次所消耗的能量值为 15");
    }
}
