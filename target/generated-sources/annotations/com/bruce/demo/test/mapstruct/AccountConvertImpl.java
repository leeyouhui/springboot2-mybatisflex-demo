package com.bruce.demo.test.mapstruct;

import com.bruce.demo.test.entity.po.Account;
import com.bruce.demo.test.entity.vo.AccountVo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-29T19:28:18+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_361 (Oracle Corporation)"
)
public class AccountConvertImpl implements AccountConvert {

    @Override
    public AccountVo toVo(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountVo.AccountVoBuilder accountVo = AccountVo.builder();

        accountVo.id( account.getId() );
        accountVo.userName( account.getUserName() );
        accountVo.age( account.getAge() );
        accountVo.birthday( account.getBirthday() );

        return accountVo.build();
    }
}
