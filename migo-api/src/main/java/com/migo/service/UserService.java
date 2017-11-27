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

package com.migo.service;

import java.util.List;
import java.util.Map;

import com.migo.entity.UserEntity;

/**
 * 用户Service
 *
 * @author 知秋
 * @email fei6751803@163.com
 */
public interface UserService {

  UserEntity queryObject(Long userId);

  List<UserEntity> queryList(Map<String, Object> map);

  int queryTotal(Map<String, Object> map);

  void save(UserEntity user);

  void update(UserEntity user);

  void delete(Long userId);

  void deleteBatch(Long[] userIds);

  UserEntity queryByMobile(String mobile);

  /**
   * 用户登录
   * 
   * @param mobile
   *          手机号
   * @param password
   *          密码
   * @return 返回用户ID
   */
  long login(String mobile, String password);

  /**
   * 获取用户集合,json格式
   * 
   * @return
   */
  String getUsers();
}
