package tell.server.hiberUtil;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * 
 * mysql方言类
 */
public class CustomMysqlDialect extends MySQL5InnoDBDialect {
    
	/*
	 * 
	 * 默认使用utf-8字符集
	 * @return utf-8标识字符串
	 * @see org.hibernate.dialect.MySQL5InnoDBDialect#getTableTypeString()
	 */
	public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
