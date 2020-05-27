package demo01;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        Machine m = new Aircraft(100);
        boolean x =true;
        while(x== true ) {
            int op = rand.nextInt( 10); // 随机产生 [ 0 , 10 ) 之间的数字
            switch( op ) {
                case 0 :
                    // 需要判断能量是否足以完成 陆地驾驶 操作，若不足就跳出循环 (如何从switch直接跳出while循环?)
                    if (m.getEnergy()<10){
                        x=false;
                        break;
                    }else{
                        m.setEnergy(m.getEnergy()-10);

                        Roadable r =(Roadable)m;
                        r.run();
                        System.out.println("所剩能量为" + m.getEnergy());
                    }
                    break;
                    // 执行 陆地驾驶 操作 ( Machine 不具备陆地驾驶能力，需要转换为 Roadable 才可以调用 run 方法 )
                case 1 :
                    if (m.getEnergy()<15){
                        x=false;
                        break;
                    }else{
                        m.setEnergy(m.getEnergy()-15);

                        Voyageable v =(Voyageable)m;
                        v.voyage();
                        System.out.println("所剩能量为" + m.getEnergy());
                    }
                    // 需要判断能量是否足以完成 水中航行 操作，若不足就跳出循环
                    // 执行 水中航行 操作 ( Machine 不具备水中航行能力，需要转换为 Voyageable 才可以调用 voyage 方法 )
                    break;
                case 2 :
                    if (m.getEnergy()<25){
                        x=false;
                        break;
                    }else{
                        m.setEnergy(m.getEnergy()-25);

                        Flyable f =(Flyable)m;
                        f.fly();
                        System.out.println("所剩能量为" + m.getEnergy());
                    }
                    // 需要判断能量是否足以完成 空中飞行 操作，若不足就跳出循环
                    // 执行 空中飞行 操作 ( Machine 不具备空中飞行能力，需要转换为 Flyable 才可以调用 fly 方法 )
                    break;
                default :
                    System.out.println("不支持的操作");
                    // 不支持的操作
            }
        }

        System.out.println("最终所剩能量为：" + m.getEnergy());
    }
}
