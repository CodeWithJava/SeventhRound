class Solution {
    public String alienOrder(String [] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        Map<Character, AlienChar> graph = new HashMap<>();

        boolean isSuccessed = buildGraph(graph, words);

        if (!isSuccessed) {
            return "";
        }

        String order = findOrder(graph);

        return order.length() == graph.size() ? order:"";
    }

    private boolean buildGraph(Map<Character, AlienChar> graph, String [] words) {
        initialize(graph, words);

        Set<String> exist = new HashSet<>();

        for (int i = 1;i < words.length;i++) {
            String p = words[i - 1];
            String q = words[i];

            // Handle the corner case: ["abc", "ab"]
	    if (p.length() > q.length() && p.startsWith(q)) {
                return false;
            }

            Character prev = null;
            Character next = null;

            for (int j = 0;j < p.length() && j < q.length();j++) {
                if (p.charAt(j) != q.charAt(j)) {
                    prev = p.charAt(j);
                    next = q.charAt(j);
                    break;
                }
            }

            if (prev != null && exist.contains(next + "" + prev)) {
                return false;
            }

            if (prev != null && !exist.contains(prev + "" + next)) {
                addEdge(graph, prev, next);
                exist.add(prev + "" + next);
            }
        }

        return true;
    }

    private void addEdge(Map<Character, AlienChar> graph, char prev, char next) {
        AlienChar prevAlienChar = graph.get(prev);
        AlienChar nextAlienChar = graph.get(next);

        prevAlienChar.nextVertexes.add(nextAlienChar);
        nextAlienChar.inDegree++;

        graph.put(prev, prevAlienChar);
        graph.put(next, nextAlienChar);
    }

    private void initialize(Map<Character, AlienChar> graph, String [] words) {
        for (String word: words) {
            for (char c: word.toCharArray()) {
                if (!graph.containsKey(c)) {
                    graph.put(c, new AlienChar(c));
                }
            }
        }
    }

    private String findOrder(Map<Character, AlienChar> graph) {
        Queue<AlienChar> q = new LinkedList<>();

        for (char c: graph.keySet()) {
            AlienChar x = graph.get(c);

            if (x.inDegree == 0) {
                q.offer(x);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            AlienChar x = q.poll();
            sb.append(x.val);

            for (AlienChar node: x.nextVertexes) {
                if (--node.inDegree == 0) {
                    q.offer(node);
                }
            }
        }

        return sb.toString();
    }
}
class AlienChar {
    char val;
    int inDegree;
    List<AlienChar> nextVertexes;

    AlienChar(char val) {
        this.val = val;
        inDegree = 0;
        nextVertexes = new ArrayList<>();
    }
}
