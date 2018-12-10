package com.minutes.swagger;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@Api(value="test home controller", description="custome operations in home controller")
public class HomeController {

	@ApiOperation(value="test get mapping", response=String.class)
	@GetMapping("/")
	public String get() {
		return "success!!";
	}
	
	@PostMapping(value="/", produces="application/json")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created"),
            @ApiResponse(code = 401, message = "You are not authorized to create the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	public String post() {
		return "Success Post!!";
	}
	
	@DeleteMapping("/")
	@ApiResponses(value = {
			@ApiResponse(code=404, message="success")
	})
	public String delete() {
		return "Success delete!!";
	}
}
