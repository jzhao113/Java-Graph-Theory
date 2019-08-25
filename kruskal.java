package shortestPathAlgo;
import java.util.*;
public class kruskal {
	
	private graph g;
	private ArrayList<String> vertices;
	//both kruskal variables should have corres indexes
	private ArrayList<Integer> kruskalEdgeValues = new ArrayList<>();
	private ArrayList<String> kruskalEdgeNames = new ArrayList<>();
	
	public kruskal(graph g)
	{
		this.g = g;
		vertices = g.getVertices();
		ArrayList<String> edgeNames = g.getEdgeNames();
		HashMap<String, Integer> edgeValues = g.getAllEdgeValues();
		for(int i=0;i<edgeNames.size();i++)
		{
			String name = edgeNames.get(i);
			kruskalEdgeNames.add(name);
			kruskalEdgeValues.add(edgeValues.get(name));
		}
		//sorting the array 
		kruskalSelectionSort();
		
	}
	
	public ArrayList<String> findPath()
	{
		ArrayList<String> output = new ArrayList<>();
		ArrayList<String> touched = new ArrayList<>();
		for(int i=0;i<kruskalEdgeNames.size();i++)
		{
			String vertex1 = kruskalEdgeNames.get(i).substring(0,kruskalEdgeNames.get(i).indexOf(","));
			String vertex2 = kruskalEdgeNames.get(i).substring(kruskalEdgeNames.get(i).indexOf(",")+1,kruskalEdgeNames.get(i).length());

			String touchedVertex1="";
			String touchedVertex2="";
			int flag=0;
			for(int j=0;j<touched.size();j++)
			{
				if(vertex1.equals(touched.get(j)))
				{
					touchedVertex1=touched.get(j);
					flag++;
				}
				else if(vertex2.equals(touched.get(j)))
				{
					touchedVertex2=touched.get(j);
					flag++;
				}
			}
			if(flag!=2)
			{
				output.add(kruskalEdgeNames.get(i));
				if(touchedVertex1.equals(""))
					touched.add(kruskalEdgeNames.get(i).substring(0,kruskalEdgeNames.get(i).indexOf(",")));
				if(touchedVertex2.equals(""))
					touched.add(kruskalEdgeNames.get(i).substring(kruskalEdgeNames.get(i).indexOf(",")+1,kruskalEdgeNames.get(i).length()));
			}
		}
		
		if(output.size()!=vertices.size()-1)
		{
			output.clear();
			output.add("NO TREE CAN BE CREATED");
			return output;
		}
		
		return output;
	}
	
	private void kruskalSelectionSort()
	{
		for(int i=0;i<kruskalEdgeValues.size()-1;i++)
		{
			int min = kruskalEdgeValues.get(i);
			int minPos = i;
			for(int j=i+1;j<kruskalEdgeValues.size();j++)
			{
				if(kruskalEdgeValues.get(j)<min)
				{
					min=kruskalEdgeValues.get(j);
					minPos=j;
				}
			}
			if(min!=kruskalEdgeValues.get(i))
			{
				int tempValue = kruskalEdgeValues.get(minPos);
				String tempName = kruskalEdgeNames.get(minPos);
				
				kruskalEdgeValues.set(minPos,kruskalEdgeValues.get(i));
				kruskalEdgeNames.set(minPos,kruskalEdgeNames.get(i));
				
				kruskalEdgeValues.set(i,tempValue);
				kruskalEdgeNames.set(i,tempName);
				
			}
		}
	}
	

}
