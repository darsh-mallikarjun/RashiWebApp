package com.rashi.application.admin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rashi.application.dto.LoginUser;
import com.rashi.application.dto.ProductPlotDto;
import com.rashi.application.model.Admin;
import com.rashi.application.model.BookingDetials;
import com.rashi.application.model.ProductPlots;
import com.rashi.application.model.User;
import com.rashi.application.service.AdminService;
import com.rashi.application.service.ProductService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping
public class AdminController {


	private AdminService adminService;
	
	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}

	
	@GetMapping("/admin")
	public String AdminLogin() {
		return "adminlogin";
	}
			
	@PostMapping("/adminlogout")
	public String showAdminloginpage(Admin admin1 ,Model model ) {
		Admin admin = adminService.findUserByName(admin1.getName(),admin1.getPassword());
		if(admin != null) {
			return "admin";
		}
		else {
		model.addAttribute("error", "Invalid admin");
		return "redirect:/admin?error";
		}
	}
	
	@GetMapping("/addproduct")
	public String AddProduct(Model model) {
		model.addAttribute("product", new ProductPlotDto());
		return "ProductDetails";
	}
	
	@PostMapping("/saveproduct")
	public String showproduct(@ModelAttribute("product") ProductPlotDto productPlotDto) {
		adminService.save(productPlotDto);
		return "redirect:/addproduct";
	}
	
	@GetMapping("/ListBooked")
	public String ListBookedProduct(Model model) {
		List<BookingDetials> booking = adminService.findAllBooking();
		model.addAttribute("booked", booking);
		return "ListPlotsBook";
	}
	
	@GetMapping("/showFormForDelete")
	public String showDelete(@RequestParam("productId") int theId,Model themodel) {
		
		adminService.deleteById(theId);
		
		return "redirect:/ListBooked";
	}

}

