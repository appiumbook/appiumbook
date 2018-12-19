/**
 * Year: 2018-19
 *
 * @author Prat3ik on 19/12/18
 * @project Singleton Pattern
 */
public class SingletonClass {
    public static SingletonClass singletonClass;

    private SingletonClass() {
        System.out.println("Singleton Class object created.");
    }

    public static SingletonClass getSingletonClass() {
        if (singletonClass == null) {
            singletonClass = new SingletonClass();
        }
        return singletonClass;
    }

    public static void main(String[] args) {
        SingletonClass singletonClass1 = SingletonClass.getSingletonClass();
        SingletonClass singletonClass2 = SingletonClass.getSingletonClass();
    }
}
