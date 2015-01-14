package com.duyu.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
/** * 基本思路：得到html内容,因为是非标准的html内容，利用Jsoup组件将读取出来的内容转换为标准的html文件内容,
 * 然后遍历每个节点，找到img标签，记录其索引，再根据其文件名规则拼接出图片的物理路径，将其替换为${image_index}标识，而后将{索引，路径}
 * 以键值对的方式丰入Map中， 如
 * "${image_1,d:lucene.png}"格式，然后利用jacob组件打开template.doc,选中整篇文档并复制，而后新建一篇文档，粘贴刚复制的内
 * 容 查找图片标识位，将其替换为图片
 * 
 * @since 2011-12-09
 * @author xioawu
 * @cateogry topstar
 * @version 1.0
 */
public class TestJsoupComponent {
 private static Document document;
 private static Map<String, String> imgMap = new HashMap<String, String>(); //存放图片标识符及物理路径 i.e {"image_1","D:\lucene.png"};
 private static List<String> files = new ArrayList<String>(); //存入本地生成的各个文章doc的文件名
 private static Integer imgIndex = 1; //图片标识
 public static void main(String[] args) throws IOException {
  MSOfficeGeneratorUtils officeUtils = new MSOfficeGeneratorUtils(true); // 将生成过程设置为不可见
 
  String html = "<html>.....</html>";// 得到正文内容 , 此处自己填写html内容
  String header = "测试标题"; // 得到文章标题
  document = Jsoup.parse(html);
  // System.out.println(document.html());
  for (Element element : document.body().select("body > *"))
   // 递归遍历body下的所有直接子元素，找出img标签，@see SysElementText Method
   sysElementText(element);
  File file = new File("D:" + File.separator + "template.doc");
  file.createNewFile(); // 创建模板html
  FileWriter fw = new FileWriter(file);
  fw.write(document.html(), 0, document.html().length());// 写入文件
  fw.flush(); // 清空FileWriter缓冲区
  fw.close();
  officeUtils.openDocument("D:\template.doc"); // 打开template.doc .由trsserver eipdocument库中的dochtmlcon生成的template.doc文件
  officeUtils.copy(); // 拷贝整篇文档
  officeUtils.close();
  officeUtils.createNewDocument();
  officeUtils.paste(); // 粘贴整篇文档
  for (Entry<String, String> entry : imgMap.entrySet())   //循环将图片标识位替换成图片
   officeUtils.replaceText2Image(entry.getKey(), entry.getValue());
  officeUtils.moveStart(); // 将插入点移动至Word文档的最顶点
  officeUtils.setFont(true, false, false, "0,0,0", "20", "宋体"); // 设置字体,具体参数，自己看API
  officeUtils.setTitle(header, 1); // 设置标题
  officeUtils.enterDown(1); // 设置一行回车
  String filename = UUID.randomUUID().toString();
  files.add(filename); // 记录文件名，
  officeUtils.saveAs("D:" + File.separator + filename + ".doc"); // 生成D:\UUID.doc文件，利用UUID防止同名
  officeUtils.close(); // 关闭Office Word创建的文档
  officeUtils.quit(); // 退出Office Word程序
  MSOfficeGeneratorUtils msOfficeUtils = new MSOfficeGeneratorUtils(false); // 整合过程设置为可见
  msOfficeUtils.createNewDocument();
  msOfficeUtils.saveAs("D:" + File.separator + "complete.doc");
  msOfficeUtils.close();
  for (String fileName : files) {
   msOfficeUtils.openDocument("D:" + File.separator + fileName + ".doc");
   msOfficeUtils.copy();
   msOfficeUtils.close();
   msOfficeUtils.openDocument("D:" + File.separator + "complete.doc");
   msOfficeUtils.moveEnd();
   msOfficeUtils.enterDown(1);
   msOfficeUtils.paste();
   msOfficeUtils.saveAs("D:" + File.separator + "complete.doc");
   msOfficeUtils.close();
  }
  //复制一个内容比较少的*.doc文档，防止在关闭word程序时提示有大量的copy内容在内存中，是否应用于其它程序对话框,
  msOfficeUtils.createNewDocument();
  msOfficeUtils.insertText("测试消息");
  msOfficeUtils.copy();
  msOfficeUtils.close();
  msOfficeUtils.quit();
  imgIndex = 1;
  imgMap.clear();
 }
 public static void sysElementText(Node node) {
  if (node.childNodes().size() == 0) {
   if (node.nodeName().equals("img")) { // 处理图片路径问题
    node.after("<p>${image_" + imgIndex + "}</p>"); // 为img添加同级P标签，内容为<P>${image_imgIndexNumber}</P>
    String src = node.attr("src");
    node.remove(); // 删除Img标签。
//    StringBuffer imgUrl = new StringBuffer("D:\TRS\TRSWCMV65HBTCIS\WCMData\webpic\"); // 暂时将路径直接写死，正式应用上应将此处改写为WebPic的配置项
    StringBuffer imgUrl = new StringBuffer(""); // 暂时将路径直接写死，正式应用上应将此处改写为WebPic的配置项
//    imgUrl.append(src.substring(0, 8)).append("\").append(src.subSequence(0, 10)).append("\").append(src);
    // node.attr("src", imgUrl.toString()); //这一句没有必要，因为此img标签已经移除了
    imgMap.put("${image_" + imgIndex++ + "}", imgUrl.toString());
   }
  } else {
   for (Node rNode : node.childNodes()) {
    sysElementText(rNode);
   }
  }
 }
}