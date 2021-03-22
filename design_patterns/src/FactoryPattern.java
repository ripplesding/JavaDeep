/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/18
 */
public class FactoryPattern {
    public static void main(String[] args) {
        Operation oper = OperationFactory.createOperation("sqrt");
        oper.setNumberA(2.25);
        oper.setNumberB(2);
        System.out.println(oper.GetResult());
    }
}
// 工厂类
class OperationFactory{
    public static Operation createOperation(String operate){
        Operation oper = null;
        switch (operate){
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
            case "sqrt":
                oper = new OperationSqrt();
                break;
        }
        return oper;
    }
}
// 计算器
class Operation{
    private double NumberA = 0;
    private double NumberB = 0;


    public double getNumberA() {
        return NumberA;
    }

    public double getNumberB() {
        return NumberB;
    }

    public void setNumberA(double number) {
        NumberA = number;
    }

    public void setNumberB(double number) {
        NumberB = number;
    }

    public double GetResult()
    {
        double result = 0;
        return result;
    }
}

// 加减乘除，继承于Operation
class OperationAdd extends Operation{
    @Override
    public double GetResult() {
        double result = 0;
        result = getNumberA()+getNumberB();
        return result;
    }
}

class OperationSub extends Operation{
    @Override
    public double GetResult() {
        double result = 0;
        result = getNumberA()-getNumberB();
        return result;
    }
}

class OperationMul extends Operation{
    @Override
    public double GetResult() {
        double result = 0;
        result = getNumberA()*getNumberB();
        return result;
    }
}

class OperationDiv extends Operation{
    @Override
    public double GetResult() {
        double result = 0;
        result = getNumberA()/getNumberB();
        return result;
    }
}

class OperationSqrt extends Operation{
    @Override
    public double GetResult() {
        double result = 0;
        result = Math.sqrt(getNumberA());
        return result;
    }
}

