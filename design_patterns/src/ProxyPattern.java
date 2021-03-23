package src;

/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/23
 */
public class ProxyPattern {
    public static void main(String[] args) {
        SchoolGirl girl = new SchoolGirl("吴丽丽，");
        Proxy pr = new Proxy(girl);
        pr.GiveGift();

    }
}
class SchoolGirl{// 小女孩
    private String name;

    SchoolGirl(String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
interface IGiveGift{// 公共接口
    public void GiveGift();
}
class Pesuit implements IGiveGift{// 追求者
    SchoolGirl mm;

    Pesuit(SchoolGirl mm){
        this.mm = mm;
    }
    public void GiveGift(){
        System.out.println(mm.getName()+"送你一个礼物！");
    }
}

class Proxy implements  IGiveGift{// 代理人
    Pesuit boy;


    Proxy(SchoolGirl girl) {
        boy = new Pesuit(girl);
    }

    public void GiveGift(){
        boy.GiveGift();
    }


}