/**
 * Mainbo.com Inc.
 * Copyright (c) 2015-2017 All Rights Reserved.
 */

package com.timesaving.operation;

import org.apache.http.Header;

import com.tgb.ccl.http.common.HttpConfig;
import com.tgb.ccl.http.common.HttpHeader;
import com.tgb.ccl.http.exception.HttpProcessException;
import com.tgb.ccl.http.httpclient.HttpClientUtil;

/**
 * <pre>
 *
 * </pre>
 *
 * @author ljh
 * @version $Id: ApiOperation.java, v 1.0 2017年11月27日 下午5:02:05 ljh Exp $
 */
public class ApiOperationImpl implements ApiOperation {
  public String getUsers() {
    String url = "http://localhost:8081/migo-api/api/users";
    String sign = "123456";// TODO test
    Header[] headers = HttpHeader.custom().other(ClientConstant.AUTHORIZATION, sign).build();
    HttpConfig config = HttpConfig.custom();
    config.url(url).headers(headers);
    String resp = "";
    try {
      resp = HttpClientUtil.get(config);
    } catch (HttpProcessException e) {
    }
    System.out.println();
    return resp;
  }

}
