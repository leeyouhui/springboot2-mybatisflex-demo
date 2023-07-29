package com.bruce.demo.test.mapstruct;

import com.bruce.demo.test.entity.po.Account;
import com.bruce.demo.test.entity.vo.AccountVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author bruce
 * @date 2023/7/29
 * @desc 账户表转换
 */
@Mapper
public interface AccountConvert {
    public static final AccountConvert INSTANCE = Mappers.getMapper(AccountConvert.class);

    AccountVo toVo(Account account);
}
