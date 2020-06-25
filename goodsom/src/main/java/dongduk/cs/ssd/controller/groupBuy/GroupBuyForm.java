package dongduk.cs.ssd.controller.groupBuy;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import dongduk.cs.ssd.domain.GroupBuy;

/**
 * @author Seonmi Hwang
 * @since 2020.05.06
 */

@SuppressWarnings("serial")
public class GroupBuyForm implements Serializable {
	
	@Autowired
	private GroupBuy groupBuy;
	
	public boolean newGroupBuy;
	
	public GroupBuyForm() {
		this.groupBuy = new GroupBuy();
		this.setNewGroupBuy(true);
	}
	
	public GroupBuyForm(GroupBuy groupBuy) {
		this.groupBuy = groupBuy;
		this.setNewGroupBuy(false);
	}
	
	public GroupBuy getGroupBuy() {
		return groupBuy;
	}

	public boolean getNewGroupBuy() {
		return newGroupBuy;
	}

	public void setNewGroupBuy(boolean newGroupBuy) {
		this.newGroupBuy = newGroupBuy;
	}
	
	/*
	public boolean isNewGroupBuy() {
		return newGroupBuy;
	}
	*/
}
