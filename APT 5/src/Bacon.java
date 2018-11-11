import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import javax.swing.JFileChooser;

/**
 * Reads file with Traverses a graph from a single source using breadth-first
 * search algorithm from source s on a graph G. After preprocessing the graph,
 * can process shortest path queries from s to any vertex.
 * 
 * 
 */
public class Bacon {
	protected static JFileChooser ourChooser = new JFileChooser(System.getProperties().getProperty("user.dir"));

	// name -> Actor object
	private HashMap<String, Actor> myActors;
	// name -> Movies that actor has been in
	private HashMap<String, Movie> myMovies;
	private Graph myG;

	private static final String SOURCE = "Bacon, Kevin";

	public Bacon() {
		myG = new Graph();
		myActors = new HashMap<String, Actor>();
		myMovies = new HashMap<String, Movie>();
	}

	/**
	 * Traverse the graph from node named source
	 * 
	 * @param source
	 *            the String name of a vertex
	 */
	public void traverse(String source) {
		if (myG.hasVertex(source))
			traverse(myG, myG.getVertex(source));
	}

	/**
	 * Traverse the graph using breadth-first search on g from source
	 * 
	 * If source is not in the Graph, then the traversal will do nothing.
	 * 
	 * @param g
	 *            Graph that should be initialized and all vertices must have
	 *            distance set to Vertex.Infinity. After traversal, distance and
	 *            predecessor fields will be set.
	 * @param source
	 *            the Vertex from which to begin the traversal
	 */
	public void traverse(Graph g, Vertex source) {
		Queue<Vertex> fringe = new LinkedList<Vertex>();
		fringe.add(source);
		source.distance = 0;
		long begin = System.nanoTime();
		while (!fringe.isEmpty()) {
			Vertex v = fringe.remove();
			for (Vertex w : g.adjacentTo(v)) {
				if (w.distance == Vertex.INFINITY) { // has not been visited
					fringe.add(w);
					w.distance = v.distance + 1;
					w.predecessor = v;
				}
			}
		}
		System.out.printf("Graph traversed. Time elapsed: %.3fs\n", (System.nanoTime() - begin) / 1e9);

	}

	/**
	 * Using the actors and movies maps, create an Actor graph where:
	 * <ul>
	 * <li>Vertices: Actor names
	 * <li>Edges: two Actors are connected iff they appeared in the same movie
	 * </ul>
	 */
	public void createActorGraph() {
		for (Actor a : myActors.values())
			for (Actor b : a.coStars().keySet())
				myG.addEdge(a.getName(), b.getName());

	}

	/**
	 * Using the actors and movies maps, create an Actor-Movie graph where:
	 * <ul>
	 * <li>Vertices: Actor and Movie names
	 * <li>Edges: an Actor is connected to a Movie, iff he or she appeared in that
	 * movie
	 * </ul>
	 */
	public void createActorMovieGraph() {
		for (Movie m : myMovies.values())
			for (Actor a : m.getActors()) {
				myG.addEdge(m.name, a.name);
			}
	}

	/**
	 * Using the actors and movies maps, create Movie graph where:
	 * <ul>
	 * <li>Vertices: Movie names
	 * <li>Edges: two Movies are connected iff they share an Actor
	 * </ul>
	 */
	public void createMovieGraph() {
		for (Movie m : myMovies.values())
			for (Actor a : m.getActors())
				for (Movie otherMoov : a.getMovies())
					if (otherMoov != m)
						myG.addEdge(m.name, otherMoov.name);
	}

	/**
	 * @return set of actor names
	 */
	public Set<String> getActors() {
		return myActors.keySet();
	}

	/**
	 * @return set of movie names
	 */
	public Set<String> getMovies() {
		return myMovies.keySet();
	}

	/**
	 * @return Graph stored by this instance
	 */
	public Graph getGraph() {
		return myG;
	}

	/**
	 * Reads in the Actors and Movies from a File Each line in the data file
	 * consists of a movie title, followed by a list of actors and actresses that
	 * appeared in that movie, delimited by delimiter
	 * 
	 * @param f
	 *            the File to be read, does not do anything if the file cannot be
	 *            read for any reason
	 * @param delimiter
	 *            the String that appears between Movie and Actor names on each line
	 */
	public void readFile(File f, String delimiter) {
		long begin = System.nanoTime();
		Scanner in;
		try {
			in = new Scanner(f);

			// Each line of file
			// movie name/actor 1/actor 2/ .... / actress n
			while (in.hasNext()) {
				String line = in.nextLine();
				String[] elems = line.split(delimiter);
				if (elems.length == 0) {
					System.out.println("BAD line in input!");
					continue;
				}
				// create movie
				Movie moov = new Movie(elems[0]);
				// add movie to movie map
				myMovies.put(elems[0], moov);
				// loop through elems
				for (int k = 1; k < elems.length; k++) {
					// create an actor and add to actors map and
					// to movie's list of actors
					Actor person = myActors.get(elems[k]);
					if (person == null) { // new actor
						person = new Actor(elems[k]);
						myActors.put(elems[k], person);
					}
					person.add(moov);
					moov.addActor(person);

				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File cannot be opened: " + f);
			e.printStackTrace();
		}

		System.out.printf("File read. Time elapsed: %.3fs\n", (System.nanoTime() - begin) / 1e09);
	}

	/**
	 * Print the chain from Kevin Bacon to specified actor or actress. If no such
	 * actor or actress. print error message Actor Name has a Bacon number of X
	 * Actor Name appeared in Movie Name with Actor 2 Name ... Actor Z Name appeared
	 * in Movie Z Name with Kevin Bacon
	 * 
	 * Assumes Actor-Movie Graph
	 * 
	 * @param name
	 *            for actor or actress.
	 */
	public void printChain(String name) {
		Vertex start = myG.getVertex(SOURCE);
		Vertex dest = myG.getVertex(name);
		if (dest == null) {
			System.out.println("No such actor " + name);
		} else if (dest.distance == Vertex.INFINITY) {
			System.out.println(dest.name + " has a Bacon number of infinity");
		} else {
			System.out.println(dest.name + " has a Bacon number of " + dest.distance / 2);
			while (dest != start) {
				System.out.println(dest.name + " was in " + dest.predecessor + " with " + dest.predecessor.predecessor);
				dest = dest.predecessor.predecessor;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f = null;
		if (args.length > 0) {
			f = new File("data/" + args[0]);
		} else {
			int chooseStatus = ourChooser.showOpenDialog(null);
			if (chooseStatus != JFileChooser.APPROVE_OPTION) {
				System.exit(1);
			}
			f = ourChooser.getSelectedFile();
		}
		if (f == null)
			System.exit(1);
		Bacon bfs = new Bacon();
		bfs.readFile(f, "/");
		System.out.printf("Read file %s with %d movies and %d actors\n", f.getName(), bfs.getMovies().size(),
				bfs.getActors().size());
		long begin = System.nanoTime();
		bfs.createActorMovieGraph();
		System.out.printf("Created graph with %d vertices and %d edges in %.3fs\n", bfs.getGraph().numVertices(),
				bfs.getGraph().numEdges(), (System.nanoTime() - begin) / 1e9);
		bfs.traverse(Bacon.SOURCE);
		bfs.printChain("Bacon, Kevin");
		bfs.printChain("Wallace, Randall");
		bfs.printChain("Akan, Tarik");

	}

}
