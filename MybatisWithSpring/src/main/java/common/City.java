package common;

import java.io.Serializable;
import java.util.List;

public class City implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long Code;
	private String Name;
	private List<District> districts;
	public long getCode() {
		return Code;
	}
	public void setCode(long code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
	
	
}
