package org.codingfly.routing.event;


import lombok.extern.slf4j.Slf4j;
import org.codingfly.routing.INodeService;
import org.codingfly.routing.RouteServiceManage;
import org.codingfly.routing.anno.RouteNode;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.*;

/**
 * 当Spring完成加载后执行
 */
@Slf4j
public class RouteNodeListener implements ApplicationListener<ContextRefreshedEvent> {



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        // 防止重复执行
        if(event.getApplicationContext().getParent() == null)
        {
            log.debug("BEGIN -> 注册NodeService");
            RouteServiceManage routeServiceMange = (RouteServiceManage) event.getApplicationContext().getBean("routeServiceManage");

            if (routeServiceMange.isInit()) {

                Map<String, List<INodeService>> routeMapping = new HashMap<>();
                Map<String, Object> beans = event.getApplicationContext().getBeansWithAnnotation(RouteNode.class);

                // 生成routeMapping
                for (Object bean : beans.values()) {

                    RouteNode _routeNode = bean.getClass().getAnnotation(RouteNode.class);
                    if (_routeNode.enable()) {
                        String[] types = _routeNode.nodeType();
                        for (String type : types) {
                            String _preType = _routeNode.prefix().equals("") ? type : (_routeNode.prefix() + "-" + type);
                            if (routeMapping.containsKey(_preType)) {
                                routeMapping.get(_preType).add((INodeService) bean);
                            } else {
                                List<INodeService> nodes = new ArrayList<INodeService>();
                                nodes.add((INodeService) bean);
                                routeMapping.put(_preType, nodes);

                            }
                            log.debug("NodeService -> " + bean.getClass().getName() + ":" + _preType);
                        }
                    }
                }

                // 排序
                routeMapping.keySet().forEach(s -> {
                    Collections.sort(routeMapping.get(s));
                });


                // 初始化完成
                routeServiceMange.initRouteMapping(routeMapping);
            }
            log.debug("END -> 注册NodeService");
        }



    }
}