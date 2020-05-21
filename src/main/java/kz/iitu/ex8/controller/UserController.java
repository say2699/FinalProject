package kz.iitu.ex8.controller;

import kz.iitu.ex8.entity.Product;
import kz.iitu.ex8.entity.User;
import kz.iitu.ex8.service.ProductService;
import kz.iitu.ex8.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String productList(Model model) {
        model.addAttribute("allProducts", productService.allProducts());
        return "products";
    }



    @PostMapping("/products")
    public String addInBasket(@RequestParam(required = true, defaultValue = "") Long productId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model,
                              @AuthenticationPrincipal User currentUser,
                              @PathVariable Product product) {
        if (action.equals("add")) {
            userService.addInBasket(currentUser,product);
        }
        return "redirect:/products";
    }



    @GetMapping("/basket")
    public String listBasket(
            Model model,
            @AuthenticationPrincipal User currentUser

    ) {
        model.addAttribute("allBasket", currentUser.getBasket());
        return "basket";
    }






}