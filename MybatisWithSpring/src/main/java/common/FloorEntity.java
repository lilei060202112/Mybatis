package common;

import java.io.Serializable;

public class FloorEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String style;
	private long id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
