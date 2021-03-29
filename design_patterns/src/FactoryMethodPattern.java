package src;

/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/29
 */
public class FactoryMethodPattern {
    public static void main(String[] args) {
        IFactory factory = new UndergraduateFactory();
        LeiFeng student = factory.CreateLeiFeng();

        student.BuyRice();
        student.Wash();
        student.Sweep();
    }
}

class LeiFeng{
    public void Sweep(){
        System.out.println("扫地");
    }

    public void Wash(){
        System.out.println("洗衣");
    }

    public void BuyRice(){
        System.out.println("买米");
    }
}

class Undergraduate extends LeiFeng{}
class Volunteer extends LeiFeng{}

// 雷锋工厂
interface IFactory{
    LeiFeng CreateLeiFeng();
}

// 学习雷锋的大学生工厂
class UndergraduateFactory implements IFactory{
    public LeiFeng CreateLeiFeng(){
        return new Undergraduate();
    }
}
// 社会志愿者工厂
class VolunteerFactory implements IFactory{
    public LeiFeng CreateLeiFeng(){
        return new Volunteer();
    }
}