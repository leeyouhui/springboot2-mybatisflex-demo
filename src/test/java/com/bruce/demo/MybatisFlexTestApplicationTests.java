package com.bruce.demo;

import cn.hutool.json.JSONUtil;
import com.bruce.demo.test.entity.po.Account;
import com.bruce.demo.test.entity.po.table.AccountTableDef;
import com.bruce.demo.test.mapper.AccountMapper;
import com.bruce.demo.test.service.AccountService;
import com.mybatisflex.core.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class MybatisFlexTestApplicationTests {

    @Resource
    AccountMapper accountMapper;

    @Resource
    AccountService accountService;

    @Test
    void contextLoads() {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select()
                .where(AccountTableDef.ACCOUNT.AGE.eq(18));
        Account account = accountMapper.selectOneByQuery(queryWrapper);
        System.out.println(account);
        assertNotNull(account);
    }

    @Test
    void getOneById() {
        Account account = accountService.getById(1L);
        System.out.println(JSONUtil.toJsonStr(account));
        assertNotNull(account);
    }
}