package tell.server.hiberUtil;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * 
 * mysql������
 */
public class CustomMysqlDialect extends MySQL5InnoDBDialect {
    
	/*
	 * 
	 * Ĭ��ʹ��utf-8�ַ���
	 * @return utf-8��ʶ�ַ���
	 * @see org.hibernate.dialect.MySQL5InnoDBDialect#getTableTypeString()
	 */
	public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
