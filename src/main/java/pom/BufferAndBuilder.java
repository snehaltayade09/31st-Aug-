package pom;

public class BufferAndBuilder {
	public static void main(String[]args) {
		String s="Velocity";
		String s1=s.concat("Katraj");
		
		
		System.out.println(s1);
		
		
		
		StringBuffer sf=new StringBuffer ("hello");
		sf.append("Everyone");
		System.out.println(sf);
		
		StringBuilder sb=new StringBuilder("Good");
		sb.append("Night");
		System.out.println(sb);
		
		System.out.println(sf.reverse());
		System.out.println(sb.reverse());
		
		
		
		
	}
      
	
	
	
}
