package com.springboot.activiti.eventlistener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springboot.activiti.dao.EventListener;
import com.springboot.activiti.enums.EventType;

public class EventListenerManager {

	private Map<EventType, List<EventListener>> eventListenerMap;

	private static EventListenerManager eventListenerManager = null;

	private EventListenerManager() {
		eventListenerMap = new HashMap<EventType, List<EventListener>>();
	}

	public static synchronized EventListenerManager getInstance() {
		if (eventListenerManager == null) {
			eventListenerManager = new EventListenerManager();
		}
		return eventListenerManager;
	}

	public List<EventListener> getEventListeners(EventType eventType) {
		synchronized (eventListenerMap) {
			return eventListenerMap.get(eventType);
		}
	}

	public void addListener(EventType eventType, EventListener listener) {
		List<EventListener> eventListeners = eventListenerMap.get(eventType);
		if (eventListeners != null)
			eventListeners.add(listener);
		else {
			eventListeners = new ArrayList<>();
			eventListeners.add(listener);
			eventListenerMap.put(eventType, eventListeners);
		}

	}
}
