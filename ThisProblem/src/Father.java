/**
 * @author 苏少奇
 * @version 1.0
 * @ClassName Father
 * @company 公司
 * @Description TODO
 * @createTime 2021年09月23日 16:16:16
 */
public class Father {
    /**
     * service方法出现this指向serbice方法实例对象
     * @param method
     */
    public void service(String method){
        if("get".equals(method)){
            this.doGet();
        }else if("post".equals(method)){
            this.doPost();
        }
    }

    public void doPost() {
        System.out.println("Father doGet is run");
    }

    public void doGet() {
        System.out.println("Father do Post is run");
    }
}
