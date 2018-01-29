package com.app.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.service.userService;
import com.bo.user;



@ResultPath("/pages/")
public class UserAction extends BaseAction implements SessionAware {

	/**
	 * utilis�e pour stocker la liste des produits destin�s � afficher dans la
	 * vue
	 */

	
	
	
	//contient les donnees du usr saisie en clavier
	private user user=new user();

	private Map<String, Object> session;

	/** injection du service m�tier */
	
	@Autowired
	private userService userService;
	

	@Action(value = "simuAuth", results = { 
	@Result(name = "success", type="redirectAction", location = "listStudent"),
	@Result(name = "error", location = "userForm.jsp"),
	})
	public String simuAuth() {
		user user1 = userService.getUserById(Long.valueOf(1));
		
		String n;
		
		if (user1 != null) {
			
			if(user1.getLogin().equals(user.getLogin())) {
			
			session.put("user", userService.getUserById(Long.valueOf(1)));
			System.out.println("connecter ");
			n=SUCCESS;
			}
			else
			{
				System.out.println("login different");
				n=ERROR;
			}
			
		}
		else {
			System.out.println("!!!");
			n=ERROR;
		}
		return n;}
			
//		if(user1.getLogin().equals("login") && user1.getPassword().equals("password")) {
//			if (user1 != null) {
//				
//				session.put("user", userService.getUserById(Long.valueOf(1)));
//				System.out.println("connecter ");
//			}
//			
//			return SUCCESS;
//			
//		}
//		
//			
//			else
//			{
//				System.out.println("erreur de saisie");
//				
//				return ERROR ;
//			}	
		
		
		
		
//		if(user.getLogin()!=null && user.getPassword()!=null) {

		
		
//		}
//		else {
//			System.out.println("les champs sont vides");
//			return ERROR;
//		}
		
///////////////////////////////////////////////////////////////////////////////////////////
		

	
	
	
	@Action(value = "listStudents", results = { 
	@Result(name = "success", location = "listStudent.jsp") })
	
	
	public String listStudent() {

		return SUCCESS;

	}



	public user getUser() {
		return user;
	}
	

	public void setUser(user user) {
		this.user = user;
	}

	public userService getUserService() {
		return userService;
	}

	public void setUserService(userService UserService) {
		this.userService = UserService;
	}

	public void setSession(Map<String, Object> pSession) {
		session = pSession;

	}
	
	
	
	
	
	
	
	
	
////////////////////////////////////////////////////////////////////////////////////
	public String getUserByLogin() {
		return user.getLogin();
	}
	
	public String getUserByPassword() {
		return user.getPassword();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
