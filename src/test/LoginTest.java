/**
 * Created by zedd on 2017/5/12.
 */
public class LoginTest {



    public static void main(String[] args) {
        int[] a = {-1, 3, -4, 5, 1, -6, 2, 1};
        int[] b = {3,2,4};
        //System.out.println(solution(a));
        //System.out.println(twoSum(b,6));
        //String s = "   ";
        //System.out.println(s.length());
        System.out.println(BinarySystem(17));
    }

    public static int BinarySystem(int x){

    }


    public static int solution(int[] A) {
        // write your code in Java SE 8
        int sumBefore = 0, sumLast = 0 , i = 0;
        sumBefore = A[i] + sumBefore;
        for(int j = i + 1 ; j < A.length; j++){
            sumLast = A[j] + sumLast;
        }
        if (sumBefore == sumLast){
            return i;
        }
        while(i <= (A.length-1)){
            sumBefore = A[i] + sumBefore;
            sumLast = sumLast - A[i];
            if(sumBefore == sumLast){
                break;
            }
            i++;
        }
        if( i >= A.length ) i = -1;
        return i;
    }
    public static int[] twoSum(int[] nums, int target) {
        int temp;
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                temp = nums[i] + nums[j];
                if (temp == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }
}
