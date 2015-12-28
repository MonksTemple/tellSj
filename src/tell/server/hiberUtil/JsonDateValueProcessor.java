package tell.server.hiberUtil;

import java.text.SimpleDateFormat;   
import java.util.Date;   
import java.util.Locale;   
  
import net.sf.json.JsonConfig;   
import net.sf.json.processors.JsonValueProcessor;   
 
/**
 * 
 * ����ת����
 */
public class JsonDateValueProcessor implements JsonValueProcessor {   
  
    private String format ="yyyy��MM��dd�� HH:mm";   

    /*
     * 
     * ���̻����϶���
     * @param value
     * @param config
     * @return Object����
     * @see net.sf.json.processors.JsonValueProcessor#processArrayValue(java.lang.Object, net.sf.json.JsonConfig)
     */
    public Object processArrayValue(Object value, JsonConfig config) {   
        return process(value);   
    }   
  
    /*
     * 
     * ���̻�����
     * @param key
     * @param value
     * @param config
     * @return Object����
     * @see net.sf.json.processors.JsonValueProcessor#processObjectValue(java.lang.String, java.lang.Object, net.sf.json.JsonConfig)
     */
    public Object processObjectValue(String key, Object value, JsonConfig config) {   
        return process(value);   
    }   
       
    /**
     * 
     * ��objectת��Ϊָ������
     * @param value
     * @return object����
     */
    private Object process(Object value){   
           
        if(value instanceof Date){   
            SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.UK);   
            return sdf.format(value);   
        }   
        return value == null ? "" : value.toString();   
    }   
}