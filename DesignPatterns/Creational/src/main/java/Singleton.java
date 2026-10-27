class JudgeClass {

    private static final JudgeClass judgeClass = new JudgeClass();

    private JudgeClass() {
    }

    public static JudgeClass getInstance() {
        return judgeClass;
    }
}

public class Singleton {
    public static void main(String[] args) {

        JudgeClass judgeClass1 = JudgeClass.getInstance();
        JudgeClass judgeClass2 = JudgeClass.getInstance();

        System.out.println(judgeClass1 == judgeClass2);
    }
}



















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
