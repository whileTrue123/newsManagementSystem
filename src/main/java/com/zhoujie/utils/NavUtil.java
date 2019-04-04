package com.zhoujie.utils;

public class NavUtil {

	public static String genNewsManageNavigation(String modName,String actionName){
		StringBuffer navCode=new StringBuffer();
		navCode.append("��ǰλ�ã�&nbsp;&nbsp;");
		navCode.append("��ҳ&nbsp;&nbsp;>&nbsp;&nbsp;");
		navCode.append(modName+"&nbsp;&nbsp;>&nbsp;&nbsp;");
		navCode.append(actionName+"&nbsp;&nbsp;");
		return navCode.toString();
	}
	
	public static String genNewsListNavigation(String typeName,String typeId){
		StringBuffer navCode=new StringBuffer();
		navCode.append("��ǰλ�ã�&nbsp;&nbsp;");
		navCode.append("<a href='index.action'>��ҳ</a>&nbsp;&nbsp;>&nbsp;&nbsp;");
		navCode.append("<a href='newsList.action?typeId="+typeId+"'>"+typeName+"</a>");
		return navCode.toString();
	}
	
	public static String genNewsNavigation(String typeName,String typeId,String newsName){
		StringBuffer navCode=new StringBuffer();
		navCode.append("��ǰλ�ã�&nbsp;&nbsp;");
		navCode.append("<a href='index.action'>��ҳ</a>&nbsp;&nbsp;>&nbsp;&nbsp;");
		navCode.append("<a href='newsList.action?typeId="+typeId+"'>"+typeName+"</a>&nbsp;&nbsp;>&nbsp;&nbsp;"+newsName);
		System.out.println(navCode);
		return navCode.toString();
	}
}
