package lesson14.common;

/**
 * Created by Jesse Fu on 2019-12-08.
 *
 * 鉴权结果。
 */
public class AuthResult {

    private int statusCode;

    private String errorMessage;

    public AuthResult() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
