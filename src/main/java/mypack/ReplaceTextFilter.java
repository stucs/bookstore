package mypack;

import javax.servlet.*;
import java.io.IOException;

public class ReplaceTextFilter implements Filter {

    private FilterConfig mConfig;
    private String mSearch;
    private String mReplace;

    @Override
    public void init(FilterConfig filterConfig) {
        mConfig = filterConfig;
        mSearch = mConfig.getInitParameter("search");
        mReplace = mConfig.getInitParameter("replace");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        ReplaceTextWrapper wrapper = new ReplaceTextWrapper(servletResponse, mSearch, mReplace);

        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("return to here");
//        wrapper.getOutputStream().close();
    }

    @Override
    public void destroy() {
        mConfig = null;
    }
}
