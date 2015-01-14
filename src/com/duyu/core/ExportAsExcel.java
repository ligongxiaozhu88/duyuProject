package com.duyu.core;

import javax.servlet.http.HttpServlet;

public class ExportAsExcel extends HttpServlet {
	// public void doGet(HttpServletRequest request, HttpServletResponse
	// response)
	// throws IOException, ServletException {
	// HttpSession session = request.getSession(true);
	// String fileName = (String) session.getAttribute("fileName");//
	// 前台需要把这些参数写到session中。
	// String querySql = (String) session.getAttribute("querySql");
	// // session.removeAttribute("fileName");
	// // session.removeAttribute("querySql");
	// try {
	// WritableFont arial15font = new WritableFont(WritableFont.ARIAL, 15,
	// WritableFont.BOLD);
	// arial15font.setColour(jxl.format.Colour.LIGHT_BLUE);
	// WritableCellFormat arial15format = new WritableCellFormat(
	// arial15font);
	// arial15format.setAlignment(jxl.format.Alignment.CENTRE);
	// arial15format.setBorder(jxl.format.Border.ALL,
	// jxl.format.BorderLineStyle.THIN);
	// arial15format.setBackground(jxl.format.Colour.VERY_LIGHT_YELLOW);
	// File file = new File("output.xls");
	// WritableWorkbook workbook = Workbook.createWorkbook(file); // 建立工作簿
	// WritableSheet sheet = workbook.createSheet("Sheet 1", 0); // 建立sheet
	// sheet.addCell(new Label(0, 0, fileName, arial15format));
	// sheet.setName(fileName);
	// if (rs != null) {
	// WritableFont arial11font = new WritableFont(WritableFont.ARIAL,
	// 11, WritableFont.BOLD);
	// WritableCellFormat arial11format = new WritableCellFormat(
	// arial11font);
	// arial11format.setAlignment(jxl.format.Alignment.CENTRE);
	// arial11format.setBorder(jxl.format.Border.ALL,
	// jxl.format.BorderLineStyle.THIN);
	// arial11format.setBackground(jxl.format.Colour.RED);
	// int row = 0;
	// int col = 1;
	// // 写表头信息
	// ResultSetMetaData rsmd = rs.getMetaData();
	// int[] validColumn = new int[rsmd.getColumnCount()];
	// for (int i = 0; i < rsmd.getColumnCount(); i++) {
	// String colName = rsmd.getColumnName(i + 1);
	// if (colName.indexOf("NextIsURL") != -1) {
	// validColumn[i] = -1;
	// } else if (colName.indexOf("ThisIsCheckBox") != -1) {
	// validColumn[i] = -2;
	// } else {
	// sheet.addCell(new Label(row, col, colName,
	// arial11format));
	// validColumn[i] = getStrLen(colName) + 4;
	// // sheet.setColumnView(row, validColumn[i]);
	// row++;
	// }
	// }
	// col++;
	// if (row > 1) {
	// sheet.mergeCells(0, 0, row - 1, 0);
	// }
	// WritableFont arial9font = new WritableFont(WritableFont.ARIAL,
	// 9);
	// WritableCellFormat arial9format = new WritableCellFormat(
	// arial9font);
	// // arial9format.setAlignment(Alignment.CENTRE);
	// arial9format.setBorder(jxl.format.Border.ALL,
	// jxl.format.BorderLineStyle.THIN);
	// DateFormat dateFormat = new DateFormat("yyyy-MM-dd");
	// WritableCellFormat dateCellFormat = new WritableCellFormat(
	// arial9font, dateFormat);
	// // dateCellFormat.setAlignment(Alignment.CENTRE);
	// dateCellFormat.setBorder(jxl.format.Border.ALL,
	// jxl.format.BorderLineStyle.THIN);
	// DateFormat timeFormat = new DateFormat("hh:mm:ss");
	// WritableCellFormat timeCellFormat = new WritableCellFormat(
	// arial9font, timeFormat);
	// // timeCellFormat.setAlignment(Alignment.CENTRE);
	// timeCellFormat.setBorder(jxl.format.Border.ALL,
	// jxl.format.BorderLineStyle.THIN);
	// // 循环写所有记录
	// while (rs.next()) {
	// row = 0;
	// for (int i = 0; i < rsmd.getColumnCount(); i++) {
	// // 如果是链接列， 则不写入文件中
	// if (validColumn[i] == -1 || validColumn[i] == -2) {
	// continue;
	// }
	// // 读取每一列的类型
	// int columnType = rsmd.getColumnType(i + 1);
	// switch (columnType) {
	// case Types.BIT :
	// case Types.BIGINT :
	// case Types.BOOLEAN :
	// case Types.NUMERIC :
	// case Types.REAL :
	// case Types.SMALLINT :
	// case Types.TINYINT :
	// case Types.DECIMAL :
	// case Types.FLOAT :
	// case Types.INTEGER :
	// float number = rs.getFloat(i + 1);
	// sheet.addCell(new jxl.write.Number(row, col,
	// number, arial9format));
	// break;
	// case Types.DATE :
	// case Types.TIMESTAMP :
	// Date date = rs.getDate(i + 1);
	// if (date == null) {
	// sheet
	// .addCell(new jxl.write.Blank(row,
	// col));
	// } else {
	// sheet.addCell(new jxl.write.DateTime(row,
	// col, date, dateCellFormat));
	// }
	// break;
	// case Types.TIME :
	// Date time = rs.getDate(i + 1);
	// if (time == null) {
	// sheet
	// .addCell(new jxl.write.Blank(row,
	// col));
	// } else {
	// sheet.addCell(new jxl.write.DateTime(row,
	// col, time, timeCellFormat));
	// }
	// break;
	// default :
	// String str = rs.getString(i + 1);
	// if (str == null) {
	// sheet.addCell(new jxl.write.Blank(row, col,
	// arial9format));
	// } else {
	// str = str.trim();
	// sheet.addCell(new Label(row, col, str,
	// arial9format));
	// int len = getStrLen(str);
	// if (len > validColumn[i]) {
	// validColumn[i] = len;
	// }
	// }
	// break;
	// }
	// row++;
	// }
	// col++;
	// }
	// row = 0;
	// for (int i = 0; i < rsmd.getColumnCount(); i++) {
	// if (validColumn[i] > 0) {
	// sheet.setColumnView(row, validColumn[i]);
	// row++;
	// }
	// }
	// }
	// linker.closeConStmt();
	// workbook.write();
	// workbook.close();
	// response.setContentType("application/octet-stream");
	// fileName = new String(fileName.getBytes("gb2312"), "ISO8859_1");
	// response.setHeader("Content-Disposition", "attachment; filename=\""
	// + fileName + ".xls" + "\"");
	// int len = (int) file.length();
	// byte[] buf = new byte[len];
	// FileInputStream fis = new FileInputStream(file);
	// OutputStream out = response.getOutputStream();
	// len = fis.read(buf);
	// out.write(buf, 0, len);
	// out.flush();
	// fis.close();
	// file.delete();
	// } catch (Exception e) {
	// System.out.println("[Info: ] User canceled - " + e.getMessage());
	// }
	// }
	//
	// public int getStrLen(String str) {
	// if (str == null) {
	// return 0;
	// }
	// byte[] buf = str.getBytes();
	// return buf.length;
	// }
	//
	// public void doPost(HttpServletRequest request, HttpServletResponse
	// response)
	// throws IOException, ServletException {
	// doGet(request, response);
	// }
}
