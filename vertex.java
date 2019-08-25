
import java.util.*;

public class vertex {
	
	private String connectedVertices[];
	private String name;
	
	public vertex(String name,String connectedVertices[])
	{
		this.name = name;
		this.connectedVertices = connectedVertices;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String[] getConnected()
	{
		return connectedVertices;
	}

}
