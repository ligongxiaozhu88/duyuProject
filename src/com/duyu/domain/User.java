package com.duyu.domain;

import java.sql.Timestamp;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String uid;
	private String username;
	private String upassword;
	private String comm;
	private Timestamp createDate;
	private Boolean sexId;
	private Boolean sfsc;
	private String scrId;
	private Timestamp scsj;
	private String scyy;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String uid) {
		this.uid = uid;
	}

	/** full constructor */
	public User(String uid, String username, String upassword, String comm,
			Timestamp createDate, Boolean sexId, Boolean sfsc, String scrId,
			Timestamp scsj, String scyy) {
		this.uid = uid;
		this.username = username;
		this.upassword = upassword;
		this.comm = comm;
		this.createDate = createDate;
		this.sexId = sexId;
		this.sfsc = sfsc;
		this.scrId = scrId;
		this.scsj = scsj;
		this.scyy = scyy;
	}

	// Property accessors

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUpassword() {
		return this.upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getComm() {
		return this.comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Boolean getSexId() {
		return this.sexId;
	}

	public void setSexId(Boolean sexId) {
		this.sexId = sexId;
	}

	public Boolean getSfsc() {
		return this.sfsc;
	}

	public void setSfsc(Boolean sfsc) {
		this.sfsc = sfsc;
	}

	public String getScrId() {
		return this.scrId;
	}

	public void setScrId(String scrId) {
		this.scrId = scrId;
	}

	public Timestamp getScsj() {
		return this.scsj;
	}

	public void setScsj(Timestamp scsj) {
		this.scsj = scsj;
	}

	public String getScyy() {
		return this.scyy;
	}

	public void setScyy(String scyy) {
		this.scyy = scyy;
	}

}