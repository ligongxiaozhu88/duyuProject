package com.duyu.domain;

import java.sql.Timestamp;

/**
 * Updatetableinfo entity. @author MyEclipse Persistence Tools
 */

public class Updatetableinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String updateTaskName;
	private Timestamp updateTaskTime;

	// Constructors

	/** default constructor */
	public Updatetableinfo() {
	}

	/** minimal constructor */
	public Updatetableinfo(String updateTaskName) {
		this.updateTaskName = updateTaskName;
	}

	/** full constructor */
	public Updatetableinfo(String updateTaskName, Timestamp updateTaskTime) {
		this.updateTaskName = updateTaskName;
		this.updateTaskTime = updateTaskTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUpdateTaskName() {
		return this.updateTaskName;
	}

	public void setUpdateTaskName(String updateTaskName) {
		this.updateTaskName = updateTaskName;
	}

	public Timestamp getUpdateTaskTime() {
		return this.updateTaskTime;
	}

	public void setUpdateTaskTime(Timestamp updateTaskTime) {
		this.updateTaskTime = updateTaskTime;
	}

}