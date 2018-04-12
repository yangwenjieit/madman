package com.madman.common;

import java.io.Serializable;

/**
 * @描述：基础实体类，包含各实体公用属性 .
 * @作者：ywj
 * @版本：1.0
 * @创建时间：2018年4月12日 下午5:39:27
 */
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 主键ID **/
	protected String id = ToolSequenceNo.generateSequenceNo();
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
