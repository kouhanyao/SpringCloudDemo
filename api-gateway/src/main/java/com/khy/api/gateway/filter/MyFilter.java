package com.khy.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


/**
 * 添加zuul过滤
 */
@Component
public class MyFilter extends ZuulFilter{

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下:
         pre：可以在请求被路由之前调用。
         routing：在路由请求时候被调用。
         post： 在routing和error过滤器之后被调用。
         error：处理请求时发生错误时被调用。
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 通过int值来定义过滤器的执行顺序，数值越小优先级越高。
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要被执行。这里我们直接返回了true，因此该过滤器对所有请求都会生效。实际运用中我们可以利用该函数来指定过滤器的有效范围。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑。
     * 这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，不对其进行路由，
     * 然后通过ctx.setResponseStatusCode(401)设置了其返回的错误码，
     * 当然我们也可以进一步优化我们的返回，比如，通过ctx.setResponseBody(body)对返回body内容进行编辑等。
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            //通过ctx.setSendZuulResponse(false)令zuul过滤该请求,不对其进行路由
            ctx.setSendZuulResponse(false);
            //通过ctx.setResponseStatusCode(401)设置了其返回的错误码
//            ctx.setResponseStatusCode(401);
//            ctx.setResponseBody("{\"code\":\"000\",\"message\":\"fail\"}");
            try {
                //ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){

            }
            doSomething();
            return null;
        }
        log.info("ok");
        return null;
    }

    private void doSomething() {
        throw new RuntimeException("Exist some errors...");
    }
}
