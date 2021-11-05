package com.ecommerce.java.Controller;

import com.ecommerce.java.Error.ErrorService;
import com.ecommerce.java.Service.ClientService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/registrate.html")
    public String register(ModelMap model, @RequestParam String name, @RequestParam String lastname,
            @RequestParam Long document, @RequestParam String phoneNumber, @RequestParam String address,
            @RequestParam String email, @RequestParam String password1, @RequestParam String password2,
            @RequestParam MultipartFile file) throws IOException {

        try {
            clientService.createClient(name, lastname, document, phoneNumber, address, email, password1, password2,
                    file);

            return "index.html";
        } catch (ErrorService ex) {

            model.put("error", ex.getMessage());
            model.put("name", name);
            model.put("lastname", lastname);
            model.put("document", document);
            model.put("phoneNumber", phoneNumber);
            model.put("address", address);
            model.put("email", email);
            model.put("password1", password1);
            model.put("password2", password2);
            model.put("file", file);

            return "registrate.html";

        }

    }

}
