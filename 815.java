public class Solution {
	public int numBusesToDestination(int [][] routes, int S, int T) {
		if(routes == null || routes.length == 0 || routes[0].length == 0)
			return -1;

		if(S == T)
			return 0;

		int n = routes.length;
		List<List<Integer>> graph = new ArrayList<>();

		for(int i = 0;i < n;i++) {
			Arrays.sort(routes[i]);
			graph.add(new ArrayList<>());
		}

		for(int i = 0;i < n;i++) {
			for(int j = i + 1;j < n;j++) {
				if(intersect(routes[i], routes[j])) {
					graph.get(i).add(j);
					graph.get(j).add(i);
				}
			}
		}

		Set<Integer> visited = new HashSet<>();
		Set<Integer> targets = new HashSet<>();
		Queue<int []> q = new LinkedList<>();

		for(int i = 0;i < n;i++) {
			if(Arrays.binarySearch(routes[i], S) >= 0) {
				visited.add(i);
				q.offer(new int [] {i, 0});
			}

			if(Arrays.binarySearch(routes[i], T) >= 0)
				targets.add(i);
		}

		while(!q.isEmpty()) {
			int [] x = q.poll();
			int bus = x[0];
			int depth = x[1];

			if(targets.contains(bus))
				return depth + 1;

			for(int next: graph.get(bus)) {
				if(!visited.contains(next)) {
					visited.add(next);
					q.offer(new int [] {next, depth + 1});
				}
			}
		}

		return -1;
	}

	private boolean intersect(int [] r1, int [] r2) {
		int i = 0;
		int j = 0;

		while(i < r1.length && j < r2.length) {
			if(r1[i] == r2[j])
				return true;
			
			if(r1[i] < r2[j])
				i++;
			else
				j++;
		}

		return false;
	}
}