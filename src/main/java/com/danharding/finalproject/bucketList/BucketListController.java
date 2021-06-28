package com.danharding.finalproject.bucketList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableWebSecurity
public class BucketListController{
    private static final String CREATE_BUCKETLIST_URL = "/coasters/bucketlist";
    @Autowired
    BucketListRepository bucketListRepository;

    @PostMapping("coasters/bucketlist")
    @CrossOrigin(origins = "http://localhost:3000")
        public void addBucketListCoaster(BucketListCoaster newBucketListCoaster) {
        List<BucketListCoaster> bucketListCoasters = bucketListRepository.findAll();

        
        System.out.println("New bucket list coaster " + newBucketListCoaster.toString());

        for (BucketListCoaster bucketListCoaster : bucketListCoasters) {
            System.out.println("New bucket list coaster " + newBucketListCoaster.toString());

            if (bucketListCoaster.equals(newBucketListCoaster)) {
                System.out.println("Coaster already entered!");
            }

            bucketListRepository.save(newBucketListCoaster);
        }
    }
}