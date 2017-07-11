package com.ywx.tiles.account.service.impl;

import java.util.Set;

import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.google.common.collect.Sets;
import com.ywx.tiles.account.entity.SysUser;
import com.ywx.tiles.account.entity.User;

public class UserDetailsServiceImpl implements UserDetailsService {

	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		User user = new User();
		
		// 获取用户资源
		Set<GrantedAuthority> authorities = obtainGrantedAuthorities(user);
		
		// 暂时全部设为true. --//
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		SysUser sysUser = new SysUser("", "", enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		return sysUser; 
	}

	/**
	 * 获得用户所有角色的权限集合.
	 * @param user
	 * @return
	 */
	private Set<GrantedAuthority> obtainGrantedAuthorities(User user) {
		Set<GrantedAuthority> authSet = Sets.newHashSet();
		authSet.add((GrantedAuthority) new GrantedAuthoritySid("ROLE_user"));
		return authSet;
	}
}
