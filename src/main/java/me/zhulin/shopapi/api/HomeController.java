package me.zhulin.shopapi.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created By Zhu Lin on 3/10/2018.
 */
@Controller
@CrossOrigin
public class HomeController {

  @RequestMapping({"/category/**", "/product/**", "login", "logout", "profile", "/register", "/cart", "/order/**", "/seller/**"})
  public String forward() {

    return "forward:/";
  }

}
