package com.ecommerce.java.Controller;

import com.ecommerce.java.Entity.Photo;
import com.ecommerce.java.Repository.PhotoRepository;
import com.ecommerce.java.Service.PhotoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PhotoController {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private PhotoService photoService;

    @GetMapping("/photo-list")
    public String list(ModelMap modelo) {
        List<Photo> all = photoRepository.findAll();
        modelo.addAttribute("photos", all);
        return "list-photo.html";
    }

    @GetMapping("/load/{id}")
    public ResponseEntity<byte[]> cargarFoto(@PathVariable String id) {
        Photo photo = photoService.getOne(id);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(photo.getContent(), headers, HttpStatus.OK);
    }

}
