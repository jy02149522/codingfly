package org.codingfly.routing;


import lombok.extern.slf4j.Slf4j;
import org.codingfly.routing.err.NodeServiceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class RouteServiceManage {


    /**
     * 路由表
     */
    private static Map<String, List<INodeService>> routeMapping;

    /**
     * 路由表初始化
     * @param routeMapping
     */
    public void initRouteMapping(Map<String, List<INodeService>> routeMapping) {
        this.routeMapping = routeMapping;
    }

    /**
     * 是否已经初始化
     * @return
     */
    public boolean isInit()
    {
        return routeMapping!=null && routeMapping.size() > 0;
    }

    /**
     * 执行路由处理
     * @param param 参数
     * @param type 类型
     */
    public static void execute(Object param, String type) {
        execute(param, type, RouteStrategyOnErr.NOTHING,null);
    }


    /**
     * 执行路由处理
     * @param param 参数
     * @param type 类型
     * @param map 执行过程参数
     */
    public static void execute(Object param, String type,HashMap<String,Object> map) {
        execute(param, type, RouteStrategyOnErr.NOTHING,map);
    }


    /**
     * 执行路由处理
     * @param param 参数
     * @param type 类型
     * @param strategy 异常时策略
     * @param map 执行过程参数
     * @return
     * @throws NodeServiceNotFoundException
     */
    public static boolean execute(Object param, String type, RouteStrategyOnErr strategy, HashMap<String,Object> map) throws NodeServiceNotFoundException {

        List<INodeService> nodeServices = routeMapping.get(type);

        if (null != nodeServices) {

            for (INodeService service : nodeServices) {

                log.debug("路由[" + type + ":" + service.getClass().getSimpleName() + "]>>>" + param.toString());

                service.process(param,map);

                log.debug("路由[" + type + ":" + service.getClass().getSimpleName() + "]<<<" + param.toString());

                if(map != null && map.containsKey(INodeService.RETURN))
                {
                    return false;
                }

            }

        } else {

            if (strategy == RouteStrategyOnErr.EXCEPTION) {

                throw new NodeServiceNotFoundException("无法找到[" + type + "]类型的节点");

            } else if (strategy == RouteStrategyOnErr.LOG) {

                log.error("无法找到[" + type + "]类型的节点");

            } else {
                // 不做任何处理
            }
        }

        return true;
    }
}
