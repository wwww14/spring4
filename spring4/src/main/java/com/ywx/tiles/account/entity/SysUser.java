package com.ywx.tiles.account.entity;

import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

/**
 *  放在session中的用户信息.
 */
@SuppressWarnings("serial")
public class SysUser extends org.springframework.security.core.userdetails.User{
	
	private String userId;
	/**显示名称**/
	private String displayName;
	/**手机号码**/
	private String mobilePhone;
	/**最后登录时间**/
	private Timestamp lastLoginDate;

	/**
	 * 构造函数.
	 * @param username 用户名
	 * @param password 密码
	 * @param enabled 用户是否可用
	 * @param accountNonExpired 用户账号是否过期
	 * @param credentialsNonExpired 用户密码是否过期
	 * @param accountNonLocked 用户账号是否被锁定
	 * @param authorities 用户拥有的权限
	 */
	public SysUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
}
