Ext.namespace("pro.bussiness.home")
pro.bussiness.home.init = function() {
//	var panel = new Ext.panel.Panel({
//			autoEl : 'table-div',
//			title : '111',
//			width : 150
////			,
////			items : form
//		})
//	panel.render();
//	panel.doLayout();
	Ext.create('Ext.panel.Panel', {
    title: 'Hello',
    width: 200,
    html: '<p>World!</p>' ,
    renderTo:  'table-div'
});
}
Ext.onReady(pro.bussiness.home.init);