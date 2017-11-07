package com.imooc.util;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class JbdcUtilTest {

    @Test
    public void test() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }

}
