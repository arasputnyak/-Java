package lab.anastasya.controller;

import lab.anastasya.account.AccountService;
import lab.anastasya.account.MyUser;
import lab.anastasya.database.DBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/")
    public String getStartPage() {
        return "page1";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody // ??
    public String myAddUser(@RequestBody MyUser myUser) throws Exception {

        accountService.addNewUser2(myUser);

        return "page1";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public String myGetInfo(@RequestBody String name, ModelMap model) throws DBException {

        MyUser myUser = accountService.getUserByName(name);

        model.addAttribute("age", myUser.getAge());
        model.addAttribute("homeTown", myUser.getHomeTown());

        return "page4";

        // ИЛИ
        /*
        ModelAndView modelAndView = new ModelAndView("file3");
        modelAndView.addObject("age", myUser.getAge());
        modelAndView.addObject("homeTown", myUser.getHomeTown());

        return modelAndView;
        */
    }

    /*
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody // ??
    public void myAddUser(@RequestBody MyUser myUser) throws Exception {

        accountService.addNewUser2(myUser);
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public MyUser myGetInfo(@RequestBody String name) throws DBException {

        return accountService.getUserByName(name);
    }
    */

}
