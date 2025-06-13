package com.kiet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiet.model.Member;
import com.kiet.service.MemberService;

@Controller
public class MemberControllerMVC {

	private MemberService service;

	public MemberControllerMVC(MemberService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/member/{id}")
	public String getMember(Model model, @PathVariable int id) {
		Member member = service.retrieveById(id);
		model.addAttribute("member", member);
		return "index";
	}

	@GetMapping("/members")
	public String getAllMembers(Model model) {
		model.addAttribute("members", service.retrieveAll());
		return "index";
	}
	
	@GetMapping("/members/active")
	public String getActiveMembers(Model model) {
		model.addAttribute("members", service.retrieveActiveMembers(true));
		return "index";
	}

	@GetMapping("/members/inactive")
	public String getInActiveMembers(Model model) {
		model.addAttribute("members", service.retrieveActiveMembers(false));
		return "index";
	}

	@DeleteMapping("/member/{id}")
	public String deleteMember(Model model, @PathVariable int id) {
		service.removebyid(id);
		model.addAttribute("students", service.retrieveAll());
		return "index";
	}

	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		model.addAttribute("member", new Member());
		return "member_form";
	}

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Member member = service.retrieveById(id);
        model.addAttribute("member", member);
        return "member_form";
    }

    @PostMapping("/update/{id}")
    public String updateMember(@PathVariable int id, @ModelAttribute Member updated) {
        Member member = service.retrieveById(id);
        member.setName(updated.getName());
        member.setJoinDate(updated.getJoinDate());
        member.setIssuedBooks(updated.getIssuedBooks());
        member.setActive(updated.isActive());
        service.addMember(member);
        return "redirect:/members";
    }

    @GetMapping("/delete/{id}")
    public String deleteMember(@PathVariable int id) {
    	service.removebyid(id);
        return "redirect:/members";
    }
	
	@PostMapping("/member")
	public String addMember(Model model, @ModelAttribute Member newMember) {
		service.addMember(newMember);
        return "redirect:/members";
	}
}
