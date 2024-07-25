class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        set.addAll(wordList);

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(beginWord, 1));

        while (!q.isEmpty()) {
            Node x = q.poll();
            String word = x.word;

            if (word.equals(endWord)) {
                return x.step;
            }

            char [] alphabets = word.toCharArray();

            for (int i = 0;i < alphabets.length;i++) {
                char t = alphabets[i];

                for (char c = 'a';c <= 'z';c++) {
                    if (alphabets[i] != c) {
                        alphabets[i] = c;

                        String newWord = new String(alphabets);

                        if (set.contains(newWord)) {
                            q.offer(new Node(newWord, x.step + 1));
                            set.remove(newWord);
                        }
                    }
                }

                alphabets[i] = t;
            }
        }

        return 0;
    }
}
class Node {
    int step;
    String word;

    Node(String word, int step) {
        this.word = word;
        this.step = step;
    }
}
