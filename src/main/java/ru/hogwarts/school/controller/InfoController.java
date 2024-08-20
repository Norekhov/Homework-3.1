package ru.hogwarts.school.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.service.InfoService;

@RestController
@RequestMapping("/port")
@Tag(name="Страница работы с портом")
public class InfoController {
    @Autowired
    InfoService infoService;

    @GetMapping
    public String getPort() {
        return infoService.getPort();
    }
}
