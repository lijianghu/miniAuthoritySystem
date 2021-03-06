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

package com.migo.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 定时执行日志
 *
 * @author 知秋
 * @email fei6751803@163.com
 */
@Data
public class ScheduleJobLogEntity implements Serializable {
  private static final long serialVersionUID = -7250952299313486171L;

  /**
   * 日志id
   */
  private Long logId;

  /**
   * 任务id
   */
  private Long jobId;

  /**
   * spring bean名称
   */
  private String beanName;

  /**
   * 方法名
   */
  private String methodName;

  /**
   * 参数
   */
  private String params;

  /**
   * 任务状态 0：成功 1：失败
   */
  private Integer status;

  /**
   * 失败信息
   */
  private String error;

  /**
   * 耗时(单位：毫秒)
   */
  private Integer times;

  /**
   * 创建时间
   */
  private Date createTime;
}
