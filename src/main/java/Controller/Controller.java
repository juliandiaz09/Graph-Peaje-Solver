package Controller;

import Model.City;
import Model.Peaje;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.util.*;

public class Controller {
    /** Weighted graph representing the cities and roads. */
    Graph<City, DefaultWeightedEdge> grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
    /** List of cities in the graph. */
    List<City> cities = new ArrayList<>();
    /** Initialises the cities that will be in the graph.*/
    City medellin = new City("Medellin");
    City bogota = new City("Bogota");
    City cali = new City("Cali");
    City barranquilla = new City("Barranquilla");
    City manizales = new City("Manizales");
    City pereira = new City("Pereira");
    City cartagena = new City("Cartagena");
    City bucaramanga = new City("Bucaramanga");
    City santaMarta = new City("Santa Marta");


    /** Constructor for the Controller.Controller class. Initializes the graph and adds cities. */
    public Controller() {
        grafo.addVertex(medellin);
        grafo.addVertex(bogota);
        grafo.addVertex(cali);
        grafo.addVertex(barranquilla);
        grafo.addVertex(manizales);
        grafo.addVertex(pereira);
        grafo.addVertex(cartagena);
        grafo.addVertex(bucaramanga);
        grafo.addVertex(santaMarta);

        addCities(medellin);
        addCities(bogota);
        addCities(cali);
        addCities(barranquilla);
        addCities(manizales);
        addCities(pereira);
        addCities(cartagena);
        addCities(santaMarta);
        addCities(bucaramanga);

        Map<String, List<Peaje>> peajesPorCarretera = new HashMap<>();
        peajesPorCarretera.put("Medellin-Bogotá", Arrays.asList(
                new Peaje("Peaje1", 5000.0),
                new Peaje("Peaje2", 8000.0)
        ));

        peajesPorCarretera.put("Bogotá-Cali", Arrays.asList(
                new Peaje("Peaje3", 7000.0),
                new Peaje("Peaje4", 10000.0)
        ));

        peajesPorCarretera.put("Cali-Barranquilla", Arrays.asList(
                new Peaje("Peaje5", 6000.0),
                new Peaje("Peaje6", 9000.0)
        ));

        peajesPorCarretera.put("Medellin-Pereira", Arrays.asList(
                new Peaje("Peaje7", 6000.0)
        ));

        peajesPorCarretera.put("Barranquilla-Cartagena", Arrays.asList(
                new Peaje("Peaje9", 7000.0)
        ));

        peajesPorCarretera.put("Bucaramanga-SantaMarta", Arrays.asList(
                new Peaje("Peaje11", 6000.0)
        ));


        addPeajes(grafo, medellin, bogota, peajesPorCarretera.get("Medellin-Bogotá"));
        addPeajes(grafo, bogota, cali, peajesPorCarretera.get("Bogotá-Cali"));
        addPeajes(grafo, cali, barranquilla, peajesPorCarretera.get("Cali-Barranquilla"));
        addPeajes(grafo, pereira, manizales, peajesPorCarretera.get("Medellin-Pereira"));
        addPeajes(grafo, cartagena, santaMarta, peajesPorCarretera.get("Barranquilla-Cartagena"));
        addPeajes(grafo, bucaramanga, santaMarta, peajesPorCarretera.get("Bucaramanga-SantaMarta"));
        addPeajes(grafo, bogota, bucaramanga, null);
        addPeajes(grafo, barranquilla, cartagena, null);
        addPeajes(grafo, medellin, manizales, null);
        addPeajes(grafo, medellin, pereira, null);
        addPeajes(grafo, manizales, bogota, null);

    }

    /** Add a city to the list of cities.
     * @param city The city to add.
     */
    private void addCities(City city) {
        cities.add(city);
    }

    /** Calculates the least costly route between two cities.
     * @param city1 The name of the origin city.
     * @param city2 The name of the destination city.
     * @return A string representation of the route and its total cost.
     */
    public String routeLessCostly(String city1, String city2){
        City cityOrigin = findCity(city1);
        City cityDestination = findCity(city2);
        String aux = "";

        DijkstraShortestPath<City, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(grafo);
        GraphPath<City, DefaultWeightedEdge> shortestPath = dijkstra.getPath(cityOrigin, cityDestination);

        for (City city :shortestPath.getVertexList()) {
            aux += "->  "+  city.getName()+" \n";
        }


        return "Ruta: " + "\n" +  aux + "Total Coste -->  " + shortestPath.getWeight() ;
    }

    /** Finds a city by its name.
     * @param city The name of the city to find.
     * @return The city object if found, null otherwise.
     */
    private City findCity(String city) {
        for (City cityAux : cities) {
            if(cityAux.getName().equals(city)){
                return cityAux;
            }
        }
        return null;
    }


    /** Add tolls to the graph edges between two cities.
     * @param graph The graph to add edges to.
     * @param cityOrigin The origin city.
     * @param cityDestination The destination city.
     * @param peajes The list of tolls between the two cities.
     */
    private void addPeajes(Graph<City, DefaultWeightedEdge> graph, City cityOrigin, City cityDestination , List<Peaje> peajes) {
        double priceTotal = 0;

        if(peajes != null){
            for (Peaje peaje : peajes) {
                priceTotal += peaje.getPrice();
            }
        }

        DefaultWeightedEdge peajeEdge = graph.addEdge(cityOrigin, cityDestination);
        graph.setEdgeWeight(peajeEdge, priceTotal);

        DefaultWeightedEdge peajeEdgeReverse = graph.addEdge(cityDestination, cityOrigin);
        graph.setEdgeWeight(peajeEdgeReverse, priceTotal);
    }


}
