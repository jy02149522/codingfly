package org.codingfly.routing.err;

/**
 * 节点未找到异常
 */
public class NodeServiceNotFoundException extends RuntimeException{

    public NodeServiceNotFoundException(String err)
    {
        super(err);
    }

}
