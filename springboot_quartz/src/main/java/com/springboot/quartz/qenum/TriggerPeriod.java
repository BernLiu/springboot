package com.springboot.quartz.qenum;

public enum TriggerPeriod {

	HOUR(0L,"小时"),DAY(1L,"日"),WEEK(2L,"周"),MONTH(3L,"月"),QUARTEROFYEAR(4L,"季度"),HALFOFYEAR(5L,"半年"),YEAR(6l,"年");
	
	private Long id;
	private String value;
	
	private TriggerPeriod() {
		
	}
	
	private TriggerPeriod(Long id, String value) {
		this.id = id;
		this.value = value;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
