package com.speakingclock.speakingclock.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api2")
@Api(value = "Speaking Clock API")
public class SpeakingClockTimeInputController {
	final String[] NUMBERS = {
			"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
			"eighteen", "nineteen"
	};

	final String[] TENS = {
			"", "", "twenty", "thirty", "forty", "fifty"
	};


	@GetMapping("/time/{input_time}")
	@ApiOperation(value = "Get the current time in 24-hour format")
	public ResponseEntity<String> getTimeFormatted(@PathVariable String input_time) {
		//System.out.println(input_time);
		
		String timeString = input_time;
		String timeInWords = convertTimeToWords(timeString);
		//System.out.println(timeInWords);

		return ResponseEntity.ok(timeInWords);
	}

	/*This methos converts time in words */
	String convertTimeToWords(String time) {
		String[] parts = time.split(":");

		//try {
			int hour = Integer.parseInt(parts[0]);
			int minute = Integer.parseInt(parts[1]);
			
			String hourInWords = convertNumberToWords(hour);
			String minuteInWords = convertNumberToWords(minute);

			if (hour == 12 && minute == 0) {
				return "It's " + getSpecialTimeName(hour);
			}
			else if (hour == 0 && minute == 0) {
				return "It's " + getSpecialTimeName(hour);
			}

			return "It's " + hourInWords + " " + minuteInWords;
		//} //catch (NumberFormatException | ArrayIndexOutOfBoundsException | DateTimeParseException e) {
		/*catch (Exception e) {
			System.out.println("Exception  inside");
			 throw new ResourceNotFounException(e.getMessage()+" "+time);
		}*/
	}


	String convertNumberToWords(int number) {
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

	String getSpecialTimeName(int hour) {
		
		System.out.println("input hour is "+hour);
		if (hour == 12) {
			System.out.println("Midday");
			return "Midday";
			
		} else if (hour == 0) {
			System.out.println("Midnight");
			return "Midnight";
			
		} else {
			System.out.println("NOTHING");
			return "";
		}
	}

}    	


