package org.cat.eye.leetcode;

import java.util.*;
import java.util.stream.Collectors;

// not workable for n = 6, [[0,1], [1,2], [0,2], [1,3], [3,4], [4,5], [3,5]], expected [[1,3]]
public class CriticalConnections {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        Map<Integer, List<List<Integer>>> nodes = new HashMap<>();

        for (List<Integer> conn : connections) {
            for (Integer node : conn) {
                List<List<Integer>> directions = nodes.computeIfAbsent(node, d -> new LinkedList<>());
                directions.add(conn);
            }
        }

        return nodes.values().stream().filter(lists -> lists.size() == 1).map(lists -> lists.get(0)).distinct().collect(Collectors.toList());
    }

}
