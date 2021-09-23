/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName Son
 * @company 公司
 * @Description TODO
 * @createTime 2021年09月23日 16:22:22
 */
public class Son extends Father{

    @Override
    public void doPost() {
        System.out.println("son do Post is run");
    }

    @Override
    public void doGet() {
        System.out.println("son doGet is run");
    }
}
