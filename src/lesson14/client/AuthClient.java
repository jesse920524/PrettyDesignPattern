package lesson14.client;

import lesson14.common.AuthUrl;
import lesson14.common.Token;
import lesson14.common.TokenManager;

/**
 * Created by Jesse Fu on 2019-12-08.
 */
public class AuthClient {

    public AuthClient(){

    }

    public AuthUrl sendAuthRequest(String url,
                                   String appId,
                                   String pwd,
                                   long ts){
        Token token = TokenManager.getInstance().generateToken(url, appId, pwd, ts);
        AuthUrl authUrl = AuthUrl.create(token, appId, ts);
        return authUrl;
    }
}
