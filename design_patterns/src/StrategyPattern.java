/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/18
 */
public class StrategyPattern {
    public static void main(String[] args) {
        OperationContext operCtxt = new OperationContext(2,"*",1);
        System.out.println(operCtxt.GetResult());
    }
}


class OperationContext{
    Operation oper = null;
    public OperationContext(double numberA, String operate, double numberB){
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
        oper.setNumberA(numberA);
        oper.setNumberB(numberB);
    }

    public double GetResult(){
        double result = oper.GetResult();
        return result;
    }
}