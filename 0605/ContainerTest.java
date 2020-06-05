package T1;

import java.util.ArrayList;
import java.util.Collection;

public class ContainerTest {
    public static void main(String[] args) {
        Container one =new Container(10);
       one.add(1);
       one.add(2);
       one.add(3);
        Collection two =new ArrayList();
         two.add(1);
        ((ArrayList) two).add(3);
        one.removeAll(two);
        System.out.println(one);

    }
}
