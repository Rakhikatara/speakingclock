package com.speakingclock.speakingclock.controller;

import java.time.LocalTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

	@RestController
    @RequestMapping("/clock-api")
    @Api(value = "Speaking Clock API")
    public class SpeakingclockController {

        @GetMapping("/time")
        @ApiOperation(value = "Get the current time in 24-hour format")
        public ResponseEntity<String> getCurrentTime() {
                 	 
        LocalTime currentTime = LocalTime.now();
        String currentTimeString = String.format("%02d:%02d", currentTime.getHour(), currentTime.getMinute());
        String timeInWords = convertTimeToWords(currentTimeString);
        System.out.println(timeInWords);
        
      return ResponseEntity.ok(timeInWords);
    }

	    private static final String[] NUMBERS = {
	        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
	        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
	        "eighteen", "nineteen"
	    };
	    
	    private static final String[] TENS = {
	        "", "", "twenty", "thirty", "forty", "fifty"
	    };
	    
	    public static String convertTimeToWords(String time) {
	        String[] parts = time.split(":");
	        int hour = Integer.parseInt(parts[0]);
	        int minute = Integer.parseInt(parts[1]);
	        
	        String hourInWords = convertNumberToWords(hour);
	        String minuteInWords = convertNumberToWords(minute);
	        
	        return "It's " + hourInWords + " " + minuteInWords;
	    }
	    
	    private static String convertNumberToWords(int number) {
	        if (number == 0) {
	            return "zero";
	        }
	        
	        if (number < 20) {
	            return NUMBERS[number];
	        }
	        
	        int tensDigit = number / 10;
	        int onesDigit = number % 10;
	        
	        return TENS[tensDigit] + " " + NUMBERS[onesDigit];
	    }
	    
	   
	}


