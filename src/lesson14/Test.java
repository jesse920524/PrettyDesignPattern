package lesson14;

import lesson14.client.AuthClient;
import lesson14.common.AuthResult;
import lesson14.common.AuthUrl;
import lesson14.server.view.AuthController;

/**
 * Created by Jesse Fu on 2019-12-08.
 */
public class Test {

    public static void main(String[] args) {
        AuthClient client = new AuthClient();
        AuthController controller = new AuthController();

        //send request
        AuthUrl authUrl = client.sendAuthRequest(AuthUrl.BASE_URL, "1024", "123456", System.currentTimeMillis());

        AuthResult result = controller.auth(authUrl);

        if (result.getStatusCode() == 200){
            System.out.println("鉴权成功！");
        }else{
            System.out.println("鉴权失败： " + result.getErrorMessage());
        }


    }
}
