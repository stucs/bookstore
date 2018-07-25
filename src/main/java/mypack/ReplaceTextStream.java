package mypack;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class ReplaceTextStream extends ServletOutputStream {
    private ServletOutputStream mServletOutoutStream;
    private ByteArrayOutputStream mba;
    private String mSearchStr, mReplaceStr;

    private boolean closed;
    public ReplaceTextStream(ServletOutputStream outputStream, String searchStr, String replaceStr) {
        mServletOutoutStream = outputStream;
        mba = new ByteArrayOutputStream();

        mSearchStr = searchStr;
        mReplaceStr = replaceStr;
    }

    @Override
    public void println(String s) throws IOException {
        s = s + "\n";
        byte[] bs = s.getBytes();
        mba.write(bs);
    }

    @Override
    public void close() throws IOException {
        if (!closed) {
            processStream();
            mServletOutoutStream.close();
            closed = true;
        }
    }

    @Override
    public void write(byte[] b) throws IOException {
        mba.write(b);
    }

    @Override
    public void write(int i) {
        mba.write(i);
    }

    @Override
    public void flush() throws IOException {
        if (!closed) {
            processStream();
            mba = new ByteArrayOutputStream();
        }
    }

    private void processStream() throws IOException {
        mServletOutoutStream.write(replaceContent(mba.toByteArray()));
        mServletOutoutStream.flush();
    }

    private byte[] replaceContent(byte[] str) {
        String content = str.toString();
        int end = content.indexOf(mSearchStr);
        String res = "";
        String firstPart = "";
        if (end != -1) {
            firstPart = content.substring(0, end);
            res = firstPart + mReplaceStr + content.substring(end + mSearchStr.length());
        } else {
            res = content;
        }

        return res.getBytes();
    }

}
