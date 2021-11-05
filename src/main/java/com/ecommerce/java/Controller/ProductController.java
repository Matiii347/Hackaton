package com.ecommerce.java.Controller;

import com.ecommerce.java.Error.ErrorService;
import com.ecommerce.java.Service.ProductService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("registro-producto")
    public String productoR() {
        return "product-stock.html";
    }

    @PostMapping("registro-producto")
    public String productoRP(ModelMap map, MultipartFile file, @RequestParam String name, @RequestParam String type,
              @RequestParam Integer price, @RequestParam Integer stock) throws IOException {

        try {
            productService.createProduct(file, name, type, price, stock);
        } catch (ErrorService e) {
            e.printStackTrace();
        }

        return "product-stock.html";
    }

}
