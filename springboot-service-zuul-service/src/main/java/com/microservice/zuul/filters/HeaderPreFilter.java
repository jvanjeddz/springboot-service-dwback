package com.microservice.zuul.filters;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class HeaderPreFilter extends ZuulFilter{
	
	private static Logger log = LoggerFactory.getLogger(HeaderPreFilter.class);
	

	@Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
		log.info("Entrando a filtro pre (Header)");
        ctx.addZuulRequestHeader("X-Request-ID", UUID.randomUUID().toString());
        log.info(String.format("X-Request-ID header: %s",ctx.getZuulRequestHeaders()));
        return null;
    }

}
