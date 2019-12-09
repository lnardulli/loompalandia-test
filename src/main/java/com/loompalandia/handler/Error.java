package com.loompalandia.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public @Data class Error
{
	//General error message about nature of error
	private String message;

	//Specific errors in API request processing
	private List<String> details;

}
