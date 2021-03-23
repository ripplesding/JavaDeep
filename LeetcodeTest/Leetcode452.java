import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/23
 */
public class Leetcode452 {
    public static void main(String[] args) {
        int[][] twoDim = { {3, 9}, {7, 12}, {3, 8}, {6, 8} ,{9, 10}, {2, 9}, {0, 9}, {3, 9},{0, 6}, {2, 8}};
        Leetcode452 lc = new Leetcode452();
        System.out.println(lc.findMinArrowShots(twoDim));
    }
    public int findMinArrowShots(int[][] points) {
        if(points.length < 1) return 0;
//        Arrays.sort(points, (x, y)->x[0]-y[0]);// 排序
//        Arrays.sort(points, Comparator.comparingInt(a->a[0]));// 排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]<o2[0]?-1:1;
            }
        });
        System.out.println(Arrays.deepToString(points));
        int count = 1, prev = points[0][1];// 初始化
        for(int i = 1; i < points.length; ++i){
            if(points[i][0] > prev){
                prev = points[i][1];
                count++;
            }else{
                prev = Math.min(prev,points[i][1]);
            }
        }
        return count;
    }
}
