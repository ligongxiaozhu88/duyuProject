package com.duyu.test;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class SetHeaderFooter {
//	public String execute(){
//		openWord(false); //初始化word文档
//		createNewDocument(); //创建Word文档
//		insertText(content1+content2); //插入文本内容及页眉页脚
//		saveWordFile(fileName); //保存Word文档到指定的目录(包括文件名)
//		return SUCCESS;
//	 }
//	 
//	 /**
//	  * 初始化word文档
//	  * openWord
//	  * @param makeVisible
//	  * @author tf.li
//	  * @data Dec 11, 2010
//	  */
//	 public void openWord(boolean makeVisible) {
//	   //Open Word if we/'ve not done it already 
//	   if (MsWordApp == null) { 
//		   MsWordApp = new ActiveXComponent("Word.Application"); 
//	   } 
//	   //Set the visible property as required. 
//	   Dispatch.put(MsWordApp, "Visible", new Variant(makeVisible)); 
//	 }
//	 
//	 /**
//	  * 创建Word文档
//	  * createNewDocument
//	  * @author tf.li
//	  * @data Dec 11, 2010
//	  */
//	 public void createNewDocument() {
//	   //Find the Documents collection object maintained by Word 
//	   Dispatch documents = Dispatch.get(MsWordApp,"Documents").toDispatch(); 
//	   //Call the Add method of the Documents collection to create 
//	   //a new document to edit 
//	   document = Dispatch.call(documents,"Add").toDispatch(); 
//	 }
//	 
//	 /**
//	  * 插入文本内容及页眉页脚
//	  * insertText
//	  * @param textToInsert
//	  * @author tf.li
//	  * @data Dec 11, 2010
//	  */
//	 public void insertText(String textToInsert) { 
//		 // Get the current selection within Word at the moment. If 
//		 // a new document has just been created then this will be at 
//		 // the top of the new doc 
//		 Dispatch selection = Dispatch.get(MsWordApp,"Selection").toDispatch(); 
//		 //Put the specified text at the insertion point 
//		 Dispatch.put(selection,"Text",textToInsert); //插入内容
//	   
//		 /****插入页眉页脚*****/
//		 //取得活动窗体对象 
//		 Dispatch ActiveWindow = MsWordApp.getProperty( "ActiveWindow").toDispatch(); 
//		 //取得活动窗格对象 
//		 Dispatch ActivePane = Dispatch.get(ActiveWindow, "ActivePane").toDispatch(); 
//		 //取得视窗对象 
//		 Dispatch View = Dispatch.get(ActivePane, "View").toDispatch(); 
//		 
//		 /****设置页眉*****/
//		 Dispatch.put(View, "SeekView", "9");
//		 Dispatch.put(selection, "Text", ym);
//
//		 /****设置页脚，动态插入页码*****/
//		 Dispatch.put(View, "SeekView", "10");
//		 
//		 final Dispatch Sections = Dispatch.get(document, "Sections").toDispatch();   
//		 final Dispatch item = Dispatch.call(Sections, "Item", new Variant(1)).toDispatch();   
//		 final Dispatch footer = Dispatch.get(item, "Footers").toDispatch();   
//		 final Dispatch f1 = Dispatch.call(footer, "Item", new Variant(1)).toDispatch();   
//		 final Dispatch range = Dispatch.get(f1, "Range").toDispatch();   
//		 final Dispatch fields = Dispatch.get(range, "Fields").toDispatch();
//		 
//		 Dispatch paragraphFormat=(Dispatch) Dispatch.get(selection,"ParagraphFormat").getDispatch(); 
//		 Dispatch.put(paragraphFormat, "Alignment", 1);		 Dispatch.call(fields, "Add", Dispatch.get(selection, "Range").toDispatch(), new Variant(-1), "Page", true).toDispatch();
//		 Dispatch.call(selection, "TypeText", "/");
//		 Dispatch.call(fields, "Add", Dispatch.get(selection, "Range").toDispatch(), new Variant(-1), "NumPages",true).toDispatch();
//		 Dispatch font = Dispatch.get(range, "Font").toDispatch();
//		 Dispatch.put(font,"Name",new Variant("宋体_GB2312"));
//		 //Dispatch.put(font, "Bold", new Variant(true));
//		 Dispatch.put(font, "Size", 9);
//	 }
//	 
//	 /**
//	  * 保存Word文档到指定的目录(包括文件名)
//	  * saveWordFile
//	  * @param filePath
//	  * @author tf.li
//	  * @data Dec 11, 2010
//	  */
//	 public void saveWordFile(final String filePath) {
//	    //保存文件 
//        Dispatch.invoke(document, "SaveAs", Dispatch.Method, new Object[] {filePath, new Variant(0)}, new int[1]); 
//        //作为word格式保存到目标文件 
//        Variant f = new Variant(false); 
//        Dispatch.call(document, "Close", f);
//        ComThread.Release();//释放com线程。根据jacob的帮助文档，com的线程回收不由java的垃圾回收器处理
//        MsWordApp.invoke("Quit", new Variant[0]);
//	 }
}
