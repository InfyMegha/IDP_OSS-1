/*******************************************************************************
createApplication * © 2018 Infosys Limited, Bangalore, India. All Rights Reserved. 
 * IDP_PaaS
 * 
 * Except for any free or open source software components embedded in this 
 * Infosys proprietary software program, this Program is protected 
 * by copyright laws, international treaties and other pending or existing 
 * intellectual property rights in India, the United States and other countries. 
 * Except as expressly permitted, any unauthorized reproduction, storage, 
 * transmission in any form or by any means (including without limitation 
 * electronic, mechanical, printing, photocopying, recording or otherwise), 
 * or any distribution of this Program, or any portion of it, may result in 
 * severe civil and criminal penalties, and will be prosecuted to the maximum 
 * extent possible under the law.
 ******************************************************************************/
package org.infy.subscription;

import org.jboss.logging.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Christian Claus (ch.claus@me.com)
 * 
 */
@Component
public class RequestFilter implements Filter{
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // do nothing.
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null) {
          MDC.put("username", authentication.getPrincipal());
    }

    filterChain.doFilter(servletRequest, servletResponse);
    MDC.remove("username");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void destroy() {
    // do nothing.
  }
}