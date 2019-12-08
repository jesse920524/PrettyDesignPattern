package lesson14.server.model;

/**
 * Created by Jesse Fu on 2019-12-08.
 *
 * model层， 负责auth业务的数据逻辑。
 */
public class AuthRepository {

    public AuthRepository(){

    }

    /**模拟从db读取pwd*/
    public String readPwd(String appId){
        return "123456";
    }
}
