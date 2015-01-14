package com.duyu.service.impl;

import java.io.FileOutputStream;


import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.duyu.dao.CommonDao;
import com.duyu.domain.User;
import com.duyu.service.LoginService;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
	@Resource
	private CommonDao commonDao;

	@Override
	public User loadinfo(String username, String password) throws Exception {
		String hql = "from User  user where  user.username=? and user.upassword=?";
		User user = (User) commonDao.uniqueResultHQL(hql, new Object[]{
				username, password});
		return user;
	}

	/**
	 * 加载用户信息
	 */
	public List<User> loadUserList() throws Exception {
		String hql = "from User  ui";
		List<User> userList = commonDao.findObjectsByQuery(hql, null,
				Integer.MAX_VALUE);
		return userList;
	}

	/**
	 * 导出excel
	 */
	public void exportAsExcel() throws Exception {
		String hql = "from User  ui";
		List<User> userList = commonDao.findObjectsByQuery(hql, null,
				Integer.MAX_VALUE);

		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("学生表一");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("ID");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("姓名");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("描述");
		cell.setCellStyle(style);

		for (int i = 0; i < userList.size(); i++) {
			row = sheet.createRow((int) i + 1);
			User user = (User) userList.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell((short) 0).setCellValue(user.getUid());
			row.createCell((short) 1).setCellValue(user.getUsername());
			row.createCell((short) 2).setCellValue(user.getComm());
		}
		// 第六步，将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream("E:/students.xls");
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
