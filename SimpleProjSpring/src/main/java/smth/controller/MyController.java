package smth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import smth.account.AccountService;
import smth.database.DBException;
import smth.account.MyUser;
import smth.account.NameForm;

import javax.validation.Valid;

@Controller
public class MyController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/")
    public String getStartPage() {
        return "page1";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(Model model) {
        model.addAttribute("myUser", new MyUser());
        return "page2";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute MyUser myUser, BindingResult binding, Model model) throws DBException {
        if (binding.hasErrors()) {
            return "page2";
        }

        model.addAttribute("result", myUser.getName() + ", " + myUser.getAge() +", " + myUser.getHomeTown());
        accountService.addNewUser(myUser);
        return "page4";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String infoForm(Model model) {
        model.addAttribute("nameForm", new NameForm());
        return "page3";
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public String infoUser(@Valid @ModelAttribute NameForm nameForm, BindingResult binding, Model model) throws DBException {

        MyUser myUser = accountService.getUserByName(nameForm.getValue());
        if (myUser == null && nameForm.getValue().trim().length() > 0) {
            binding.rejectValue("value", "error.user", "No such profile!");
        }

        if (binding.hasErrors()) {
            return "page3";
        }

        model.addAttribute("age", myUser.getAge());
        model.addAttribute("homeTown", myUser.getHomeTown());
        return "page5";
    }

            /*@RequestMapping(value = "/infoo", method = RequestMethod.GET)
        public String infoPage() {
            return "page3";
        }

        @RequestMapping(value = "/info", method = RequestMethod.GET)
        public String infoUser(@RequestParam(value = "name") String name, Model model) throws DBException {
            MyUser myUser = accountService.getUserByName(name);
            model.addAttribute("age", myUser.getAge());
            model.addAttribute("homeTown", myUser.getHomeTown());
            return "page5";
        }*/

}