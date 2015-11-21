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
        if (users.count() > 15) return paging(1);
        ModelAndView mav = new ModelAndView("list");
        mav.addObject("users", users.findAll());
        mav.addObject("page", 1);
        mav.addObject("lastpage", users.count() / 15);
        return mav;
    }

    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    public ModelAndView paging(@PathVariable("page") Integer page) {

        ModelAndView mav = new ModelAndView("list");
        List<User> userList = getUsers();
        int from = (page-1) * 15, to = (page-1) * 15 + 15;
        if (to > userList.size()) to = userList.size();
        mav.addObject("users", userList.subList(from, to));
        mav.addObject("page", page);
        List<Integer> pages = new ArrayList<>();
        for (int i = 0; i <= users.count() / 15; i++) {
            pages.add(i + 1);
        }
        mav.addObject("pages", pages);
        mav.addObject("lastpage", users.count() / 15 + 1);
        return mav;
    }

    @RequestMapping(value = { "/search" }, method = RequestMethod.GET)
    public ModelAndView search(@RequestParam("name") String name) {

        ModelAndView mav = new ModelAndView("list");
        List<User> userList = getUsers();
        List<User> result = new ArrayList<>();
        for (User user : userList) {
            if (user.getName().contains(name)) result.add(user);
        }

        mav.addObject("users", result);
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addUser(String name, Integer age, Boolean isAdmin)
    {
        if (name.isEmpty()) name = "Anonymous" + "#" + ((int) (Math.random() * 123456));
        if (age == null) age = (int) (Math.random() * 100);
        if (isAdmin == null) isAdmin = false;

        users.save(new User(name, age, isAdmin, new Timestamp(new Date().getTime())));
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView getUserForm()
    {
        return new ModelAndView("add");
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") Integer id)
    {
        users.delete(id);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable("id") Integer id)
    {
        ModelAndView mav = new ModelAndView("edit");
        User user = users.findOne(id);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = {"/user/{id}"}, method = RequestMethod.POST)
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
