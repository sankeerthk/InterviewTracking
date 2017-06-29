package com.bofa.interview.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bofa.interview.persistence.model.Candidate;
import com.bofa.interview.service.CandidateService;

@Controller
public class ApplicationController {

	@Autowired
	private CandidateService candidateService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainPage() {
		return "index";
	}

	@RequestMapping(value = "/addCandidate", method = RequestMethod.GET)
	public String addCandidate(ModelMap model) {
		return "addCandidateForm";
	}

	@RequestMapping(value = "/addCandidate", method = RequestMethod.POST)
	public String saveCandidate(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("email") String email, @RequestParam("resume") MultipartFile resume, ModelMap model,
			RedirectAttributes redirectAttributes) {
		if (resume.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:/addCandidate";
		}
		candidateService.addCandidate(firstName,lastName,email,resume);
		model.addAttribute("message", "candidate added successfully");
		return "index";
	}

	@RequestMapping(value = "/listOfCandidates", method = RequestMethod.GET)
	public String getlistOfCandidates(ModelMap model) {
		List<Candidate> candidates = candidateService.getAllCandidates();
		model.addAttribute("candidates", candidates);
		model.addAttribute("can", "success");
		return "showCandidateForm";

	}

	@RequestMapping(value = "/updateCandidate/{id}/addInterview", method = RequestMethod.GET)
	public String addInterviewToCandidate(@PathVariable("id") long id, ModelMap model) {
		Candidate candidate = candidateService.getCandidate(id);
		System.out.println(candidate.getEmail());
		model.addAttribute("candidate", candidate);
		return "scheduleInterview";
	}

	@RequestMapping(value = "/updateCandidate/{id}/addInterview", method = RequestMethod.POST)
	public String setInterviewToCandidate(@PathVariable("id") long id,
			@RequestParam("interviewTimeSlot") Timestamp interviewTimeSlot, ModelMap model) {
		candidateService.addInterviewTimeSlot(id, interviewTimeSlot);
		model.addAttribute("message", "candidate Interview added successfully");
		return "index";
	}

	@RequestMapping(value = "/updateCandidate/{id}/addFeedback", method = RequestMethod.GET)
	public String addFeedbackToCandidate(@PathVariable("id") long id, ModelMap model) {
		Candidate c = candidateService.getCandidate(id);
		model.addAttribute("candidate", c);
		return "feedbackPage";
	}

	@RequestMapping(value = "/updateCandidate/{id}/addFeedback", method = RequestMethod.POST)
	public String setFeedbackToCandidate(@PathVariable("id") long id, @RequestParam("feedback") String feedback,
			ModelMap model) {
		candidateService.addFeedback(id, feedback);
		model.addAttribute("message", "candidate feedback added successfully");
		return "index";
	}
	
	@RequestMapping(value = "/updateCandidate/{id}/delete", method = RequestMethod.GET)
	public String deleteCandidate(@PathVariable("id") long id, ModelMap model) {
		boolean b= candidateService.deleteCandidate(id);
		if(b){
			model.addAttribute("message", "Candidate Delete Succesfully");
		}else{
			model.addAttribute("message", "something went wrong");
		}
		return "index";
	}
}
