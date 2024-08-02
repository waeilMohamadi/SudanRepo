package com.nareshit.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeForm {
	private Integer id;
	private String name;
	private String address;
	private Double salary;
	
}
