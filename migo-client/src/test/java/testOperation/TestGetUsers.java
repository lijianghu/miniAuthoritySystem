package testOperation;

import org.apache.http.Header;

import com.tgb.ccl.http.common.HttpConfig;
import com.tgb.ccl.http.common.HttpHeader;
import com.tgb.ccl.http.exception.HttpProcessException;
import com.tgb.ccl.http.httpclient.HttpClientUtil;
import com.timesaving.operation.ClientConstant;

/**
 * 上传功能测试
 * 
 * @author arron
 * @date 2016年11月2日 下午1:17:17
 * @version 1.0
 */
public class TestGetUsers {

  public static void main(String[] args) throws HttpProcessException {
    String url = "http://localhost:8088/migo-web/api/users";
    String sign = "123456";// TODO test
    Header[] headers = HttpHeader.custom().other(ClientConstant.AUTHORIZATION, sign).build();
    HttpConfig config = HttpConfig.custom();
    config.url(url).headers(headers);
    String resp = "";
    try {
      resp = HttpClientUtil.get(config);
    } catch (HttpProcessException e) {
    }
    System.out.println(resp);
  }
}
