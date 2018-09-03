package it.davidgreco.examples.springboot_swagger_example.configuration

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
  * Home redirection to swagger api documentation
  */
@Controller
class HomeController {
  @RequestMapping(value = Array("/"))
  def index: String = "redirect:swagger-ui.html"
}
