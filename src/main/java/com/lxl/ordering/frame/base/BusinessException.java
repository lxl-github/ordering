package com.lxl.ordering.frame.base;

/**
 * <p>
 * 业务异常基类
 * </p>
 * 
 * 
 * @since 1.0
 * @version 1.0
 */
public class BusinessException extends BaseException {


	private static final long serialVersionUID = -4374206156892558120L;


	private Integer code = -1;

	/**
	 * 构造器
	 */
	public BusinessException() {
		super();
	}

	/**
	 * 构造器
	 * 
	 * @param message
	 *            异常详细信息
	 * @param cause
	 *            异常原因
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 构造器
	 * 
	 * @param message
	 *            异常详细信息
	 */
	public BusinessException(String message) {
		super(message);
	}

	/**
	 * 构造器
	 * 
	 * @param code
	 *            错误码(标识前台错误信息显示位置)
	 * @param message
	 *            错误信息
	 */
	public BusinessException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	/**
	 * 构造器
	 * 
	 * @param cause
	 *            异常原因
	 */
	public BusinessException(Throwable cause) {
		super(cause);
	}

	public Integer getCode() {
		return this.code;
	}

}
