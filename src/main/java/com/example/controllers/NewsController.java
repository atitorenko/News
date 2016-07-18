package com.example.controllers;

import com.example.entities.News;
import com.example.services.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by aleksejtitorenko on 18.07.16.
 */
@RestController
class NewsController {
    @Autowired
    private NewsServiceImpl newsService;

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    List<News> getNews(@RequestParam(name = "fromDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fromDate,
                       @RequestParam(name = "toDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date toDate) {
        return newsService.findNews(fromDate,toDate);
    }
}
