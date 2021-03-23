package src;

/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/22
 */
public class Decorator {
    public static void main(String[] args) {
        Person dyd = new Person("dyd");
        Sneakers pqx = new Sneakers();
        Tshirts dtx = new Tshirts();
        BigTrouser kk = new BigTrouser();

        pqx.Decorate(dyd);
        kk.Decorate(pqx);
        dtx.Decorate(kk);
        dtx.show();

    }
}
    // 个人类
    class Person{
        // 构造函数
        Person(){}
        private String name;
        Person(String name){
            this.name = name;
        }
        public void show(){
            System.out.println("装扮的"+name);
        }
    }
    // 服饰类
    class Finery extends Person{
        Person component = null;
        // 打扮
        public void Decorate(Person component){
            this.component = component;
        }
        @Override
        public void show(){
            if(component != null){
                component.show();
            }
        }
    }
    // 具体服饰类
    class Tshirts extends Finery{
        @Override
        public void show(){
            System.out.println("大T恤 ");
            super.show();
        }
    }
    class  BigTrouser extends Finery{
        @Override
        public void show(){
            System.out.println("大垮裤 ");
            super.show();
        }
    }
    class Sneakers extends Finery{
        @Override
        public void show(){
            System.out.println("球鞋 ");
            super.show();
        }
    }


