package demo0;

import java.time.LocalDate;
import java.util.Random;

public class DateSort2 {
    public static void main(String[] args) {
        final Random random = new Random();

        final LocalDate[] dates = new LocalDate[ 5 ] ;

        // 使用循环对 dates 数组进行初始化
        for( int i = 0 ; i < dates.length ; i++){
            // 随机产生 年份、月份、日期，并以此获得 LocalDate 实例
            LocalDate date = LocalDate.of(random.nextInt(2021),random.nextInt(12)+1,random.nextInt(31));
            dates[ i ] = date ;
        }

        // 使用循环输出排序前的日期
        for (int i = 0; i <dates.length ; i++) {
            System.out.println(dates[i]);
        }
        // 使用 LocalDate 类提供的方法，对日期进行比较并排序
        LocalDate temp;
        for (int i = 0; i < dates.length-1; i++) {
            for (int j=0;j<dates.length-1-i;j++){
                if (dates[j].isAfter(dates[j+1])){
                    temp = dates[j];
                    dates[j] =dates[j+1];
                    dates[j+1] =temp;
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
