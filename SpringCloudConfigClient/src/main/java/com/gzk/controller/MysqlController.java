package com.gzk.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mydb")
public class MysqlController {
	
	@Autowired
	private JdbcTemplate template;
	
	@RequestMapping("/getAll")
    public List<Integer> getDbType(){
        String sql = "select * from t_user";
        List<Integer> list = template.queryForList(sql, Integer.class);
        System.out.print(new Date() + ":     ");
        for (Integer l : list) {
			System.out.print(l+"   ");
		}
        System.out.println();
        return list;
    }
	
}
