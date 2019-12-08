package lesson14.common;

/**
 * Created by Jesse Fu on 2019-12-08.
 *
 * url
 */
public class AuthUrl {
    public static final String BASE_URL = "http://www.demo.com/";

    private Token token;
    private String appId;
    private long timestamp;
    private String baseUrl;

    private AuthUrl(Token token,
                    String appId,
                    long timestamp){
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
        baseUrl = BASE_URL;
    }

    /**生成url*/
    public static AuthUrl create(Token token,
                          String appId,
                          long timestamp){
        return new AuthUrl(token, appId, timestamp);
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public Token getToken() {
        return token;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
