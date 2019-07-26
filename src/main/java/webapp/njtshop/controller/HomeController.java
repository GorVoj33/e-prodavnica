package webapp.njtshop.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author Asus
 */
@Controller
public class HomeController {
    /*
    * In this Home Controller, we gonna develop for only bootstrap our website to display home page
    * */
    @RequestMapping("/")
    public String home(HttpServletRequest request) {
        if(!request.isUserInRole("ROLE_ADMIN")){
            return "home";
        }
        else {
            return "redirect:/admin/pocetna";
        }
    }
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        model.addAttribute("pageHeading", "Login strana");
        if (error!=null) {
            model.addAttribute("error", "Pogresno korisnicko ime ili lozinka!");
        }

        if (logout!=null) {
            model.addAttribute("logoutSuccessMessage", "Uspesno ste se odjavili, hvala na poseti!");
        }
        return "login";
    }

}
