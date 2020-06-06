package T1;

import java.util.ArrayList;
import java.util.Collections;

public class Poker {
    public static void main(String[] args) {
        //牌盒
        ArrayList<String> pokerBox =new ArrayList<>();
        //花色
        ArrayList<String> colors =new ArrayList<>();
        //数字集合
        ArrayList<String> numbers =new ArrayList<>();

        //放入花色
        colors.add("♥");
        colors.add("♦");
        colors.add("♠");
        colors.add("♣");
        //放入牌值
        for (int i = 2; i <=10 ; i++) {
            numbers.add(i +"");
        }
        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");

        //把牌值与花色进行组合
        for (String a:colors){
            for (String b :numbers){
                String card =a+b;
                pokerBox.add(card);
            }
        }
        pokerBox.add("大鬼");
        pokerBox.add("小鬼");
        //洗牌
        Collections.shuffle(pokerBox);
        ArrayList<String> play1 =new ArrayList<>();
        ArrayList<String> play2 =new ArrayList<>();
        ArrayList<String> play3 =new ArrayList<>();
        ArrayList<String> dipai =new ArrayList<>();
        for (int i = 0; i < pokerBox.size(); i++) {
            String card =pokerBox.get(i);
            if (i>=51){
                dipai.add(card);
            }else{
                if (i%3==0){
                    play1.add(card);
                }else if (i%3==1){
                    play2.add(card);
                }else if (i%3==2){
                    play3.add(card);
                }
            }

        }
        System.out.println("东方月初" + play1);
        System.out.println("涂山雅雅" + play2);
        System.out.println("涂山红红" + play3);
        System.out.println("底牌是" + dipai);
    }
}
