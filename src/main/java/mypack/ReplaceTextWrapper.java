package mypack;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class ReplaceTextWrapper extends HttpServletResponseWrapper {
    private ReplaceTextStream mRtStream;

    public ReplaceTextWrapper(ServletResponse response, String searchStr, String replaceStr) throws IOException {
        super((HttpServletResponse) response);

        mRtStream = new ReplaceTextStream(response.getOutputStream(), searchStr, replaceStr);
    }

    @Override
    public ServletOutputStream getOutputStream() {
        return mRtStream;
    }
}
