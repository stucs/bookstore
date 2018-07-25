package mypack;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class NoteFilter implements Filter {
    private FilterConfig mConfig;
    private String mBlockList;
    private String mBlockIp;

    @Override
    public void init(FilterConfig filterConfig) {
        mConfig = filterConfig;
        mBlockIp = mConfig.getInitParameter("ip");
//        mBlockList
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (!checkIP(servletRequest, servletResponse)) return;

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean checkIP(ServletRequest request, ServletResponse response) throws IOException{
        String addr = request.getRemoteAddr();

        if ((addr.indexOf(mBlockIp)) != -1) {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("cannot provide service");
            out.flush();
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void destroy() {
        mConfig = null;
    }
}
