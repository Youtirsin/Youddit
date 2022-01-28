package com.fourzhang.youddit.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fourzhang.youddit.entity.User;
import com.fourzhang.youddit.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    public UserMapper userMapper;
    
	@Autowired
	public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("username", username);
        UserDetails details = userMapper.selectOne(wrapper);
        if (details == null) {
            throw new UsernameNotFoundException(username + " not found");
        }
        return userMapper.selectOne(wrapper);
    }

    public void signUp(User user) throws Exception {
		try {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userMapper.insert(user);
		}catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
		}
	}
}
