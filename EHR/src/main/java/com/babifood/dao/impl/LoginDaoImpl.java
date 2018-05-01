package com.babifood.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.babifood.dao.LoginDao;
import com.babifood.entity.LoginEntity;
@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	JdbcTemplate jdbctemplate;
	Logger log = LoggerFactory.getLogger(LoginDaoImpl.class);
	
	@Override
	public LoginEntity findLogin(String user_name, String password) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select u.user_id,u.user_name,u.password,u.show_name,u.e_mail,u.phone,u.state,r.role_id,r.role_name ");
		sql.append("from ehr_users u left join ehr_user_role r on u.user_id=r.user_id where u.user_name=? and u.password=?");
        LoginEntity login =null;
        try{
        	login = jdbctemplate.queryForObject(sql.toString(),new BeanPropertyRowMapper<>(LoginEntity.class), user_name,password);
        }catch(Exception e) {
            log.error("查询错误："+e.getMessage());
        }
		return login;
	}
}
