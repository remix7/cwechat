package top.cynara.cwechat.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import top.cynara.cwechat.entitiy.ActiveUser;
import top.cynara.cwechat.entitiy.RegisterUser;
import top.cynara.cwechat.service.ActiveUserService;
import top.cynara.cwechat.service.RegisterUserService;

/**
 * 
 * @ClassName UserRealm
 * @Description 用于用户的认证授权
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月8日 下午1:33:39
 * @version V1.0
 */
public class UserRealm extends AuthorizingRealm {
	@Autowired
	private RegisterUserService rUserService;
	@Autowired
	private ActiveUserService aUserService;

	/**
	 * 用于认证
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 从token中提取出用户信息
		String subjectCode = (String) token.getPrincipal();
		// 根据用户id像数据库查询用户
		RegisterUser registerUser = rUserService.findByUserCode(subjectCode);
		// 如果不存在就直接返回null
		if (registerUser == null) {
			return null;
		}
		String password = registerUser.getPassword();
		String salt = registerUser.getSalt();
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUserid(registerUser.getId());
		activeUser.setUsercode(subjectCode);
		activeUser.setUsername(registerUser.getUsername());
		// activeUser.setMenus(aUserService.findAllMenuBySysUserId(registerUser.getId()));
		// 如果查询到返回 AuthenticationInfo
		// 将activeUser设置到SimpleAuthenticationInfo
		// ByteSource.Util.bytes(new StringBuffer(salt).reverse().toString())
		// 盐反转
		AuthenticationInfo info = new SimpleAuthenticationInfo(activeUser, password,
				ByteSource.Util.bytes(new StringBuffer(salt).reverse().toString()), "rn");
		// 查询不到返回null
		return info;
	}

	/**
	 * 用于授权
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	/**
	 * 在权限修改后由service调用此方法来使修改后的权限信息立即生效
	 * 
	 * @Title clearCache
	 * @Description TODO(这里用一句话描述这个方法的作用)
	 * @author Cynara-remix
	 * @Date 2016年10月7日 下午6:29:52
	 */
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}

}
