package com.mm.bootproja.biz;

import com.mm.bootproja.entity.User;
import com.mm.bootproja.mapper.UserMapper;
import com.mm.bootproja.util.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBiz {
    @Autowired
    private UserMapper mapper;
    public User checkLogin(User user){
        User dbUser = mapper.selectUserByTel(user.getTel());
        if(dbUser!=null && dbUser.getLoginPwd().equals(user.getLoginPwd())){
            dbUser.setLoginPwd(null);
            return dbUser;
        }else {
            throw new MyException("登录失败，账号不存在或密码错误");
        }
    }

    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }
}
