import java.util.Arrays;

/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/22
 */
public class Leetcode135 {
    public static void main(String[] args) {
        Leetcode135 lc = new Leetcode135();

        int[] candy_test = {1,0,2};
//        Arrays.sort(candy_test,(x,y)->(y-x));
        System.out.println(lc.candy(candy_test));
    }
    public int candy(int[] ratings) {
        // 初始化
        int len = ratings.length;
        int[] _res = new int[len];
        int i = 1;
        _res[0] = 1;
        // 双指针运算
        while(i < len){
            if(ratings[i-1] > ratings[i]){
                _res[i] = 1;
                int tmp = i;
                while(tmp > 0 && _res[tmp-1]==_res[tmp] && ratings[tmp-1]!= ratings[tmp]){// 回退更新相等的值
                    _res[tmp-1]++;
                    tmp--;
                }
            }else if(ratings[i-1] < ratings[i]){
                _res[i] = _res[i-1]+1;
            }else{
                _res[i] = 1;
            }
            i++;
        }
        int sum = 0;
        for(int k : _res){
            sum += k;
        }
        return sum;
    }
}
