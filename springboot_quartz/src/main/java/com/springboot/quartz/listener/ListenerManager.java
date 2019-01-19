package com.springboot.quartz.listener;

public class ListenerManager {

	private MyJobListener myJobListener;

	private MyTriggerListener myTriListener;

	public MyJobListener getMyJobListener() {
		if (myJobListener == null)
			return new MyJobListener();
		return this.myJobListener;
	}

	public MyTriggerListener getMyTriggerListener() {
		if (myTriListener == null)
			return new MyTriggerListener();
		return this.myTriListener;
	}

	public void setMyJobListener(MyJobListener myJobListener) {
		this.myJobListener = myJobListener;
	}

	public void setMyTriggerListener(MyTriggerListener myTriListener) {
		this.myTriListener = myTriListener;
	}
}
