package com.example.demo.controller;

import com.example.demo.model.Notice;
import com.example.demo.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
public class NoticesController {

    @Autowired
    private NoticeRepository noticeRepository;



    @GetMapping("/notices")
    public ResponseEntity<List<Notice>>  getNotices(){

        List<Notice>  notices =  noticeRepository.findAllActiveNotices();

        /**
         * When Some Data is not changing on frontend you can store them to some amount of time, so next time  automatically on frontend it will get used.
         * Instead of manking request
         */


        if(notices != null){
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(notices);
        }

        return null;
    }

}
