package com.khy.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 寇含尧 on 2018/1/7.
 */
@Component
public class ErrorFilter extends ZuulFilter{
    Logger log = LoggerFactory.getLogger(ErrorFilter.class);

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        log.error("this is a ErrorFilter : {}", throwable.getCause().getMessage());
//        ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
         ctx.setResponseStatusCode(99999);
         ctx.setResponseBody("{\"code\":\"000\",\"message\":\""+throwable.getCause().getMessage()+"\"}");
        return null;
    }
}
