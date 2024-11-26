package com.champit.intra.SpringBoot.service.controller.Login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.champit.intra.SpringBoot.service.service.Company.CompanyService;
import com.champit.intra.SpringBoot.service.service.Emp.EmpService;
import com.champit.intra.vo.Emp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Slf4j
@Controller
@RequestMapping("/th/login/*")
public class LoginController {

    @Autowired
    private EmpService  empService;

    @Autowired
    private CompanyService  companyService;

    @Value("${file.root}")
    private String root;

    private ModelAndView mav;
    
    @GetMapping(value = "/")
    public ModelAndView loginFormRoot() throws Exception {
      
      mav = new ModelAndView();

		  mav.setViewName("th/login/loginForm.html");
	
		  return mav;
    }

    @GetMapping(value = "/loginForm")
    public ModelAndView loginForm() throws Exception {
      
      mav = new ModelAndView();

		  mav.setViewName("th/login/loginForm.html");
	
		  return mav;
    }

    @PostMapping(value = "/loginChk")
    public String loginChk(final HttpServletRequest request, String login_id, String login_pw, Model model) throws Exception {
      
      String url = "";

      HttpSession httpSession = request.getSession();

      String emp_no = companyService.getLoginCompany(login_id, login_pw);
      System.out.println(emp_no);
      if(emp_no != null || !emp_no.equals("")) {
        log.info("login succes");

        Emp emp = empService.getEmpInfo(emp_no);

				httpSession.setMaxInactiveInterval(1800);
        httpSession.setAttribute("SEmpNo", emp.getEmp_no());
        httpSession.setAttribute("aut_c", emp.getCompany().getAut_c());
        httpSession.setAttribute("loginChk", "success");
        
        model.addAttribute("empList", emp);
        url = "redirect:/th/emp/list";

      } else {
        log.info("login failed");
        url = "redirect:/th/login/loginForm";

      }
		  return url;
    }

    @GetMapping("logout")
    public String logOut(HttpServletRequest request) {
      HttpSession httpSession = request.getSession();
      httpSession.invalidate();
      return "redirect:/th/login/loginForm";
    }

}
