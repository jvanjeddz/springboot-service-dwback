package com.microservice.zuul.filters;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.util.Pair;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class HeaderPostFilter extends ZuulFilter{
	
	private static Logger log = LoggerFactory.getLogger(HeaderPostFilter.class);
	

	@Override
    public String filterType() {
        return "post";
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
        List<Pair<String, String>> zuulResponseHeaders = ctx.getZuulResponseHeaders();
		
		log.info("Entrando a filtro post (Header)");
		log.info(String.format("ZuulRequestHeaders tras agregar nuevo X-Request-ID header: %s", ctx.getZuulRequestHeaders()));
		
			if (zuulResponseHeaders != null) {
				log.info("Headers sin modificar:");
				for (Pair<String, String> header : zuulResponseHeaders) {
					log.info(String.format("%s : %s", header.first(), header.second()));
				}
				log.info("Eliminando headers comprometedores...");
				zuulResponseHeaders.removeIf(header -> "DATE".equalsIgnoreCase(header.first()));
				zuulResponseHeaders.removeIf(header -> "KEEP-ALIVE".equalsIgnoreCase(header.first()));
            
				log.info("Headers restantes:");
				for (Pair<String, String> header : zuulResponseHeaders) {
					log.info(String.format("%s : %s", header.first(), header.second()));
				}
			}       
        return null;
    }

}
