/**
 * Created with IntelliJ IDEA.
 * User: fady
 * Date: 01/03/2013
 * Time: 12:45
 * To change this template use File | Settings | File Templates.
 */
public class P extends Process {
	private IFailureDetector detector;

	public P(String name, int id, int size){
		super(name,id,size);
		detector = new FailureDetector(this);
	}

	public void begin(){
		detector.begin();
	}
	public synchronized void receive (Message m){
		String type =m.getType();
		if (type.equals("heartbeat")){
			detector.receive(m);
		}
	}
   public static void main(String [] args){
		P p = new P("P1",1,2);
		p.registeR();
		p.begin();
	}
}
