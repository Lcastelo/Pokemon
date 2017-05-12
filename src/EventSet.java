//class EventSet {
//	private Event[] events = new Event[100];
//	private int index = 0;
//	private int next = 0;
//	public void add(Event e) {
//			if(index >= events.length)
//				return; // (In real life, throw exception)
//			events[index++] = e;
//	}
//	public Event getNext() {
//		boolean looped = false;
//		int start = next;
//		do {
//			next = (next + 1) % events.length;
//			// See if it has looped to the beginning:
//			if(start == next) looped = true;
//			// If it loops past start, the list
//			// is empty:
//			if((next == (start + 1) % events.length) && looped)
//			return null;
//		} while(events[next] == null);
//		
//		return events[next];
//	}
//	public void removeCurrent() {
//		events[next] = null;
//	}
//}

class EventSet{
	private Event[] events = new Event[100];
	int s = 0;
	int t = 0;
	int qte = 0;
	
	public void add(Event e){
		if(this.qte < 100){
			events[t] = e;
			t = (t + 1)%100;//t pode ser 100
			qte++;
		}
		else throw new RuntimeException("Array lotado");
	}
	public Event getNext(){
		if(qte!=0){
			return events[s];
		}
		else return null;
	}
	public void removeCurrent(){
		if(qte!=0){
			events[s] = null;
			s = (s + 1) % 100;
			qte--;
		}
	}
}
