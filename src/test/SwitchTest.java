import com.walltech.b2b.model.UserBean;

/**
 * Created by zedd on 2017/6/12.
 */
public class SwitchTest {
    public static void main(String[] args) {
        int temp  = 1;
        switch (temp){
            case -1:
                System.out.println(-1 + ",");
            case -2:
                System.out.println(-2 + ",");
            case -3:
                System.out.println(-3 +",");
            case 1:
                System.out.println(1 + ",");
            case 2:
                System.out.println(2 + ",");
            default:
                System.out.println(0 + "!");
                break;
        }

        System.out.println(UserBean.class);
    }
}
