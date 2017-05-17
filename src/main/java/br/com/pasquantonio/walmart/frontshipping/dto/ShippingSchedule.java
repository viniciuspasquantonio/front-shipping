package br.com.pasquantonio.walmart.frontshipping.dto;

import java.io.Serializable;

public class ShippingSchedule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer orderId = 1;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	@Override
    public String toString() {
        return "ShippingSchedule{" +
                "orderId='" + orderId + "'\'}";
    }
}
