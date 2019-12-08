package lesson14.server.view;

import lesson14.common.AuthResult;
import lesson14.common.AuthUrl;
import lesson14.server.controller.AuthService;

/**
 * Created by Jesse Fu on 2019-12-08.
 *
 * 业务类， 接收client发送的auth request
 */
public class AuthController {

    private AuthService authService;
    public AuthController(){
        authService = new AuthService();
    }

    public AuthResult auth(AuthUrl url){
        return authService.auth(url);
    }
}
