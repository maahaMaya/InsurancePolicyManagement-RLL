package com.gfive.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.gfive.domain.Admin;
import com.gfive.repository.AdminRepository;

@Service(value = "adminService")
@Scope(value = "singleton")
public class AdminService implements IAdminService {

	@Autowired
	@Qualifier(value = "adminRepository")
	private AdminRepository adminRepository;

	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> allAdminList = adminRepository.findAll();
		//System.out.println(allAdminList.toString());
		return allAdminList;
	}

	@Override
	public boolean adminLogin(String adminEmail, String adminPassword) {
		try {
			List<Admin> allAdminList = adminRepository.findAll();
			for (Admin adminData : allAdminList) {
				if ((adminData.getAdmin_email()).equals(adminEmail)
						&& (adminData.getAdmin_password()).equals(adminPassword)) {
					//httpSession.setAttribute("adminLoginStatus", true);
					//System.out.println(httpSession.getAttribute("adminLoginStatus") + " -----------------");;
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean adminLogut() {
		try {
			//httpSession.setAttribute("adminLoginStatus", false);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
