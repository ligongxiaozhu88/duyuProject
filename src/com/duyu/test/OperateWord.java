package com.duyu.test;
import org.apache.commons.lang.StringUtils;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class OperateWord {
	
	//查询指定内容
	private static boolean find( ActiveXComponent app,Dispatch selection,String toFindText){
		if(StringUtils.isNotBlank(toFindText)){
			return false;
		}
		  // 从selection所在位置开始查询
		  Dispatch find = Dispatch.call(selection, "Find").toDispatch();
		  // 设置要查找的内容/>  
		  Dispatch.put(find, "Text", toFindText);
		  // 向前查找
		  Dispatch.put(find, "Forward", "True");
		  // 设置格式
		  Dispatch.put(find, "Format", "True");
		  // 大小写匹配
		  Dispatch.put(find, "MatchCase", "True");
		  // 全字匹配
		  Dispatch.put(find, "MatchWholeWord", "True");
		  // 查找并选中
		  return Dispatch.call(find, "Execute").getBoolean();
	}
	/**
	 * 替换指定内容的数据
	 * @param app
	 * @param selection
	 * @param toFindText
	 * @param replaceText
	 */
	private static void replaceText( ActiveXComponent app,Dispatch selection,String toFindText,String replaceText){
		//查找指定内容并选中
		boolean flag=find(app,selection,toFindText);
		if(flag){
			Dispatch.put(selection,"Text",replaceText );
			Dispatch.call(selection,"MoveRight");
		}
	}
	
	public static void  main(String args[]){
		Dispatch operateDoc=null;
		Dispatch templateDoc=null;
		//word运行程序对象
		ActiveXComponent word=null;
		try {
			//初始化com的线程
			ComThread.InitSTA();
			//word运行程序对象
			word = new ActiveXComponent("Word.Application");
			// 所有 Word 文档对象
			Dispatch documents =word.getProperty("Documents").toDispatch();
			//打开文档的路径
			String url="";
			//操作文档可以两种方式，一种是打开空白文档，一种是新建文档
			//创建文档
			operateDoc = Dispatch.call(documents, "Add").toDispatch();
			//打开一个空word文档
//			operateDoc=Dispatch.invoke(documents, "Open", Dispatch.Method, new Object[]{url,new Variant(false),new Variant(true),new Variant(false),new Variant("pwd")},new int[1]).toDispatch();
			
			//获得文档的插入点
			Dispatch selection=word.getProperty("Selection").toDispatch();
			
//			//获得替换章节号的模板文档
//			templateDoc=Dispatch.invoke(documents, "Open", Dispatch.Method, new Object[]{url,new Variant(false),new Variant(true),new Variant(false),new Variant("pwd")},new int[1]).toDispatch();
//			
//			//获得模板文档的所有段落
//			Dispatch templateParagraphs=Dispatch.get(templateDoc, "Paragraphs").toDispatch();
//			
//			//获得指定段落
//			Dispatch templateParagraph=Dispatch.call(templateParagraphs, "Item",new Variant(1)).toDispatch();
//			
//			//获得段落的域
//			Dispatch templageRange=Dispatch.get(templateParagraph, "Range").toDispatch();
//			
//			//取得当前文档的内容
//			Dispatch wordContent=Dispatch.get(operateDoc, "Content").toDispatch();
//			//在内容后插入指定文字
//			Dispatch.call(wordContent, "InterAfter","$selection$");
//			
//			//设置页面方向 1横向 0纵向
//			Dispatch pageSetup=Dispatch.get(operateDoc, "PageSetup").toDispatch();
//			Dispatch.put(pageSetup, "Orientation", new Variant(0));
//			
//			Dispatch.call(templageRange, "Copy");
//			//查找指定文字
//			boolean flag=find(word,selection,"$selection$");
//			if(flag){
//				//插入点的域
//				Dispatch textRange=Dispatch.get(selection, "Range").toDispatch();
//				//执行
//				Dispatch.call(textRange, "Paste");
//				String templateContent="$head$";
//				String section="1";
//				//替换内容
//				replaceText(word,selection,templateContent,section);
//			}
//			//插入点右移
//			Dispatch.call(selection,"MoveRight");
//			
//			//拼接文件
//			Dispatch.invoke(selection, "insertFile", Dispatch.Method,  new Object[]{url,new Variant(false),new Variant(false),new Variant(false),new Variant("false")},new int[3]).toDispatch();
//			
//			//将插入点移动到最后
//			Dispatch.call(selection, "EndKey",new Variant(6));
//			
//			//将插入点移动到最前
//			Dispatch.call(selection, "HomeKey",new Variant(6));
//			
//			
//			//获得文档的全部书签
//			Dispatch bookmarks =word.call(operateDoc, "BookMarks").toDispatch();
//			
//			//判断指定书签是否存在  "testmarks" 为需要判断的书签 "value" 为具体要替换的值
//			boolean isExist=word.call(bookmarks, "Exists","testmarks").toBoolean();
//			if(isExist){
//				//用数据替换书签
//				Dispatch rangeItem=operateDoc.call(bookmarks, "Item","testmarks").toDispatch();
//				Dispatch range =Dispatch.call(rangeItem, "Range").toDispatch();
//				operateDoc.put(range, "Text", new Variant("value"));
//			}
//			//图片路径
//			String imgUrl="";
//			//插入图片
//			Dispatch.call(selection, "TypeParagraph");
//			Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(), "AddPicture",imgUrl);
//			
//			//在指定书签处插入表
//			isExist=word.call(bookmarks, "Exists","testTable").toBoolean();
//			if(isExist){
//				Dispatch rangeItem=operateDoc.call(bookmarks, "Item","testTable").toDispatch();
//				Dispatch range =Dispatch.call(rangeItem, "Range").toDispatch();
//				//获取当前document对象中的所有表格对象
//				Dispatch tables=Dispatch.get(operateDoc, "Tables").toDispatch();
//				int row=6;//行
//				int col=6;//列
//				int border=1;//边框
//				//增加表
//				Dispatch table=Dispatch.call(tables, "Add",range,new Variant(row),new Variant(col),new Variant(border)).toDispatch();
//				
//				//表格增加行
//				Dispatch rows=Dispatch.get(table, "Rows").toDispatch();
//				Dispatch.call(rows, "Add");
//				//取表格的最后行
//				Dispatch lastRow=Dispatch.get(rows, "Last").toDispatch();
//				//在最后行加一行
//				Dispatch.call(rows, "Add",lastRow);
//				
//				//获得表格的cell 表格的行列都是从1 开始
//				int rowCell=1;//表格的行
//				int colCell=1;//表格的列
//				Dispatch cell=Dispatch.call(table, "Cell",new Variant(rowCell),new Variant(colCell)).toDispatch();
//				//选中表格
//				Dispatch.call(cell, "Select");
//				String content="序号";
//				//输入数据
//				Dispatch.put(selection, "Text",content);
//				//内容居中显示
//				Dispatch.put(cell, "VerticalAlignment", new Variant(1));
//				Dispatch lastCell=Dispatch.call(table, "Cell",new Variant(1),new Variant(6)).toDispatch();
//				
//				//合并单元格
//				Dispatch.call(cell,"Merge", lastCell);
//			}
//			//在指定书签处插入目录
//			isExist=word.call(bookmarks, "Exists","ml").toBoolean();
//			if(isExist){
//				Dispatch rangeItem=operateDoc.call(bookmarks, "Item","ml").toDispatch();
//				Dispatch range =Dispatch.call(rangeItem, "Range").toDispatch();
//				
//				//增加节次
//				Dispatch activeDocument =word.getProperty("ActiveDocument").toDispatch();
//				Dispatch tableDispatch=Dispatch.get(activeDocument, "TablesOfContents").toDispatch();
//				//new Variant(9)  目录的显示等级  最大是9
//				Dispatch.call(tableDispatch, "Add",new Variant(true),new Variant(1),new Variant(9),new Variant(true),new Variant(""),new Variant(true),new Variant(true));
//			}
			
			//获得窗体
			Dispatch activeWindow=Dispatch.get(operateDoc, "ActiveWindow").toDispatch();
			Dispatch view=Dispatch.get(activeWindow, "View").toDispatch();
			
			
			//设置页眉
			Dispatch.put(view,"SeekView",new Variant(9));
			String header="这是页眉";
			Dispatch.put(selection,"Text",new Variant(header));
			//设置页脚
			Dispatch.put(view,"SeekView",new Variant(10));
			final Dispatch secitons=Dispatch.get(operateDoc,"Sections").toDispatch();
			final Dispatch item =Dispatch.call(secitons, "Item",new Variant(1)).toDispatch();
			final Dispatch footer =Dispatch.get(item, "Footers").toDispatch();
			final Dispatch f1=Dispatch.call(footer,"Item",new Variant(1)).toDispatch();
			final Dispatch range=Dispatch.get(f1, "Range").toDispatch();
			final Dispatch fields=Dispatch.get(range, "fields").toDispatch();
			
			Dispatch paraFormat=Dispatch.get(selection, "ParagraphFormat").toDispatch();
			Dispatch.put(paraFormat, "Alignment", 1);
			Dispatch.call(fields, "Add",Dispatch.get(selection, "Range").toDispatch(),new Variant(-1),"Page",true);
			//设置字体
			Dispatch font =Dispatch.get(range, "Font").toDispatch();
			Dispatch.put(font, "Name", new Variant("宋体_GB2312"));
			Dispatch.put(font, "Size", 9);
//			
//			//获得文档的总页数
//			int pageNum=Integer.parseInt(Dispatch.call(selection, "Information",4).toString());
//			isExist=word.call(bookmarks, "Exists","zys").toBoolean();
//			if(isExist){
//				//用数据替换书签
//				Dispatch rangeItem=operateDoc.call(bookmarks, "Item","testmarks").toDispatch();
//				Dispatch zysrange =Dispatch.call(rangeItem, "Range").toDispatch();
//				operateDoc.put(zysrange, "Text", new Variant("这是总页数"+pageNum));
//			}
//			
//			Dispatch.put(operateDoc, "RemovePersonalInformation",false);
			String savepath="c:\newDocument.doc";
			//保存word
//			Dispatch.call(operateDoc.call(word, "WordBasic").getDispatch(),"SaveAs",savepath);
			 Dispatch.call(operateDoc, "SaveAs", savepath);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally{
			//关闭打开的文档
			if(operateDoc!=null){
				Dispatch.call(operateDoc, "Close", new Variant(0));
				operateDoc=null;
			}
			if(templateDoc!=null){
				Dispatch.call(templateDoc, "Close", new Variant(0));
				templateDoc=null;
			}
			//关闭应用
			if(word!=null){
				word.invoke("Quit",0);
			}
			//释放线程
			ComThread.Release();
		}
	}
}
