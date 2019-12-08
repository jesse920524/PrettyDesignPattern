package lesson14.common;

/**
 * Created by Jesse Fu on 2019-12-08.
 */
public class TokenManager implements ITokenManager {

    private TokenManager(){

    }

    public static TokenManager getInstance(){
        return new TokenManager();
    }

    @Override
    public boolean checkExpire(Token token) {
        long currentTs = System.currentTimeMillis();
        long tokenTs = token.getTs();

        if ((currentTs - tokenTs) < (60 * 1000 * 1000)){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Token generateToken(String url, String appId, String pwd, long timestamp) {
        String finalUrl = url + appId + pwd + timestamp;
        return EncryptUtil.encrypt(finalUrl, timestamp);
    }

    private static class EncryptUtil {

        private EncryptUtil(){}

        public static Token encrypt(String input, long ts){
            return new Token(input, ts);
        }
    }
}
