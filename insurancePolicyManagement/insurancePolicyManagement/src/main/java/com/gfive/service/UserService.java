package com.gfive.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.gfive.domain.User;
import com.gfive.repository.UserRepository;

@Service(value = "userService")
@Scope(value = "singleton")
public class UserService implements IUserService {

	@Autowired
	@Qualifier(value = "userRepository")
	private UserRepository userRepository;

	@Override
	public User addNewUser(User user) {
		try {
			userRepository.save(user);
			return user;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public boolean userLogin(String emailId, String password, HttpSession httpSession) {
		try {
			List<User> allUserList = userRepository.findAll();
			for (User userData : allUserList) {
				if ((userData.getUser_email()).equals(emailId) && (userData.getUser_password()).equals(password)) {
					httpSession.setAttribute("userLoginEmail", emailId);
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean userLogut(HttpSession httpSession) {
		try {
			httpSession.setAttribute("userLoginEmail", "");
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		try {
			userRepository.saveAndFlush(user);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean deleteUser(String emailId) {
		try {
			List<User> allUserList = userRepository.findAll();
			for (User userData : allUserList) {
				if ((userData.getUser_email()).equals(emailId)) {
					userRepository.delete(userData);
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public List<User> viewAllUser(HttpSession httpSession) {
		try {
			if ((httpSession.getAttribute("adminLoginStatus")).equals(true)) {
				return userRepository.findAll();
			}
			return null;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public boolean updateUserPassword(String emailId, String oldPassword, String newPassword) {
		try {
			List<User> allUserList = userRepository.findAll();
			for (User userData : allUserList) {
				if ((userData.getUser_email()).equals(emailId)) {
					if ((userData.getUser_password()).equals(oldPassword)) {
						userData.setUser_password(newPassword);
						userRepository.saveAndFlush(userData);
						return true;
					}
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public List<User> viewUserBySearchKeyword(String searchKeyword, HttpSession httpSession) {
		try {
			if ((httpSession.getAttribute("adminLoginStatus")).equals(true)) {
				return userRepository.searchUserByKeyWord(searchKeyword);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public User viewUserByEmail(String searchByEmail, HttpSession httpSession) {
		try {
			return userRepository.searchUserByEmail(searchByEmail);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
