package com.smartEquip.humanCheck.controller;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;

import com.smartEquip.humanCheck.Question;

@RestController
public class HumanCheckController {


	@Autowired
	private   SecureRandom rand;


	@RequestMapping(value="/", method=RequestMethod.POST, produces="application/json")
	public Question intialRequest() {
		int a = rand.nextInt(10);
		int b = rand.nextInt(10);
		int c = rand.nextInt(10);
		String question = "Please sum the numbers " +a+ "," +b+ "," +c;
		String response = Integer.toString(a+b+c);
		return new Question((question+ " |"+response),question);
	}

	@RequestMapping(value="/", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> validateResponse(@RequestParam("question") String question, @RequestParam("response") String response) {
		if (question != null) {
			String[] fields = question.split("\\,");
			if (fields.length == 3) {
				int expectedChallenge = Integer.parseInt(Character.toString( fields[0].charAt(fields[0].length()-1))) + Integer.parseInt( fields[1] )+ Integer.parseInt(fields[2]);
				String expectedResponse = response;
				if (expectedChallenge == (Integer.parseInt(expectedResponse))) {
					return new ResponseEntity<>(JSONObject.quote("That’s great"), HttpStatus.OK);
				}
			}
		}
		return new ResponseEntity<>(JSONObject.quote("That’s wrong. Please try again."), HttpStatus.BAD_REQUEST);
	}




}
