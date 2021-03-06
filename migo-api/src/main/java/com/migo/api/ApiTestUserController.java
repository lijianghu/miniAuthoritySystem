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

package com.migo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.migo.annotation.ApiToken;
import com.migo.annotation.LoginUser;
import com.migo.entity.UserEntity;
import com.migo.utils.R;

/**
 * 测试header中有token的api
 * 
 * <pre>
 *
 * </pre>
 *
 * @author ljh
 * @version $Id: ApiTestUserController.java, v 1.0 2017年11月27日 下午5:32:45 ljh Exp
 *          $
 */
@RestController
@RequestMapping("/api")
public class ApiTestUserController {
  /**
   * 获取用户信息
   */
  @ApiToken
  @GetMapping("users")
  public R userInfo(@LoginUser UserEntity user) {

    return R.ok().put("user", user);
  }

}
