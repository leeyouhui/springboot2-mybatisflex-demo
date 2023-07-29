package com.bruce.demo.my.service.impl;

import com.bruce.demo.my.entity.po.User;
import com.bruce.demo.my.mapper.UserMapper;
import com.bruce.demo.my.service.UserService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author bruce
 * @since 2023-06-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

