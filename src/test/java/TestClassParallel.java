import org.testng.annotations.Test;

public class TestClassParallel {
 
    @Test
    public void test() {
        Class[] cls = { MainPageTest.class, MainPageTest1.class };
        // Parallel among classes
        //JUnitCore.runClasses(ParallelComputer.classes(), cls);
 
/*        System.out.println("----------------------------");
        // Parallel among methods in a class
        JUnitCore.runClasses(ParallelComputer.methods(), cls);
 
        System.out.println("----------------------------");
         
        // Parallel all methods in all classes
        JUnitCore.runClasses(new ParallelComputer(true, true), cls);*/
    }
}