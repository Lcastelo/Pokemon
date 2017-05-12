abstract public class Event {
	private long evtTime = 200;
	public boolean ready() {
		return System.currentTimeMillis() >= evtTime;
	}
	abstract public void action();
	abstract public String description();
}
