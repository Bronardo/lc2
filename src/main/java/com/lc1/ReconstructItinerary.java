package com.lc1;

import java.util.*;

public class ReconstructItinerary {
    Map<String, PriorityQueue<String>> trip = new HashMap<>();
    List<String> path=new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> t:tickets)
            trip.computeIfAbsent(t.get(0),d->new PriorityQueue<>()).add(t.get(1));
        travel("JFK");
        return path;
    }

    void travel(String port) {
        while(trip.containsKey(port) && !trip.get(port).isEmpty())
            travel(trip.get(port).poll());
        path.add(0, port);
    }
}
