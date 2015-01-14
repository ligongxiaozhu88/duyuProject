package com.duyu.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OpenOfficeStart {
	private Process process=null;
	  /**
     * 实现开启soffice进程
     */
	public  void start(){
		 Runtime rn = Runtime.getRuntime();
         try {
             File file=new File("d:\\openoprenoffice.bat");
             if (false==file.exists()) {
                 System.out.println("。。。。。。。。。。");
                 FileWriter writer = new FileWriter("d:\\openoprenoffice.bat ");
                   writer.write("@echo   off ");
                   writer.write("\r\n ");
                   writer.write("D:");
                   writer.write("\r\n ");
                   //D:\\Program Files\\OpenOffice 4\\program： openoffice的安装路径路径
                   writer.write("cd D:\\Program Files\\OpenOffice 4\\program");
                   writer.write("\r\n ");
                   writer.write("soffice -headless -accept="+"socket,host=127.0.0.1,port=8100;urp;"+" -nofirststartwizard");
                   writer.write("\r\n ");
                   writer.write("@echo   on ");
                   writer.close();
           }
             process = rn.exec("cmd.exe /C d:\\openoprenoffice.bat");
           }
           catch (Exception e1) {
                  e1.printStackTrace();
           }
		
	}
	
    /**
     * 实现关闭soffice进程
     */
    public  void distory() {
        try {
            //显示进程
            process=Runtime.getRuntime().exec("tasklist");
            Scanner in=new Scanner(process.getInputStream());
            while (in.hasNextLine()) {
                String processString=in.nextLine();
                if (processString.contains("soffice.exe")) {
                    //关闭soffice进程的命令
                    String cmd="taskkill /f /im soffice.exe";
                    process=Runtime.getRuntime().exec(cmd);
                    System.out.println("openoffice正常关闭.......");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
}
