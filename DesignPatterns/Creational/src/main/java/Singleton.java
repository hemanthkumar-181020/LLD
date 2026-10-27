

//Eager Singleton Design Pattern — Eager Initialization thread safe
//class JudgeClass {
//
//    private static final JudgeClass judgeClass = new JudgeClass();
//
//    private JudgeClass() {
//    }
//
//    public static JudgeClass getInstance() {
//        return judgeClass;
//    }
//}
//
//public class Singleton {
//    public static void main(String[] args) {
//
//        JudgeClass judgeClass1 = JudgeClass.getInstance();
//        JudgeClass judgeClass2 = JudgeClass.getInstance();
//
//        System.out.println(judgeClass1 == judgeClass2);
//    }
//}

// Eager Loading - Not thread safe;
//class JudgeClass {
//
//    private static  JudgeClass judgeClass ;
//
//    private JudgeClass() {
//    }
//
//    public static  synchronized JudgeClass getInstance() {
//        if(judgeClass==null){
//            judgeClass = new JudgeClass();
//        }
//        return judgeClass;
//    }
//}
//
//public class Singleton {
//    public static void main(String[] args) {
//
//        JudgeClass judgeClass1 = JudgeClass.getInstance();
//        JudgeClass judgeClass2 = JudgeClass.getInstance();
//
//        System.out.println(judgeClass1 == judgeClass2);
//    }
//}

//Double check KeyWord
//class JudgeClass {
//
//    private static volatile JudgeClass judgeClass;
//
//    private JudgeClass() {
//    }
//
//    public static JudgeClass getInstance() {
//
//        if (judgeClass == null) {
//            synchronized (JudgeClass.class) {
//
//                if (judgeClass == null) {
//                    judgeClass = new JudgeClass();
//                }
//            }
//        }
//
//        return judgeClass;
//    }
//}
//
//public class Singleton {
//
//    public static void main(String[] args) {
//
//        JudgeClass judgeClass1 = JudgeClass.getInstance();
//        JudgeClass judgeClass2 = JudgeClass.getInstance();
//
//        System.out.println(judgeClass1 == judgeClass2);
//    }
//}
class JudgeClass {


    private JudgeClass() {
    }
    private static class SingletonHolder {
        private static final JudgeClass judgeClass = new JudgeClass();
    }

    public static JudgeClass getInstance() {
        return SingletonHolder.judgeClass;
    }
}

public class Singleton {

    public static void main(String[] args) {

        JudgeClass judgeClass1 = JudgeClass.getInstance();
        JudgeClass judgeClass2 = JudgeClass.getInstance();

        System.out.println(judgeClass1 == judgeClass2);
    }
}


















// problem
//class JudgeClass{
//    private int run  = 0 ;
//    private int submit = 0 ;
//    public void countRun(){
//        run++;
//    }
//    public void countSubmit(){
//        submit++;
//    }
//    public int getRunCount(){
//        return run;
//    }
//    public int getSubmitCount(){
//        return submit;
//    }
//
//
//
//}
//
//public class Singleton {
//    public static void main(String[] args) {
//         JudgeClass judgeClass = new JudgeClass();
//         judgeClass.countRun();
//         judgeClass.countSubmit();
//         JudgeClass judgeClass1 = new JudgeClass();
//         judgeClass1.countRun();
//         judgeClass1.countSubmit();
//        System.out.println(judgeClass.getRunCount());
//    }
//}
