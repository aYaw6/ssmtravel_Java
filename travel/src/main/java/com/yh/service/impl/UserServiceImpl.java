package com.yh.service.impl;

import com.yh.mapper.UserMapper;
import com.yh.pojo.Role;
import com.yh.pojo.UserInfo;
import com.yh.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/6 - 11 - 06 - 11:53
 * @Description: com.yh.service.impl
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    //依赖注入;DI
    @Resource
    UserMapper userMapper;
    //延迟
    @Lazy
    @Resource
    PasswordEncoder passwordEncoder;

    /**
     * 根据用户名来获取，用户相关信息;
     * 对于返回类型是UserDetails接口，需要获取接口的实现类的对象;
     * 其实现类：User类;
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //通过mapper,来获取返回的userInfo对象;
        UserInfo userInfo = userMapper.findUserByUserName(username);
        //定义一个User对象;
        User user=null;

        if(userInfo!=null){
            //创建一个泛型集合，存储凭证信息
            List<SimpleGrantedAuthority> simpleGrantedAuthorities=new ArrayList<>();
            //获取userInfo对应的所有的角色集合;
            List<Role>roles=userInfo.getRoles();
            //下面使用循环，将角色集合存储上述的泛型集合里面;
            for (Role role : roles) {
                //存储每一个SimpleGrantedAuthority对象
                simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }

            user=new User(userInfo.getUsername(),
                    userInfo.getPassword(),
                    userInfo.getStatus()==0?false:true,
                    true,             //账号不过期
                    true,                             //凭证不过期
                    true,                             //锁定不过期
                    simpleGrantedAuthorities
            );
        }
        System.out.println(userInfo.getUsername());
        System.out.println(userInfo.getRoles());
        return user;
    }
}
