package demo02;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class DateHelper {
    private DateHelper(){

    }
    public static DateHelper getInstance(){
            return new DateHelper();
    }
    public Date toDate( int year , int month , int date , int hourOfDay , int minute ) {
        // 可以将 秒 和 毫秒 部分直接设置为 零
        Calendar a =Calendar.getInstance();
        a.set(year,month,date,hourOfDay,minute);
        a.set(Calendar.SECOND,0);
        a.set( Calendar.MILLISECOND , 0 );
         return a.getTime();

    }

    public Date toDate( int year , int month , int date , int hourOfDay , int minute , int second ) {
        Calendar a =Calendar.getInstance();
        a.set(year,month,date,hourOfDay,minute,second);
        a.set( Calendar.MILLISECOND , 0 );
        return a.getTime();

    }

    public Date toDate( int year , int month , int date , int hourOfDay , int minute , int second , int millis ) {
        // 自行设计实现过程
        Calendar a =Calendar.getInstance();
        a.set(year,month,date,hourOfDay,minute,second);
        a.set( Calendar.MILLISECOND , millis);
        return a.getTime();

    }
    public String toString( final Calendar date ) {

        // 从 Calendar实例 中 获取 各个日历字段 的值 并 连接到 字符序列 中
        StringBuilder b =new StringBuilder();
        b.append(date.get(Calendar.YEAR) +"年" +date.get(Calendar.MONTH) +"月" + date.get(Calendar.DATE)+"日"+date.get(Calendar.HOUR)+
                "时"+date.get(Calendar.MINUTE) +"分"+ date.get(Calendar.SECOND)+"秒" +"."+date.get(Calendar.MILLISECOND));
        return b.toString();
        // 返回 Calendar实例 对应的字符序列

    }
    public String toString( final Date date ) {

        // 实现思路:

        // 1、获取一个 Calendar 实例
        Calendar a =Calendar.getInstance();

        // 2、清空 Calendar 实例的 日历字段值 和 时间值
        a.clear();
        // 3、将 参数 date 所表示的瞬间设置到 新创建的 Calendar 实例中
        a.setTime(date);
        String s =toString(a);
        // 4、调用 toString( Calendar ) 方法获取 Calendar实例 的字符串形式
        // 5、将 Calendar实例 的字符串形式 直接返回即可
        return s;
    }
    public int durationOfDays( Date first , Date second ) {
        Calendar fir = Calendar.getInstance();
        Calendar sec =Calendar.getInstance();
        fir.setTime(first);
        sec.setTime(second);
        int year =0;
        int month =0;
        int date =0;
        int s=0;
        if (first.before(second)){
            year = (sec.get(Calendar.YEAR)-fir.get(Calendar.YEAR))*365;
           if((sec.get(Calendar.MONTH) -fir.get(Calendar.MONTH)>=0)){
                month =(sec.get(Calendar.MONTH) -fir.get(Calendar.MONTH))*30;
           }else {
               year-=365;
                month =(sec.get(Calendar.MONTH)+12 -fir.get(Calendar.MONTH))*30;
           }
           if ((sec.get(Calendar.DATE) -fir.get(Calendar.DATE))>0){
                date =(sec.get(Calendar.DATE) -fir.get(Calendar.DATE))*30;
           }else {
               month-=30;
                date =(sec.get(Calendar.DATE)+30 -fir.get(Calendar.DATE));
           }
           s=year+month+date;
        }


        if (first.equals(second)){
           s=0;
        }


        if (first.after(second)){
            year = (fir.get(Calendar.YEAR)-sec.get(Calendar.YEAR))*365;
            if((fir.get(Calendar.MONTH) -sec.get(Calendar.MONTH)>=0)){
                month =(fir.get(Calendar.MONTH) -sec.get(Calendar.MONTH))*30;
            }else {
                year-=365;
                month =(fir.get(Calendar.MONTH)+12 -sec.get(Calendar.MONTH))*30;
            }
            if ((fir.get(Calendar.DATE) -sec.get(Calendar.DATE))>0){
                date =(fir.get(Calendar.DATE) -sec.get(Calendar.DATE))*30;
            }else {
                month-=30;
                date =(fir.get(Calendar.DATE)+30 -sec.get(Calendar.DATE));
            }
            s=-(year+month+date);

        }


        return s;
    }

    public static void main(String[] args) {

            DateHelper dh = DateHelper.getInstance(); // 获取 DateHelper 实例

            Date first = dh.toDate( 2000 , 4 , 30 , 5 , 50 ); // 获取 Date 实例
            System.out.println( dh.toString( first ) ); // 输出 2000年05月30日 05:50:00.000

            Date second = dh.toDate( 2020 , 5 , 1 , 18 , 20 , 35 ); // 获取 Date 实例
            System.out.println( dh.toString( second ) ); // 输出 2020年06月01日 18:20:35.000

            int days1 = dh.durationOfDays( first , second ) ; // 统计 first 和 second 之间间隔的天数
            System.out.println( days1 );

            int days2 = dh.durationOfDays( second , first ) ; // 统计 second 和 first 之间间隔的天数
            System.out.println( days2 );


    }
}
