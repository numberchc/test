package behavioral.templateMethod;

public class ConcreteClass extends AbstractClassTemplate {

    @Override
    public void abstractMethod1() {
        System.out.println("子类ConcreteClass abstractMethod1方法");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("子类ConcreteClass abstractMethod2方法");
    }

    /**
     * 不同的子类实现不同的钩子方法
     * 以此来控制template方法的执行
     *
     * @return
     */
    @Override
    public boolean doGetFlag() {
        //do something
        return false;
    }

}
