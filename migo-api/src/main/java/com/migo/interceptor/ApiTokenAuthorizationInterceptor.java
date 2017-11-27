/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.migo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.migo.ApiConstant;
import com.migo.annotation.ApiToken;
import com.migo.entity.TokenEntity;
import com.migo.service.TokenService;
import com.migo.utils.RRException;

/**
 * 
 * <pre>
 *  第三方api调用时,验证token
 * </pre>
 *
 * @author ljh
 * @version $Id: ApiTokenAuthorizationInterceptor.java, v 1.0 2017年11月27日
 *          下午4:21:32 ljh Exp $
 */
@Component
public class ApiTokenAuthorizationInterceptor extends HandlerInterceptorAdapter {
  @Autowired
  private TokenService tokenService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    ApiToken annotation;
    if (handler instanceof HandlerMethod) {
      annotation = ((HandlerMethod) handler).getMethodAnnotation(ApiToken.class);
    } else {
      return true;
    }

    if (annotation != null) {
      String token = request.getHeader(ApiConstant.AUTHORIZATION);
      if (StringUtils.isBlank(token)) {
        throw new RRException("token不能为空");
      }
      // 查询token信息
      TokenEntity tokenEntity = tokenService.queryAppKey(token);
      if (tokenEntity == null) {
        throw new RRException("token失效，调用失败");
      }
    }
    return true;
  }
}
