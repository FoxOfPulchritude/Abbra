package com.mp.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.h2.server.web.WebServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mp.database.article.Article;
import com.mp.database.article.ArticleRepo;
import com.mp.database.message.Message;
import com.mp.database.message.MessageRepo;


@Controller
public class MainController {
	
	@Autowired
	ArticleRepo articleRepo;
	@Autowired
	MessageRepo messageRepo;
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/")
	public String index(Model model, Principal principal) {
		model.addAttribute("articles", articleRepo.findAll());
		model.addAttribute("user", principal.getName());
		return "index";
	}
	
	@GetMapping(value="/messages")
	public String messages(Model model, Principal principal) {
		List<Message> user = messageRepo.findBySenderUidOrReciverUid(principal.getName(), principal.getName());
		log.warn("Looking up messages for " + principal.getName());
		log.warn("Found " + user.size() + " messages for that uid");
		model.addAttribute("messages", user);
		model.addAttribute("user", principal.getName());
		return "messages";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
    @RequestMapping("/secure")
    public String secure(Map<String, Object> model, Principal principal) {
        model.put("title", "SECURE AREA");
        model.put("message", "Only Authorised Users Can See This Page");
        model.put("username", getUserName(principal));
        model.put("userroles", getUserRoles(principal));
        return "home";
    }

    private String getUserName(Principal principal) {
        if (principal == null) {
            return "anonymous";
        } else {

            final UserDetails currentUser = (UserDetails) ((Authentication) principal).getPrincipal();
            Collection<? extends GrantedAuthority> authorities = currentUser.getAuthorities();
            for (GrantedAuthority grantedAuthority : authorities) {
                System.out.println(grantedAuthority.getAuthority());
            }
            return principal.getName();
        }
    }

    private Collection<String> getUserRoles(Principal principal) {
        if (principal == null) {
            return Arrays.asList("none");
        } else {

            Set<String> roles = new HashSet<String>();

            final UserDetails currentUser = (UserDetails) ((Authentication) principal).getPrincipal();
            Collection<? extends GrantedAuthority> authorities = currentUser.getAuthorities();
            for (GrantedAuthority grantedAuthority : authorities) {
                roles.add(grantedAuthority.getAuthority());
            }
            return roles;
        }
    }
	
	@Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
