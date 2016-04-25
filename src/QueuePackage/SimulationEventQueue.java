package QueuePackage;

import java.util.*;

public class SimulationEventQueue implements SimulationEventQueueInterface{

	private double currentTime;
	private List<SimulationEvent> queue;
	
	
	public SimulationEventQueue() {
		queue = new Vector<SimulationEvent>();
	}
	
	public void add(SimulationEvent newEntry) {
		int index = queue.size();
		//System.out.println("Size: "+queue.size());
		for (int i = queue.size()-1; i >= 0; i --) {
			if (newEntry.getTime() <= queue.get(i).getTime()) {
				index = i;
			}
		}
		queue.add(index,newEntry);
	}

	public SimulationEvent remove() {
		SimulationEvent front = null;
		if (isEmpty()) {
			throw new EmptyQueueException("Attempting to access entries on an empty queue.");
		} else {
	            front = queue.remove(0);
	            currentTime = front.getTime();
		}
		return front;
	}

	public SimulationEvent peek() {
		SimulationEvent front = null;
        if (isEmpty())
            throw new EmptyQueueException("Attempting to access entries on an empty queue.");
        else
            front = queue.get(0);
        return front;
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public int getSize() {
		return queue.size();
	}

	public void clear() {
		queue.clear();
	}

	public double getCurrentTime() {
		return currentTime;
	}

}
