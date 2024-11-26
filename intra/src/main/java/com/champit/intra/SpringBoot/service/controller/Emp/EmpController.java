package com.champit.intra.SpringBoot.service.controller.Emp;

import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import com.champit.intra.vo.Career;
import com.champit.intra.vo.Code;
import com.champit.intra.vo.Company;
import com.champit.intra.vo.Emp;
import com.champit.intra.vo.Project;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.champit.intra.SpringBoot.service.controller.Main.MainController;
import com.champit.intra.SpringBoot.service.service.Career.CareerService;
import com.champit.intra.SpringBoot.service.service.Code.CodeService;
import com.champit.intra.SpringBoot.service.service.Company.CompanyService;
import com.champit.intra.SpringBoot.service.service.Emp.EmpService;
import com.champit.intra.SpringBoot.service.service.Insert.InsertService;
import com.champit.intra.SpringBoot.service.service.Project.ProjectService;
import com.champit.intra.util.FileUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/th/emp/*")
public class EmpController {

    @Autowired
    private MainController   mainController;

    @Autowired
    private EmpService      empService;
    @Autowired
    private CodeService     codeService;
    @Autowired
    private ProjectService  projectService;
    @Autowired
    private InsertService   insertService;
    @Autowired
    private CompanyService  companyService;
    @Autowired
    private CareerService   careerService;

    @Value("${file.root}")
    private String root;
    @Autowired
    private FileUtils fileUtils;

    private Company company;
    private Emp emp;
    private Career career;

    @GetMapping(value = "/")
    public String root(HttpServletRequest req, Model model) throws Exception {
      log.info("-------------- list --------------");
      //mav = new ModelAndView();

      if(!mainController.loginChk(req)) {
        return "redirect:/th/login/loginForm";
      }

      List<Emp> empList = empService.getEmpList();
      
		
		  model.addAttribute("empList", empList);
	
      return "th/emp/list";
    }

    @GetMapping(value = "/list")
    public String list(HttpServletRequest req, Model model) throws Exception {
      log.info("-------------- list --------------");
      //mav = new ModelAndView();

      HttpSession httpSession = req.getSession();

      if((String)httpSession.getAttribute("SEmpNo") == null) {
        log.info("-------------- login x --------------");
        return "redirect:/th/login/loginForm";
      }

      List<Emp> empList = empService.getEmpList();
      
		
		  model.addAttribute("empList", empList);
	
      return "th/emp/list";
    }

    @GetMapping(value = "/register")
    public String register(HttpServletRequest req, Model model) throws Exception {
      
      log.info("-------------- register --------------");

      HttpSession httpSession = req.getSession();

      if((String)httpSession.getAttribute("SEmpNo") == null) {
        log.info("-------------- login x --------------");
        return "redirect:/th/login/loginForm";
      }
      
      List<Emp> maxEmpNoList = empService.getMaxEmpNo();
      model.addAttribute("maxEmpNoList", maxEmpNoList);

      List<Code> codeList = codeService.getCodeList();
      model.addAttribute("codeList", codeList);

      List<Project> projectList = projectService.getProjectList();
      model.addAttribute("projectList", projectList);
	
		  return "th/emp/register";
    }

    @ResponseBody // 값 변환을 위해 꼭 필요함
	  @GetMapping("idCheck") // 아이디 중복확인을 위한 값으로 따로 매핑
    public boolean overlappedID(Company company) throws Exception{
      return companyService.overlappedID(company);
	  }
    
    @PostMapping(value = "/register")
    @ResponseBody //return값을 body로 보내기 위함
    public int save(@RequestPart(value = "key") String key, @RequestPart(value = "data") LinkedHashMap<String, Object> data, @RequestPart(value = "file", required = false) MultipartFile file) {
      System.out.println("data: " + data);

      emp     = new Emp();
      company = new Company();
      career  = new Career();

      if (file != null) {
        try{
          String savepath = root + "/img/";
          String filepath = fileUtils.upload(savepath, file);
          company.setPhoto_id(filepath);
          System.out.println(filepath);
        } catch (Exception e) {
          log.error("++++++++++++++++++++++ IMG UPLOAD FAIL ++++++++++++++++++++++", e);
        }
      } else company.setPhoto_id("temp.jpg");
      
      emp.setEmp_no((String) data.get("emp_no"));
      company.setEmp_no((String) data.get("emp_no"));
      career.setEmp_no((String) data.get("emp_no"));

      
      //emp      
      emp.setBth_d((String) data.get("bth_d"));
      emp.setBth_c((String) data.get("bth_c"));
      emp.setHm_phn_1((String) data.get("hm_phn_1"));
      emp.setHm_phn_2((String) data.get("hm_phn_2"));
      emp.setHm_phn_3((String) data.get("hm_phn_3"));
      emp.setMb_phn_1((String) data.get("mb_phn_1"));
      emp.setMb_phn_2((String) data.get("mb_phn_2"));
      emp.setMb_phn_3((String) data.get("mb_phn_3"));
      emp.setOff_phn_1((String) data.get("off_phn_1"));
      emp.setOff_phn_2((String) data.get("off_phn_2"));
      emp.setOff_phn_3((String) data.get("off_phn_3"));
      emp.setHm_adr_1((String) data.get("hm_adr_1"));
      emp.setHm_adr_2((String) data.get("hm_adr_2"));
      emp.setEmail((String) data.get("email"));
      emp.setHm_zip((String) data.get("hm_zip"));
      emp.setEm_phn_1((String) data.get("em_phn_1"));
      emp.setEm_phn_2((String) data.get("em_phn_2"));
      emp.setEm_phn_3((String) data.get("em_phn_3"));
            
      //company
      company.setLogin_id((String) data.get("login_id"));
      company.setLogin_pw((String) data.get("login_pw"));
      company.setName((String) data.get("name"));
      company.setRank_c((String) data.get("rank_c"));
      company.setIn_d((String) data.get("in_d"));
      company.setPrjt_id((String) data.get("prjt_id"));
      company.setEmp_c((String) data.get("emp_c"));
      company.setAut_c((String) data.get("aut_c"));
      company.setUcamp((String) data.get("ucamp"));
      company.setDepart_cd((String) data.get("depart_cd"));
      company.setSsn((String) data.get("ssn"));
      company.setSex_cd((String) data.get("sex_cd"));
      company.setSnh_in_d((String) data.get("snh_in_d"));
      company.setMemo((String) data.get("memo"));
      company.setPayment_date((String) data.get("payment_date"));

      //career
      career.setOut_com_yy(Integer.valueOf((String) data.get("out_com_yy")));
      career.setOut_com_mm(Integer.valueOf((String) data.get("out_com_mm")));
      career.setOut_etc_yy(Integer.valueOf((String) data.get("out_etc_yy")));
      career.setOut_etc_mm(Integer.valueOf((String) data.get("out_etc_mm")));
      career.setPromotion_ym((String) data.get("promotion_ym"));
      career.setSchedule_ym((String) data.get("schedule_ym"));
      career.setSchool_cd((String) data.get("school_cd"));
      career.setLicense_cd((String) data.get("license_cd"));
      career.setMilitary_cd((String) data.get("military_cd"));
            
      int succesEmp     = 0;
      int succesCompany = 0;
      int succesCareer  = 0;
      int result        = 0;
      String logString = "";
      if(key.equals("insert")) {
        System.out.println("insert");
        succesEmp     = insertService.insertEmp(emp);
        succesCompany = insertService.insertCompany(company);
        succesCareer  = insertService.insertCareer(career);
        logString = "등록";
      } else {
        System.out.println("update");
        succesEmp     = empService.updateEmp(emp);
        succesCompany = companyService.updateCompany(company);
        succesCareer  = careerService.updateCareer(career);
        logString = "수정";
      }

      if(succesEmp != 0 && succesCompany != 0 && succesCareer != 0) {
        result = succesEmp + succesCompany + succesCareer;
        log.info(logString + "이 완료되었습니다.");
      } else {
        log.info(logString + "이 실패하였습니다.");
        result = succesEmp + succesCompany + succesCareer;
      }

      return result;


    }

    
    @RequestMapping(value="/info", method = {RequestMethod.GET, RequestMethod.POST})
    public String info(String empNo, HttpServletRequest req, Model model) throws Exception {
      

      log.info("-------------- info --------------");

      HttpSession httpSession = req.getSession();

      if((String)httpSession.getAttribute("SEmpNo") == null) {
        log.info("-------------- login x --------------");
        return "redirect:/th/login/loginForm";
      }

      Emp emp = empService.getEmpInfo(empNo);

      System.out.println(emp);;

      model.addAttribute("emp", emp);

      List<Code> codeList = codeService.getCodeList();
      model.addAttribute("codeList", codeList);

      List<Project> projectList = projectService.getProjectList();
      model.addAttribute("projectList", projectList);

		  return "th/emp/info";
    }

}
