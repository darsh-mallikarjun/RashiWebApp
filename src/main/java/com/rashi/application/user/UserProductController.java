package com.rashi.application.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rashi.application.dto.BookingDto;
import com.rashi.application.dto.LoginUser;
import com.rashi.application.dto.ProductPlotDto;
import com.rashi.application.model.ProductPlots;
import com.rashi.application.model.User;
import com.rashi.application.service.UserProductService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping
public class UserProductController {
	
	
	@Autowired
	private UserProductService userProductService;
	
	
	@GetMapping("/login")
	public String loginpage(){
		return "rashiLogin";
	}
				
	@PostMapping("/logout")
	public String showloginpage(LoginUser loginuser , HttpSession HttpSession ,Model model ) {
		User user = userProductService.findUserByEmail(loginuser.getEmail(),loginuser.getPassword() );
		if(user != null) {
			HttpSession.setAttribute("user", user);
		}
		return "redirect:/welcomelog";
	}
	
	@GetMapping("/welcomelog")
	public String Products( ProductPlotDto productPlot ,Model model ,HttpSession HttpSession  ) {
          User user =(User) HttpSession.getAttribute("user");  
          	List<ProductPlots> products = userProductService.findAll();
      	List<ProductPlots> product1 =userProductService.findByAddress( productPlot.getAddress());
		if(user != null) {
		HttpSession.setAttribute("product", products);
		model.addAttribute("name", user.getName());
		model.addAttribute("add", product1);
		model.addAttribute("search",  new ProductPlotDto());
		model.addAttribute("product", products );
		
	}
		return "rashilogout";	
	}
	

	  @GetMapping("/bookingDetails")	
		public String showBooking(@RequestParam("productId") int theId,Model model, HttpSession httpSession ) {
		
		User user =(User) httpSession.getAttribute("user");
		
		if(user != null) {
			
			model.addAttribute("user", user);
			ProductPlots theemployee = userProductService.findAllProductByUser(theId);	
			model.addAttribute("product", theemployee);
		}
		
		return "booking-details";
	}
	  @GetMapping("/cancel")
		public String cancelpage(){
			return "cancel";
		}
	  
	  
		@PostMapping("/save")
		public String registerUser( BookingDto BookingDetialsDto, Model model, HttpSession httpSession  ) {
			User user =(User) httpSession.getAttribute("user");
			model.addAttribute("user", user);
			 userProductService.save(BookingDetialsDto);
			return "success";	
	}
		
}
			
			
			

