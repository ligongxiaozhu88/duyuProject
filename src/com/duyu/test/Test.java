package com.duyu.test;

import java.awt.image.BufferedImage;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.Page;
import org.icepdf.core.util.GraphicsRenderingHints;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

public class Test {
	public Test(String s) {
		System.out.println("1");
	}
	public Test() {
		System.out.println("2");
	}
	
	public static void main(String argsp[]) throws Exception {
//		OpenOfficeStart handleOfficeStart=new OpenOfficeStart();
//		handleOfficeStart.start();
//		 File testFile = new File("e:\\aaa.doc");
//		 File resultFile = convertTo(testFile,"pdf");
//		 Test.pdf2Imgs(resultFile.getPath(),"");
//		 File resultHtmlFile = convertTo(testFile,"html");
//		 File resultFile = convertTo(testFile,"pdf");
//		 handleOfficeStart.distory();
//		File test1File = new File("e:\\excel.xls");
		 
//		File result1HtmlFile = convertTo(test1File, "html");
		System.out.println(1);

	}

	public static List<String> pdf2Imgs(String pdfPath, String imgDirPath)
			throws Exception {
//		pdfPath = "e:\\open_office.pdf";
		imgDirPath = "e:\\";
		Document document = new Document();
		document.setFile(pdfPath);

		float scale = 5f;// 放大倍数
		float rotation = 0f;// 旋转度数

		List<String> imgNames = new ArrayList<String>();
		int pageNum = document.getNumberOfPages();
		File imgDir = new File(imgDirPath);
		if (!imgDir.exists()) {
			imgDir.mkdirs();
		}
		for (int i = 0; i < pageNum; i++) {
			BufferedImage image = (BufferedImage) document.getPageImage(i,
					GraphicsRenderingHints.SCREEN, Page.BOUNDARY_CROPBOX,
					rotation, scale);
			RenderedImage rendImage = image;
			try {
				String filePath = imgDirPath + File.separator + i + ".jpg";
				File file = new File(filePath);
				ImageIO.write(rendImage, "jpg", file);
				imgNames.add(FilenameUtils.getName(filePath));
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			image.flush();
		}
		document.dispose();
		return imgNames;
	}
	private static File convertTo(File file, String type) {
		File nowFile = file;
		String fileName = nowFile.getName();
		int i = fileName.indexOf(".");
		int leg = fileName.length();
		// 获得传入文件的后缀名
		String exName = (i > 0 ? (i + 1) == leg ? "" : fileName.substring(i,
				fileName.length()) : "");
		// 建立一个临时文件,用来保存目标文件;文件的名称和传进来的一样,类型为传入的类型
		File toFile = new File(nowFile.getPath().replace(exName, "." + type));
		try {
			// 连接openoffice 8100
			// 端口和上面在DOS中启动服务设置的端口一致,这里还可以将openoffice放在别的机器上,通过IP和端口来连接,如果不填IP,则默认是localhost:
			// new SocketOpenOfficeConnection("192.168.0.120", 8100);
			OpenOfficeConnection connection = new SocketOpenOfficeConnection(
					"127.0.0.1", 8100);
			connection.connect();
			DocumentConverter converter = new OpenOfficeDocumentConverter(
					connection);
			// 转换,传入源文件和目标文件;
			converter.convert(nowFile, toFile);
			// 当openoffice服务是在远程机器上的时候要注意的是:nowFile必须在本地和远程都存在;不然会报错,原因未知;但转换后的内容则是按远程机器上的内容来的;被转换后的文件保存在远程服务器上;
			connection.disconnect();
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		// 返回目标文件
		return toFile;
	}
	public String toString(){
		System.out.println("fu");
		return null;
	}

}
