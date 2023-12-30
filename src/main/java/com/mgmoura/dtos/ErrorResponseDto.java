package com.mgmoura.dtos;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto {
	
	private HttpStatus status;
	private List<String> errors;
	

}
