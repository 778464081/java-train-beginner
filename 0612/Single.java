package T2;

public enum Single {
    SPRING("春天");
    Single(String m){
        System.out.println("现在是春天！！！");
    }
   Single show(){
        return SPRING;
   }
}
