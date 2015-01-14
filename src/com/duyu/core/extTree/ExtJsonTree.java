package com.duyu.core.extTree;

public class ExtJsonTree {
	protected String id;
	protected String text;//节点显示内容
	protected String cls;
	protected String icon;
	protected String iconCls;
	protected String qtip;
	protected boolean leaf;
	protected String href;
	protected String hrefTarget;
	protected boolean expandable;//是否可展开
	public ExtJsonTree(String id, String text, String cls, String icon,
			String iconCls, String qtip, boolean leaf, String href,
			String hrefTarget, boolean expandable, boolean expanded, String desc) {
		this.id = id;
		this.text = text;
		this.cls = cls;
		this.icon = icon;
		this.iconCls = iconCls;
		this.qtip = qtip;
		this.leaf = leaf;
		this.href = href;
		this.hrefTarget = hrefTarget;
		this.expandable = expandable;
		this.expanded = expanded;
		this.desc = desc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getQtip() {
		return qtip;
	}
	public void setQtip(String qtip) {
		this.qtip = qtip;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getHrefTarget() {
		return hrefTarget;
	}
	public void setHrefTarget(String hrefTarget) {
		this.hrefTarget = hrefTarget;
	}
	public boolean isExpandable() {
		return expandable;
	}
	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	protected boolean expanded;
	protected String desc;
	
	

}
