package com.example.springBootDemo.util.page;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页工具
 */
public class PageUtil {

	/**
	 * 生成分页查询条件
	 * @param pageSize
	 * @param pageNow
	 * @param totalCount
	 * @return
	 */
	public static Map<String,Integer> buildPage( Integer pageNow , Integer  pageSize){
		// 默认值
		Integer pageSizeDef = 10;
		
		Map<String,Integer> params = new HashMap<String,Integer>() ;
		
		if (pageSize == null) {
			params.put( "begin" , ( pageNow - 1 ) * pageSizeDef );
			params.put( "pageSize" , pageSizeDef);
		} else {
			params.put( "begin" , ( pageNow - 1 ) * pageSize );
			params.put( "pageSize" , pageSize);
		}
		
		return params ;
		
	}

	/**
	 * 计算分页数
	 * @param totalCount
	 * @param pageSize
	 * @return
	 */
	public static Integer calPageCount( Integer totalCount , Integer pageSize ){
		
		return ( totalCount % pageSize == 0) ? totalCount / pageSize : totalCount / pageSize + 1 ;
		
	}
	
	public static Map<String, Object> matainPageNow(Map<String, Object> paramMap) {
		if (!paramMap.containsKey("pageAction")) {
			return paramMap; 
		}
		Integer pageNow = Integer.valueOf(paramMap.get("pageNow").toString());
		Integer newPageNow = 1 ; 
		if (paramMap.get("pageAction").equals("pagepre")) {//前一页
			newPageNow = (pageNow - 1) <= 1 ? 1 : (pageNow - 1) ; 
		}else {//后一页
			newPageNow = pageNow + 1 ; 
		}
		paramMap.put("pageNow", newPageNow);
		return paramMap ; 
	}

}
