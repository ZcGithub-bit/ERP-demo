package com.example.springBootDemo.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 实体类共通工具
 * @author zhen.cheng
 *
 */
public class BeanUtil {

	private final static String GET = "get" ;

	/**
	 * 将object转换为map
	 * @param bean
	 * @param fields
	 * @return
	 */
	public static Map<String,Object> toMap( Object bean , String ... fields ){

		new  HashMap<>();

		Map<String,Object> map = new HashMap<String,Object>() ;
		
		Field[] fs = bean.getClass().getDeclaredFields() ;
		
		for( Field f : fs ){
			
			String getterName = GET + f.getName().substring( 0,1 ).toUpperCase() + f.getName().substring( 1 ) ;
			
			try {
				Method getter = bean.getClass().getDeclaredMethod( getterName ) ;
				map.put( f.getName() , getter.invoke( bean ) ) ;
			} catch ( Exception e ) {
				continue ;
			} 
			
		}
		
		fs = bean.getClass().getSuperclass().getFields() ;
		
		for( Field f : fs ){
			
			String getterName = GET + f.getName().substring( 0,1 ).toUpperCase() + f.getName().substring( 1 ) ;
			
			try {
				Method getter = bean.getClass().getDeclaredMethod( getterName ) ;
				map.put( f.getName() , getter.invoke( bean ) ) ;
			} catch ( Exception e ) {
				continue ;
			} 
			
		}
		
		return map ;

	}
	
	/**
	 * 将object转换为map
	 * @param bean
	 * @param fields
	 * @return
	 */
	public static Map<String,Object> toMapWithSuperClass( Object bean , String ... fields ){
		
		Map<String,Object> map = new HashMap<String,Object>() ;

		Field[] fs = bean.getClass().getSuperclass().getDeclaredFields() ;
		
		for( Field f : fs ){
			
			String getterName = GET + f.getName().substring( 0,1 ).toUpperCase() + f.getName().substring( 1 ) ;
			
			try {
				Method getter = bean.getClass().getSuperclass().getDeclaredMethod( getterName ) ;
				map.put( f.getName() , getter.invoke( bean ) ) ;
			} catch ( Exception e ) {
				continue ;
			} 
				
		}
		
		fs = bean.getClass().getDeclaredFields() ;
		
		for( Field f : fs ){
			
			String getterName = GET + f.getName().substring( 0,1 ).toUpperCase() + f.getName().substring( 1 ) ;
			
			try {
				Method getter = bean.getClass().getDeclaredMethod( getterName ) ;
				map.put( f.getName() , getter.invoke( bean ) ) ;
			} catch ( Exception e ) {
				continue ;
			} 
			
		}
		
		return map ;
		
	}
	
	public static Map<String,Object> getOrderModel(HttpServletRequest request) {
		Map<String,Object> bm = new HashMap<String,Object>();
		Map<String, String[]> tmp = request.getParameterMap();
		if (tmp != null) {
			for (String key : tmp.keySet()) {
				String[] values = tmp.get(key);
				bm.put(key, values.length == 1 ? values[0].trim() : values);
			}
		}
		return bm;
	} 
}
