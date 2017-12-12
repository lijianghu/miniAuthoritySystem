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

package com.migo.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.migo.dao.TokenDao;
import com.migo.entity.TokenEntity;
import com.migo.service.TokenService;

/**
 * @author 知秋
 * @email fei6751803@163.com
 */
@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	private TokenDao tokenDao;
	// 12小时后过期
	private final static int EXPIRE = 3600 * 12;

	@Override
	public TokenEntity queryByUserId(Long userId) {
		return tokenDao.queryByUserId(userId);
	}

	@Override
	public TokenEntity queryByToken(String token) {
		return tokenDao.queryByToken(token);
	}

	@Override
	public void save(TokenEntity token) {
		tokenDao.save(token);
	}

	@Override
	public void update(TokenEntity token) {
		tokenDao.update(token);
	}

	@Override
	public Map<String, Object> createToken(long userId) {
		// 生成一个token
		String token = UUID.randomUUID().toString();
		// 当前时间
		Date now = new Date();

		// 过期时间
		Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

		// 判断是否生成过token
		TokenEntity tokenEntity = queryByUserId(userId);
		if (tokenEntity == null) {
			tokenEntity = new TokenEntity();
			tokenEntity.setUserId(userId);
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			// 保存token
			save(tokenEntity);
		} else {
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			// 更新token
			update(tokenEntity);
		}

		Map<String, Object> map = new HashMap<>();
		map.put("token", token);
		map.put("expire", EXPIRE);

		return map;
	}

	/**
	 * @param token
	 * @return
	 * @see com.migo.service.TokenService#queryAppKey(java.lang.String)
	 */
	@Override
	@Deprecated
	public TokenEntity queryAppKey(String token) {
		// TODO Auto-generated method stub
		return new TokenEntity();
	}

	@Override
	public Boolean verifyToken(String token) {
		// TODO Auto-generated method stub

		// TODO 非对称加密或者使用jwt
		// orz 好困 22点34分

		return false;
	}
}
