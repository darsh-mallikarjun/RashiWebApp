package com.rashi.application.productplots;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rashi.application.dto.ProductPlotDto;
import com.rashi.application.model.ProductPlots;
import com.rashi.application.service.ProductService;

@Controller
@RequestMapping
public class ProductController {

	private ProductService productservice;

	public ProductController(ProductService productservice) {
		super();
		this.productservice = productservice;
	}
	
	
	@GetMapping("/welcome")
	public String getUserByEmail(ProductPlotDto productPlotDto, Model model) {
		List<ProductPlots> product =productservice.findByAddress(productPlotDto.getAddress());
		List<ProductPlots> products = productservice.findAll();
		model.addAttribute("product", products );	
		model.addAttribute("search",  new ProductPlotDto());
		model.addAttribute("add", product);
			return "rashiwelcome";
		}
	}
	
