package lesson14.server.controller;

import lesson14.common.AuthResult;
import lesson14.common.AuthUrl;
import lesson14.common.Token;
import lesson14.common.TokenManager;
import lesson14.server.model.AuthRepository;

/**
 * Created by Jesse Fu on 2019-12-08.
 *
 * 业务类， 负责处理auth相关的业务逻辑
 */
public class AuthService {

    private AuthRepository repository;

    public AuthService(){
        repository = new AuthRepository();
    }

    public AuthResult auth(AuthUrl url){
        AuthResult result = new AuthResult();

        //拆分出token， appid, timestamp

        //检查token过期
        boolean isExpire = checkExpire(url.getToken());

        if (isExpire){
            result.setErrorMessage("token已过期");
            result.setStatusCode(500);
            return result;
        }

        //若token未过期
        boolean match = tokenMatch(url.getToken(), url.getAppId(), url.getBaseUrl());
        if (!match){
            result.setErrorMessage("token匹配失败");
            result.setStatusCode(503);
            return result;
        }

        result.setErrorMessage("token匹配成功！");
        result.setStatusCode(200);
        return result;
    }

    private boolean checkExpire(Token token){
        return TokenManager.getInstance().checkExpire(token);
    }

    private boolean tokenMatch(Token token,
                               String appId,
                               String url){
        String pwd = repository.readPwd(appId);
        //构造新token
        Token newToken = TokenManager.getInstance().generateToken(url, appId, pwd, token.getTs());
        //比较
        if (newToken.equals(token)) {
            return true;
        }else{
            return false;
        }
    }
}
