package tell.server.hiberUtil;

import java.text.SimpleDateFormat;   
import java.util.Date;   
import java.util.Locale;   
  
import net.sf.json.JsonConfig;   
import net.sf.json.processors.JsonValueProcessor;   
 
/**
 * 
 * 日期转化类
 */
public class JsonDateValueProcessor implements JsonValueProcessor {   
  
    private String format ="yyyy年MM月dd日 HH:mm";   

    /*
     * 
     * 过程化集合对象
     * @param value
     * @param config
     * @return Object对象
     * @see net.sf.json.processors.JsonValueProcessor#processArrayValue(java.lang.Object, net.sf.json.JsonConfig)
     */
    public Object processArrayValue(Object value, JsonConfig config) {   
        return process(value);   
    }   
  
    /*
     * 
     * 过程化对象
     * @param key
     * @param value
     * @param config
     * @return Object对象
     * @see net.sf.json.processors.JsonValueProcessor#processObjectValue(java.lang.String, java.lang.Object, net.sf.json.JsonConfig)
     */
    public Object processObjectValue(String key, Object value, JsonConfig config) {   
        return process(value);   
    }   
       
    /**
     * 
     * 将object转化为指定类型
     * @param value
     * @return object对象
     */
    private Object process(Object value){   
           
        if(value instanceof Date){   
            SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.UK);   
            return sdf.format(value);   
        }   
        return value == null ? "" : value.toString();   
    }   
}