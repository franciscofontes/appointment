package com.zallpy.appointment.security.auth;

import org.springframework.security.core.GrantedAuthority;

public class UserDetailsUtil {
	
	public static String[] authoritiesToArrayString(UserDetailsImpl user) {
		String[] auths = new String[user.getAuthorities().size()];
		int i = 0;
		for (GrantedAuthority auth : user.getAuthorities()) {
			auths[i] = auth.getAuthority();
			i++;
		}
		return auths;
	}
}
