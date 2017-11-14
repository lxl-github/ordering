package com.lxl.ordering.frame.base;

/**
 * <p>功能描述信息</p>
 * <p/>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lixiaoliang
 * @version 1.0
 * @date 2017/8/15
 * @since 1.0
 */
public class BaseException extends RuntimeException{

    private static final long serialVersionUID = -2066342217068227211L;

    /**
     * 构造器
     *
     */
    public BaseException() {
        super();
    }

    /**
     * 构造器
     *
     * @param message	异常详细信息
     * @param cause	异常原因
     */
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造器
     *
     * @param message	异常详细信息
     */
    public BaseException(String message) {
        super(message);
    }

    /**
     * 构造器
     *
     * @param cause	异常原因
     */
    public BaseException(Throwable cause) {
        super(cause);
    }
}
