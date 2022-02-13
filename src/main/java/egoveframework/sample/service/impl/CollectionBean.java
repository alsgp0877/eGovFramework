package egoveframework.sample.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;


public class CollectionBean {
	private List<String> addressList;

	public List<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}
	
	

}
