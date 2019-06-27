package org.frameworkset.spi.remote.http.proxy.route;
/**
 * Copyright 2008 biaoping.yin
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import org.frameworkset.spi.remote.http.HttpHost;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p></p>
 * <p>Copyright (c) 2018</p>
 * @Date 2019/6/25 16:02
 * @author biaoping.yin
 * @version 1.0
 */
public class RoutingFilter {
	private Map<String,RoutingGroup> routingGroupMap = new HashMap<String, RoutingGroup>();
	public static boolean access(String[] accessRoutings, HttpHost httpHost){
		if(accessRoutings == null || accessRoutings.length == 0)
			return  true;
		String accessRouting = httpHost.getRouting();
		if(accessRouting == null){
			return true;
		}
		for(int i = 0; i < accessRoutings.length; i ++){
			if(accessRouting.equals(accessRoutings[i])){
				return true;
			}
		}
		return false;
	}
	public RoutingGroup getRoutingGroup(String routing){
		return routingGroupMap.get(routing);
	}
}
