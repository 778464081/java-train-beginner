package T2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put( "张三丰" , 108 );
        map.put( "殷天正" , 79 );
        map.put( "张翠山" , 36 );
        map.put( "殷素素" , 30 );
        map.put( "张无忌" , 8 );
        map.put( "周芷若" , 7 );
        Set<Map.Entry<String,Integer>> doub =map.entrySet();
        Iterator<Map.Entry<String,Integer>> e =doub.iterator();
        while(e.hasNext()){
            Map.Entry<String,Integer> ee =e.next();
            System.out.println(ee.getKey() + ee.getValue());
        }
    }
}
