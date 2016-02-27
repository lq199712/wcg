package com.jlj.menu;

import java.util.List;

/**
 * 复合类型的按钮
 * @author John
 *
 */
public class ComplexButton extends Button {
//	private Button[] sub_button;
//
//	public Button[] getSub_button() {
//		return sub_button;
//	}
//
//	public void setSub_button(Button[] sub_button) {
//		this.sub_button = sub_button;
//	}
	private List<Button> sub_button;

	public List<Button> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<Button> sub_button) {
		this.sub_button = sub_button;
	}
	
	
}
