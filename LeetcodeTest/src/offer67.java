import java.util.ArrayList;

/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/20
 */
public class offer67 {
    public static void main(String[] args) {
//        offer67 test = new offer67();
//        System.out.println(test.strToInt("9223372036854775808"));
        //
    }
//    public int strToInt(String str) {
//        char[] strset = str.trim().toCharArray();
//        boolean positive = true;
//        int sign_count = 0;
//        ArrayList<Integer> _res = new ArrayList<>();
//        for(char ca : strset){// 从字符组中提取有效信息
//            if(ca == '+'){// 判断用==
//                sign_count++;
//                continue;
//            }else if(ca == '-'){// 字符用单引号
//                positive = false;
//                sign_count++;
//                continue;
//            }else if(ca -'0' >= 0 && ca -'9'<= 0){
//                _res.add(ca-'0');// 类型未转换，ArrayList存储类型冲突
//            }else{
//                break;
//            }
//        }
//        if(sign_count>1) return 0;
//        long res = 0, index = 1;// 未考虑到超越int边界的情况
//        for(int i = _res.size()-1; i >= 0; i--){// 处理信息，得到累加值res
//            res += _res.get(i)*index;
//            index *= 10;
//            if(res > Integer.MAX_VALUE || index > Integer.MAX_VALUE) return positive?Integer.MAX_VALUE:Integer.MIN_VALUE;// Java最值表示
//        }
//        return positive? (int)res:(int)-res;
//    }
}
