package demo0;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateSort1 {
    public static void main(String[] args) {

        final Random random = new Random();

        final Calendar calendar = Calendar.getInstance();

        final Date[] dates = new Date[ 5 ] ;

        // 使用循环对 dates 数组进行初始化
        for( int i = 0 ; i < dates.length ; i++){
            // 随机产生 年份、月份、日期，并将其设置到 calendar 对象中
            calendar.set(random.nextInt(2021),random.nextInt(12),random.nextInt(30));
            // 随后使用 calendar 的 getTime 来获取 Date 实例
            Date date = calendar.getTime() ;
            dates[ i ] = date ;
        }

        // 使用循环输出排序前的日期
        for (int i = 0; i <dates.length ; i++) {
            System.out.println(dates[i]);
        }
        // 使用 Date 类提供的方法，对日期进行比较并排序
        Date a;
        for (int i = 0; i <dates.length-1; i++) {
           for (int j=0;j<dates.length-i-1;j++){
               if (dates[j].compareTo(dates[j+1])==1){
                    a=dates[j];
                    dates[j]=dates[j+1];
                    dates[j+1]=a;
               }
           }
        }
        System.out.println("-------------------------------------------");
        // 使用循环输出排序后的日期
        for (int i = 0; i <dates.length ; i++) {
            System.out.println(dates[i]);
        }
    }
}
