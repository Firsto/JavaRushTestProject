package ru.firsto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.firsto.model.User;
import ru.firsto.model.UsersRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by razor on 21.11.15.
 */

@RestController
@RequestMapping("/")
public class UsersController {
    @Autowired
    UsersRepository users;

//    @RequestMapping(method = RequestMethod.GET)
    @ModelAttribute("users")
    public List<User> getUsers()
    {
        List<User> result = new ArrayList<>();
        users.findAll().forEach(result::add);
        return result;
    }
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String users(Model model) {
        model.addAttribute("users", users.findAll());
        return "list";
    }

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public ModelAndView users() {

        ModelAndView mav = new ModelAndView("list");
        mav.addObject("users", users.findAll());
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addUser(String name, Integer age, Boolean isAdmin)
    {
        if (name.isEmpty()) name = "Anonymous";
        if (age == null) age = 0;
        if (isAdmin == null) isAdmin = false;

        users.save(new User(name, age, isAdmin, new Timestamp(new Date().getTime())));
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView getUserForm()
    {
        return new ModelAndView("add");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") Integer id)
    {
        users.delete(id);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable("id") Integer id)
    {
        ModelAndView mav = new ModelAndView("edit");
        User user = users.findOne(id);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.POST)
    public ModelAndView editUser(@PathVariable("id") Integer id, String name, Integer age, Boolean isAdmin)
    {
        User user = users.findOne(id);

        if (name.isEmpty()) name = "Anonymous";
        if (age == null) age = 0;
        if (isAdmin == null) isAdmin = false;

        if (user != null) {
            user.setName(name);
            user.setAge(age);
            user.setIsAdmin(isAdmin);
        }
        users.save(user);

        return new ModelAndView("redirect:/");
    }

}
