package test;

import cn.booksp.sharebook.util.JdbcUtil;
import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Connection;

public class mysqlTest {

    @Test
    public void testConn(){
        Connection conn = JdbcUtil.getDBConn();
        try{
            TestCase.assertNotNull(conn);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
