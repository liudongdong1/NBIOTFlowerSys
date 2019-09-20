package com.ldd.flower.util;

import com.ldd.flower.entity.User;
import com.ldd.flower.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

/**
 * @Author liudongdong
 * @Date Created in 19:27 2019/9/20
 * @Description
 */
public class ShiroRealm extends AuthorizingRealm {
    private Logger logger= Logger.getLogger("ShiroRealm");

    @Autowired
    private UserService userService;
    /**
     * error record ,之前这里有句代码：@Autowired 未删除，导致报错Unsatisfied dependency expressed through method 'doGetAuthorizationInfo' parameter 0;
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        logger.info("userName:"+userName+" password:"+password);

        logger.info("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
        User user = userService.findByUsername(userName);

        if (user == null) {
            logger.info("userinfo:");
            throw new UnknownAccountException("用户名不存在！");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        logger.info("info: "+info.toString());
        return info;
    }
}
