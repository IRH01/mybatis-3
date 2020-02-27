package com.irh.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description 业务描叙信息
 *
 * @author Created by Iritchie.ren on 2019/7/23.
 */
public class ExampleTest {

    @Test
    public void testFactory() throws IOException {
        String resource = "resources/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Demo demo = sqlSession.selectOne("com.irh.demo.DemoMapper.selectOne", 1L);
        System.err.println("第一个结果：" + demo.getName());
        //
        DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);
        Demo demo2 = mapper.selectOne(1L);
        System.err.println("第二个结果：" + demo2.getName());
    }
}
