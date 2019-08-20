package org.codingfly.routing.anno;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface RouteNode {

    /**
     * 节点类型
     * @return
     */
    String[] nodeType() default {};

    /**
     * 是否开启
     * @return
     */
    boolean enable() default true;

    /**
     * 排序
     * @return
     */
    int sort() default 0;

    /**
     * 全局前缀
     * @return
     */
    String prefix() default "";
}
