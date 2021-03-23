import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/23
 */
public class Leetcode435 {
    public static void main(String[] args) {
//        int[] test = {1,2,4,3,5};
        int[][] twoDim = { {1, 100}, {11, 22}, {1, 11}, {2, 12} };
//        Arrays.sort(twoDim,Comparator.comparingInt(a->a[0]));
//        Arrays.sort(twoDim,new Comparator<int[]>{
//            @Override
//            public int compare(int[] o1, int[] o2){
//                return Integer.compare(o2[0],o1[0]);
//            }
//        });
//        System.out.println(Arrays.deepToString(twoDim));
        Leetcode435 lc = new Leetcode435();
        System.out.println(lc.eraseOverlapIntervals(twoDim));

    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(b->b[0]));
        System.out.println(Arrays.deepToString(intervals));
        int deleted_count = 0;
        for(int i = 1; i < intervals.length; i++){
            if(compare(intervals[i-1],intervals[i],i ,intervals)){// 如果两个有重叠部分
                deleted_count++;
            }
        }
        return deleted_count;
    }

    boolean compare(int[] a1, int[] a2, int i ,int[][] intervals){// 比较两个是否有重叠，如果有，设置小的在后面，返回true
        if(a1[1]>a2[0]){// 重叠
            if(a1[1] < a2[1]){
                intervals[i] = a1;
            }
            return true;
        }
        return false;
    }
}
