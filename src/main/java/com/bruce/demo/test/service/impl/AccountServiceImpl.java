package com.bruce.demo.test.service.impl;

import com.bruce.demo.test.entity.po.Account;
import com.bruce.demo.test.mapper.AccountMapper;
import com.bruce.demo.test.service.AccountService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 账户表 服务层实现。
 *
 * @author lyh
 * @since 2023-07-29
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
