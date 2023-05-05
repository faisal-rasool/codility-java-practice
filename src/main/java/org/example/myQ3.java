package org.example;
import java.util.*;
public class myQ3 {
    public boolean solution(int N, int[] A, int[] B) {
        // graph is a hashmap which maps each node to a set of its neighbours
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        // initializing the graph with empty sets
        // initially all nodes point towards an empty set
        for (int i = 0; i < N; i++) {
            graph.put(i, new HashSet<>());
        }

        // for each edge A[i],B[i]
        for (int i = 0; i < A.length; i++) {
            // -1 operation is only done to translate 1 index to 0 index
            graph.get(A[i] - 1).add(B[i] - 1);  // adding B[i] as neighbour of A[i]
            graph.get(B[i] - 1).add(A[i] - 1);  // adding A[i] as neighbour of B[i]
        }

        for (int i = 0; i < N - 1; i++) {
            // if any consecutive nodes i and i+1 are not each other's neighbours return false
            if (!graph.get(i).contains(i + 1)) {
                return false;
            }
        }
        return true; // path found
    }
}