package com.bruce.demo.my.entity.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class UserTableDef extends TableDef {

    /**
     * <p>
 用户表
 </p>

 @author bruce
 @since 2023-06-05
     */
    public static final UserTableDef USER = new UserTableDef();

    public final QueryColumn ID = new QueryColumn(this, "id");

    public final QueryColumn CITY = new QueryColumn(this, "city");

    public final QueryColumn GENDER = new QueryColumn(this, "gender");

    public final QueryColumn COUNTRY = new QueryColumn(this, "country");

    public final QueryColumn CREATE_BY = new QueryColumn(this, "create_by");

    public final QueryColumn LANGUAGE = new QueryColumn(this, "language");

    public final QueryColumn NICKNAME = new QueryColumn(this, "nickname");

    public final QueryColumn PROVINCE = new QueryColumn(this, "province");

    public final QueryColumn UPDATE_BY = new QueryColumn(this, "update_by");

    public final QueryColumn USERNAME = new QueryColumn(this, "username");

    public final QueryColumn AVATAR_URL = new QueryColumn(this, "avatar_url");

    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    public final QueryColumn UPDATE_TIME = new QueryColumn(this, "update_time");

    public final QueryColumn WECHAT_USER_ID = new QueryColumn(this, "wechat_user_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, CITY, GENDER, COUNTRY, CREATE_BY, LANGUAGE, NICKNAME, PROVINCE, UPDATE_BY, USERNAME, AVATAR_URL, CREATE_TIME, UPDATE_TIME, WECHAT_USER_ID};

    public UserTableDef() {
        super("", "user");
    }

}
