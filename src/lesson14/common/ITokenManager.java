package lesson14.common;

/**
 * Created by Jesse Fu on 2019-12-08.
 *
 * token相关操作
 */
public interface ITokenManager {

    /**校验token是否过期*/
    boolean checkExpire(Token token);

    /**生成token
     *
     * @param url
     * @param appId
     * @param pwd
     * @param timestamp */
    Token generateToken(
            String url,
            String appId,
            String pwd,
            long timestamp);
}
