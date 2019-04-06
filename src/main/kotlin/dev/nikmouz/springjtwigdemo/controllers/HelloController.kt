package dev.nikmouz.springjtwigdemo.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HelloController {
    @RequestMapping("/hello/{name}")
    fun indexAction(model: ModelMap, @PathVariable("name") name: String): String {
        model.addAttribute("name", name)
        return "index"
    }
}