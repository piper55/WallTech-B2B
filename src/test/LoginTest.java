import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;
import com.walltech.b2b.model.BookBean;
import com.walltech.b2b.model.UserBean;

import java.util.HashMap;

/**
 * Created by zedd on 2017/5/12.
 */
public class LoginTest {



    public static void main(String[] args) {
        //int[] a = {-1, 3, -4, 5, 1, -6, 2, 1};
        //int[] b = {3,2,4};
        //System.out.println(solution(a));
        //System.out.println(twoSum(b,6));
        //String s = "   ";
        //System.out.println(s.length());
        //System.out.println(BinarySystem(17));
        String temp2 = "{\"author\":\"aaaaa\",\"name\":\"effective java\",\"userBean\":[{}]}";
        BookBean bookBean1 = (BookBean) JSON.parseObject(temp2,BookBean.class);
        JSONObject test = new JSONObject();
        test.put("res",-1);
        if (-1 ==  (Integer) test.get("res")){
            System.out.println("i'm right!");
        }
        String tempString  = new String ();
        tempString = "sdfsffs";
        List<String> tempList = new ArrayList<String>();
        tempList.add(tempString);
        tempList = null;
        System.out.println(tempList);
        List<UserBean> userTmep = new ArrayList<UserBean>();
        BookBean bookBean = new BookBean();
        bookBean.setName("effective java");
        bookBean.setAuthor("aaaaa");
        UserBean userBean = new UserBean();
        userBean.setAddress("abc");
        userBean.setAge(0);
        userBean.setSex('b');
        userBean.setName("");
        UserBean userBean1 = new UserBean();
        userBean1.setName("11111");
        userBean.setAddress("dfdsfsdfs");
        userBean1.setAge(1);
        userBean1.setName("1");
        userBean1.setSex('g');
        userTmep.add(userBean);
        userTmep.add(userBean1);
        bookBean.setUserBean(userTmep);
        System.out.println(JSON.toJSONString(bookBean));
        HashMap<String,Object> hashMap = new HashMap<String, Object>();
        hashMap.put("age",1);
        hashMap.put("address","bcd");
        hashMap.put("sex",'b');
        hashMap.put("name"," ");
        String temp = JSON.toJSONString(hashMap);
        UserBean userBean2 = JSON.parseObject(temp,UserBean.class);
        String res = JSON.toJSONString(userBean);
        System.out.println(res);
        UserBean userBean3 = JSON.parseObject(res,UserBean.class);
        System.out.println(userBean2.getAddress() + "," + userBean2.getName() + "," +userBean2.getAge() + "," + userBean2.getSex());
    }

    public static int BinarySystem(int x){

        return 0;
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
