package org.codingfly.routing;

import org.codingfly.routing.anno.RouteNode;

import java.util.HashMap;

/**
 * 路由节点服务
 * @param <P> 参数对象
 */
public abstract class INodeService <P> implements Comparable<P> {


    /**
     * 返回标记
     */
    public static final String RETURN = "RETURN";

    /**
     * 处理方法
     * @param param 参数对象
     * @param obj map列表,过程传递,其中关键字如果带有RETURN表示优雅退出路由
     */
    abstract void process(P param,HashMap<String,Object> obj);

    /**
     * 比较排序
     * @param target 目标对象
     * @return
     */
    @Override
    public int compareTo(P target) {
        int _seft = this.getClass().getAnnotation(RouteNode.class).sort();
        int _target = target.getClass().getAnnotation(RouteNode.class).sort();
        return Integer.compare(_seft,_target);
    }
}
