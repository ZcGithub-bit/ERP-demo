package com.example.springBootDemo.retcode;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class RetCode {
	
	private static final Logger logger = LoggerFactory.getLogger(RetCode.class) ;
	
	public final static String KEY_RET_CODE = "code" ;
	public final static String KEY_CODE_MSG = "codeMsg";
	
	private final static Map<String,String> unmodifiableMsgs ;
	
	@RetCodeElement(value="成功") 
	public final static String SUCCESS = "0" ; 
	
	@RetCodeElement(value="系统异常") 
	public final static String SYSTEM_ERROR = "99" ; 
	
	@RetCodeElement(value="")
	public static final Login LOGIN = new Login();
	
	
	static {
		
		Map<String,String> msgs = new HashMap<String,String>() ;
		 
		loadRetCode(RetCode.class,msgs,null) ;
		
		unmodifiableMsgs = java.util.Collections.unmodifiableMap( msgs ) ;
		
	}
	
	private static void loadRetCode(Class<?> clazz , Map<String,String> msgs , Object obj){
		System.out.println("loading ... ");
		Field[] fields = clazz.getDeclaredFields() ;
		for(Field field : fields){
			boolean isStatic = Modifier.isStatic(field.getModifiers()) ;
			if(String.class.equals(field.getType())){
				RetCodeElement element = field.getAnnotation(RetCodeElement.class) ;
				if(element != null){
					System.out.println(field.getName() + " : " + element.value());
					try {
						if(isStatic){
							msgs.put((String)field.get(clazz), element.value()) ;
						}else{
							msgs.put((String)field.get(obj), element.value()) ;
						}
						
					}catch (Exception e) {
						logger.error("RetCode 加载失败",e);
					}
				}
			}else{
				RetCodeElement element = field.getAnnotation(RetCodeElement.class) ;
				if(element != null){
					try {
						if(isStatic){
							loadRetCode(field.getType() , msgs ,field.get(field.getType())) ;
						}else{
							loadRetCode(field.getType() , msgs ,field.get(obj)) ;
						}
					}catch (Exception e) {
						logger.error("RetCode 加载失败",e);
					}
					
				}
			}
			
			
		}
		java.util.Collections.unmodifiableMap( msgs ) ;
	}
	
	public static void main(String[] args) {
		Map<String,Object> success = RetCode.buildRetCodeResult(RetCode.SUCCESS) ;
		System.out.println(success);
	}

	
	
	/**
	 * 根据code 返回对应描述
	 * @param code
	 * @return
	 */
	public final static String RET_CODE_MSG( String code ){
		
		return unmodifiableMsgs.get( code ) ;
		
	}
	
	/**
	 * 生成结果返回MAP
	 * @param code
	 * @return
	 */
	public static Map<String,Object> buildRetCodeResult( String code ){
		Map<String,Object> rst = new HashMap<String,Object>() ;
		rst.put( KEY_RET_CODE , code ) ;
		rst.put( KEY_CODE_MSG , RET_CODE_MSG( code )) ;
		return rst ;
	}
	
	
}
