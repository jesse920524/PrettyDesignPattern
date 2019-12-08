package lesson14.common;

/**
 * Created by Jesse Fu on 2019-12-08.
 */
public class Token {

    private String token;

    private long ts;
    public Token(String token, long ts) {
        this.token = token;
        this.ts = ts;
    }

    public String getToken() {
        return token;
    }

    public long getTs() {
        return ts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Token)) return false;

        Token token1 = (Token) o;

        if (ts != token1.ts) return false;
        return token != null ? token.equals(token1.token) : token1.token == null;

    }

    @Override
    public int hashCode() {
        int result = token != null ? token.hashCode() : 0;
        result = 31 * result + (int) (ts ^ (ts >>> 32));
        return result;
    }
}
