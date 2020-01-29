package lzz.blog.community.community.controller;

import lzz.blog.community.community.dto.PageutilDTO;
import lzz.blog.community.community.mapper.UserMapper;
import lzz.blog.community.community.model.User;
import lzz.blog.community.community.service.NotificationService;
import lzz.blog.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          Model model,
                          HttpServletRequest request,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "7") Integer size) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
            PageutilDTO pageutilDTO = questionService.list(user.getId(), page, size);
            model.addAttribute("pageutilDTO", pageutilDTO);
        } else if ("replies".equals(action)) {
            PageutilDTO pageutilDTO = notificationService.list(user.getId(), page, 10);
            model.addAttribute("pageutilDTO", pageutilDTO);
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
        }

        return "profile";
    }
}
