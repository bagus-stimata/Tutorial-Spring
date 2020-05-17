package com.example.springbootsecurity3extended.web_controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.springbootsecurity3extended.SecurityConfig.SecurityUtils;
import com.example.springbootsecurity3extended.model.Role;
import com.example.springbootsecurity3extended.model.Status;
import com.example.springbootsecurity3extended.model.Task;
import com.example.springbootsecurity3extended.service.TaskService;

/**
 * The TodoController  Class
 *
 * @author ibrahim KARAYEL
 * @version 1.0
 * Date 4/27/2018.
 */
@Controller
@ComponentScan
public class TodoController {

    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TaskService taskService;

    @Autowired
    private SecurityUtils securityUtils;


    @PreAuthorize("hasAnyRole({'" + Role.USER + "', '" + Role.ADMIN + "'})") //Perhatikan hasRole dan hasAnyRole
    @RequestMapping("/task")
    public String task(final Model viewModel) {

        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final String namaUser = auth.getName(); //jika tidak ada akan memberikan nilai null
        final String principal_1 = auth.getPrincipal().toString();
        viewModel.addAttribute("namaUser", namaUser);
        viewModel.addAttribute("principal", principal_1);

        // System.out.println("######## GET AUTH NAME hahhaa: ######## " + namaUser  + " > " +  taskService.findAll().size() );

        final Task task =new Task();
        viewModel.addAttribute("reqTask", task);
        viewModel.addAttribute("allTask", taskService.findByUserIdStatus(securityUtils.getLoginUser().getId(), Status.ACTIVE.getValue()));
        viewModel.addAttribute("allPassiveTask", taskService.findByUserIdStatus(securityUtils.getLoginUser().getId(), Status.PASSIVE.getValue()));
        logger.info("# Form Task");
      
        return "/task/task";
    }

    @PreAuthorize("hasAnyRole({'" + Role.USER + "', '" + Role.ADMIN + "'})") //Perhatikan hasRole dan hasAnyRole
    @RequestMapping("/task/search/{search_text}")
    public String taskSearch( @PathVariable("search_text") final String search_text, final RedirectAttributes redirectAttributes,  final Model viewModel) {

        final Task task =new Task();


        viewModel.addAttribute("reqTask", task);
        // viewModel.addAttribute("allTask", taskService.findByUserIdStatus(globalController.getLoginUser().getID(), Status.ACTIVE.getValue()));
        viewModel.addAttribute("allPassiveTask", taskService.findByUserIdStatus(securityUtils.getLoginUser().getId(), Status.PASSIVE.getValue()));

        final List<Task> listTask = new ArrayList<>(taskService.findByUserIdStatus(securityUtils.getLoginUser().getId(), Status.ACTIVE.getValue()) );
        if (search_text.equals("12345_6789")) {
            viewModel.addAttribute("allTask", listTask );
            viewModel.addAttribute("search_text", "");
        }else  {
            viewModel.addAttribute("allTask", listTask.stream().filter(x -> x.getTaskName().contains(search_text) || x.getDescription().contains(search_text)  ).collect(Collectors.toList()) );
        }


        logger.info("# Form Search Task");
      
        return "/task/task";
    }


    @PreAuthorize("hasAnyRole({'" + Role.USER + "', '" + Role.ADMIN + "'})") //Perhatikan hasRole dan hasAnyRole
    @RequestMapping(value = {"/task/saveTask"}, method = RequestMethod.POST)
    public String saveTodo(@ModelAttribute("reqTask") final Task reqTask,
                           final RedirectAttributes redirectAttributes) {
        logger.info("/task/save");
   
        try {
            reqTask.setCreateDate(LocalDateTime.now());
            reqTask.setStatus(Status.ACTIVE.getValue());
            reqTask.setUserId(securityUtils.getLoginUser().getId() );

            taskService.save(reqTask);
            redirectAttributes.addFlashAttribute("msg", "success");
        } catch (final Exception e) {
            redirectAttributes.addFlashAttribute("msg", "fail");
            logger.error("save: " + e.getMessage());
        }

        return "redirect:/task";
    }

    @PreAuthorize("hasAnyRole({'" + Role.USER + "', '" + Role.ADMIN + "'})") //Perhatikan hasRole dan hasAnyRole
    @RequestMapping(value = {"/task/editTask"}, method = RequestMethod.POST)
    public String editTodo(@ModelAttribute("editTask") final Task editTask, final Model model) {
        logger.info("/task/editTask");
        try {
            final Task task = taskService.findById(editTask.getId() );
            if (!task.equals(editTask)) {
                taskService.update(editTask);
                model.addAttribute("msg", "success");
            } else {
                model.addAttribute("msg", "same");
            }
        } catch (final Exception e) {
            model.addAttribute("msg", "fail");
            logger.error("editTask: " + e.getMessage());
        }
        model.addAttribute("editTodo", editTask);
        return "task/task_edit";
    }


    // @PreAuthorize("hasAnyRole({'" + Role.USER + "', '" + Role.ADMIN + "'})") //Perhatikan hasRole dan hasAnyRole
    @RequestMapping(value = "/task/{operation}/{id}", method = RequestMethod.GET)
    public String todoOperation(@PathVariable("operation") final String operation,
                                @PathVariable("id") final int id, final RedirectAttributes redirectAttributes,
                                final Model model) {

        logger.info("/task/operation: {} ", operation);

        if (operation.equals("trash")) {
            final Task task = taskService.findById(id);
            if (task != null) {
                task.setStatus(Status.PASSIVE.getValue());
                taskService.update(task);
                redirectAttributes.addFlashAttribute("msg", "trash");
            } else {
                redirectAttributes.addFlashAttribute("msg", "notfound");
            }
        }
        if (operation.equals("restore")) {
            final Task task = taskService.findById(id);
            if (task != null) {
                task.setStatus(Status.ACTIVE.getValue());
                taskService.update(task);
                redirectAttributes.addFlashAttribute("msg", "active");
                redirectAttributes.addFlashAttribute("msgText", "Task " + task.getTaskName() + " Restored Successfully.");
            } else {
                redirectAttributes.addFlashAttribute("msg", "active_fail");
                redirectAttributes.addFlashAttribute("msgText", "Task Activation failed !!! Task:" + task.getTaskName());

            }

        } else if (operation.equals("delete")) {
            if (taskService.delete(id)) {
                redirectAttributes.addFlashAttribute("msg", "del");
                redirectAttributes.addFlashAttribute("msgText", " Task deleted permanently");
            } else {
                redirectAttributes.addFlashAttribute("msg", "del_fail");
                redirectAttributes.addFlashAttribute("msgText", " Task could not deleted. Please try later");
            }
        } else if (operation.equals("edit")) {
            final Task editTask = taskService.findById(id);
            if (editTask != null) {
                model.addAttribute("editTask", editTask);
                return "task/task_edit";
                // return "task";
            } else {
                redirectAttributes.addFlashAttribute("msg", "notfound");
            }
        } else if (operation.equals("search")) {

            return "/index";
        }

        return "redirect:/task";
    }


}
