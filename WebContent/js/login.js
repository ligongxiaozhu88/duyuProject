Ext.namespace("pro.index")
pro.index.init = function() {
	debugger
	var form = new Ext.form.Panel({
		// layout : 'form',
//		width : 800,
		height : 130,
		layout: {
            type: 'border'
        },
		items : [{
					region : 'center',
					items : [{
								xtype : 'textfield',
								fieldLabel : '用户',
								name : 'username',
								cls : Ext.isChrome ? '' : 'user',
								width : 240,
								allowBlank : false,
								blankText : '用户名不能为空'
							}, {
								id : 'password',
								xtype : 'textfield',
								inputType : 'password',
								cls : Ext.isChrome ? '' : 'key',
								fieldLabel : '密码',
								name : 'password',
								width : 240,
								allowBlank : false,
								blankText : '密码不能为空'
							}]
				}],
		buttons : [{
					type : 'submit',
					text : '提交',
					handler : function() {
						var form = this.up('form').getForm();
						if (form.isValid()) {
							form.submit({
										url : 'login.action',
										method : 'post',
										success : function(form, action) {
											if (action.result.success) {
												document.location = "index.action";
											}
										},
										failure : function(form, action) {
											Ext.getCmp("password")
													.markInvalid("密码不对");
										}
									});
						}
					}
				}, {
					text : '重置',
					handler : function() {
						this.up('form').getForm().reset();
					}
				}]

			// items : [{
			// region : 'center',
			// layout : 'fit',
			// items : [{
			// layout : 'column',
			// items : [{
			// columnWidth : .45,
			// html : '<img src="images/login/login.jpg"/>'
			// }, {
			// columnWidth : .50,
			// bodyStyle : Ext.isIE
			// ? 'padding-left:5px;padding-top:15px;'
			// : 'padding-left:5px;padding-top:0px;',
			// labelPad : 0,
			// labelWidth : 45,
			// items : [{
			// xtype : 'textfield',
			// bodyStyle : 'padding-top:30px',
			// baseCls : 'x-fieldset',
			// width : 200,
			// height : 'auto',
			//								
			// //this point
			//								
			// }]
			// }]
			// }]
			// }]
	});
	var panel = new Ext.Panel({
				el : 'index-div',
				title : '登录',
				layout : 'fit',
				width : 350,
				autoHeight : true,
				items : form
			});
	panel.render();
	panel.doLayout();

}
Ext.onReady(pro.index.init);