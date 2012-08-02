package code;

public class Race {
	public String name;
	public int m,ws,bs,s,t,w,i,a,ld;
	
	public void setMax(String[] src) {
		m = Integer.parseInt(src[0]);
		ws = Integer.parseInt(src[1]);
		bs = Integer.parseInt(src[2]);
		s = Integer.parseInt(src[3]);
		t = Integer.parseInt(src[4]);
		w = Integer.parseInt(src[5]);
		i = Integer.parseInt(src[6]);
		a = Integer.parseInt(src[7]);
		ld = Integer.parseInt(src[8]);
	}
}
