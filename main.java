package shortestPathAlgo;

import java.util.*;

public class main {
	
	public static void main(String[]args)
	{
		//writing down connection points for each node
		String ConnectionsA[]= {"B","C","D"};
		String ConnectionsB[]= {"A","C","F"};
		String ConnectionsC[]= {"A","B","D","F"};
		String ConnectionsD[]= {"A","C","E","G"};
		String ConnectionsE[]= {"D","F","G","H"};
		String ConnectionsF[]= {"B","C","E","H"};
		String ConnectionsG[]= {"D","E","H"};
		String ConnectionsH[]= {"E","F","G"};
		
		//loading vertices into ArrayList 
		ArrayList<vertex>vertices = new ArrayList();
	
		vertex a0 = new vertex("A",ConnectionsA);
		vertex a1 = new vertex("B",ConnectionsB);
		vertex a2 = new vertex("C",ConnectionsC);
		vertex a3 = new vertex("D",ConnectionsD);
		vertex a4 = new vertex("E",ConnectionsE);
		vertex a5 = new vertex("F",ConnectionsF);
		vertex a6 = new vertex("G",ConnectionsG);
		vertex a7 = new vertex("H",ConnectionsH);
		vertices.add(a0);
		vertices.add(a1);
		vertices.add(a2);
		vertices.add(a3);
		vertices.add(a4);
		vertices.add(a5);
		vertices.add(a6);
		vertices.add(a7);
		
		//creating edges
		String b1 = "A,B";
		String b2 = "A,D";
		String b3 = "B,F";
		String b4 = "A,C";
		String b5 = "B,C";
		String b6 = "C,D";
		String b7 = "C,F";
		String b8 = "D,E";
		String b9 = "E,F";
		String b10 = "D,G";
		String b11 = "E,G";
		String b12 = "E,H";
		String b13 = "F,H";
		String b14 = "G,H";
		ArrayList<String> edgeNames = new ArrayList<>();
		edgeNames.add(b1);
		edgeNames.add(b2);
		edgeNames.add(b3);
		edgeNames.add(b4);
		edgeNames.add(b5);
		edgeNames.add(b6);
		edgeNames.add(b7);
		edgeNames.add(b8);
		edgeNames.add(b9);
		edgeNames.add(b10);
		edgeNames.add(b11);
		edgeNames.add(b12);
		edgeNames.add(b13);
		edgeNames.add(b14);
		//loading edges into hashmap
		HashMap<String,Integer> edges = new HashMap<>();
		edges.put(b1,3);
		edges.put(b2,7);
		edges.put(b3,5);
		edges.put(b4,4);
		edges.put(b5,1);
		edges.put(b6,2);
		edges.put(b7,6);
		
		edges.put(b8,3);
		edges.put(b9,1);
		edges.put(b10,6);
		edges.put(b11,3);
		edges.put(b12,4);
		edges.put(b13,8);
		edges.put(b14,2);
		
		graph graph = new graph(edges,vertices,edgeNames);
		dijkstra dijkstra = new dijkstra(graph,"A","F");
		dijkstra.findPath();
		
		
		
		
		
		
		
		
		
		
		
		String ConnectionsHello0[] = {"Hello1","Hello3","Hello5"};
		String ConnectionsHello1[] = {"Hello0","Hello2","Hello3"};
		String ConnectionsHello2[] = {"Hello1","Hello3"};
		String ConnectionsHello3[] = {"Hello0","Hello1","Hello2"};
		String ConnectionsHello4[] = {"Hello3","Hello5"};
		String ConnectionsHello5[] = {"Hello0","Hello4"};
		
		vertex c0 = new vertex("Hello0",ConnectionsHello0);
		vertex c1 = new vertex("Hello1",ConnectionsHello1);
		vertex c2 = new vertex("Hello2",ConnectionsHello2);
		vertex c3 = new vertex("Hello3",ConnectionsHello3);
		vertex c4 = new vertex("Hello4",ConnectionsHello4);
		vertex c5 = new vertex("Hello5",ConnectionsHello5);
		
		ArrayList<vertex> vertices2 = new ArrayList<>();
		vertices2.add(c0);
		vertices2.add(c1);
		vertices2.add(c2);
		vertices2.add(c3);
		vertices2.add(c4);
		vertices2.add(c5);
		
		String ct ="Hello0,Hello1";
		String ct2 = "Hello0,Hello5";
		String ct3 = "Hello1,Hello2";
		String ct4 = "Hello2,Hello3";
		String ct5 = "Hello1,Hello3";
		String ct6 = "Hello0,Hello3";
		String ct7 = "Hello3,Hello4";
		String ct8 = "Hello5,Hello4";
		
		ArrayList<String> edgeNames2 = new ArrayList<>();
		HashMap<String,Integer> edges2 = new HashMap<>();
		
		edgeNames2.add(ct);
		edgeNames2.add(ct2);
		edgeNames2.add(ct3);
		edgeNames2.add(ct4);
		edgeNames2.add(ct5);
		edgeNames2.add(ct6);
		edgeNames2.add(ct7);
		edgeNames2.add(ct8);
		
		edges2.put(ct,3);
		edges2.put(ct2,2);
		edges2.put(ct3,3);
		edges2.put(ct4,4);
		edges2.put(ct5,8);
		edges2.put(ct6,4);
		edges2.put(ct7,6);
		edges2.put(ct8,5);
		
		graph g2 = new graph(edges2,vertices2,edgeNames2);
		kruskal kruskal = new kruskal(g2);
		
		ArrayList<String> output = kruskal.findPath();
		
		for(int i =0;i<output.size();i++)
			System.out.println(output.get(i));
		
		coloring color = new coloring(g2);
		HashMap<String,String> colors = color.colorIt();
		
		for(int i=0; i<g2.getVertices().size();i++)
		{
			System.out.println(g2.getVertices().get(i)+" : "+colors.get(g2.getVertices().get(i)));
		}
		
	}

}
