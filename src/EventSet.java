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
	boolean vazio = true;
	
	public void add(Event e){
		if(this.quant() < 100){
			events[t] = e;
			t = (t + 1)%100;//t pode ser 100
		}
		else throw new RuntimeException("Array lotado");
	}
	public Event getNext(){
		if(!vazio){
			return events[s];
		}
		else return null;
	}
	public void removeCurrent(){
		if(!vazio){
			events[s] = null;
			s = (s + 1) % 100;
			if(this.quant() == 0) vazio = true;	
		}
	}
	public int quant(){
		if(vazio) return 0;
		if(t <= s && !vazio) return 100 + t - s;
		else return t - s;
	}
}
