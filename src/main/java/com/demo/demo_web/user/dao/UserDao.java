package com.demo.demo_web.user.dao;
import java.util.List;

import com.demo.common.entity.SearchCriteria;
import com.demo.demo_web.user.entity.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    @Qualifier("userSqlSession")
    SqlSessionTemplate sqlSessionTemplate;

    public List<User> getUserList() {
        return sqlSessionTemplate.selectList("sql.user.getUserList");
    }
}

