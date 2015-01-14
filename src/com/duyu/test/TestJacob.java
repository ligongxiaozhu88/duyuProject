package com.duyu.test;

import com.jacob.activeX.ActiveXComponent;



import com.jacob.com.ComFailException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class TestJacob {
	public static boolean extractDoc(String inputFIle, String outputFile) {

		 ActiveXComponent app = null;
		 Dispatch doc = null;
		 try {
//		 ComThread.InitSTA();
		 app = new ActiveXComponent("Word.Application");
		 app.setProperty("Visible", false);
		 System.out.println(inputFIle);
		 Dispatch docs = app.getProperty("Documents").toDispatch();
		 doc = Dispatch.invoke(docs, "Open", Dispatch.Method,
		 new Object[] { inputFIle,
		 new Variant(false),
		 new Variant(true),//是否只读
		 new Variant(false),
		 new Variant("pwd") },
		 new int[1]).toDispatch();
		 if(doc!=null){
			 System.out.println("doc is not null");
		 }
		 // Dispatch.put(doc, "Compatibility", false); //兼容性检查,为特定值false不正确
		 Dispatch.put(doc, "RemovePersonalInformation", false);
		 
//		 Dispatch.call(doc, "ExportAsFixedFormat", outputFile, 17); //
//		 word保存为pdf格式宏，值为17
			  
		 return true; // set flag true;
		 } catch (ComFailException e) {
		 e.printStackTrace();
		 return false;
		 } catch (Exception e) {
		 e.printStackTrace();
		 return false;
		 } finally {
		 if (doc != null) {
		 Dispatch.call(doc, "Close", false);
		 }
		 if (app != null) {
		 app.invoke("Quit", 0);
		 }
//		 ComThread.Release();
		 }


	}

	public static void main(String[] args) {
		TestJacob.extractDoc("e:/test aa/aaa.doc", "e:/aaa.pdf");
	}

}
