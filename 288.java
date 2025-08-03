class ValidWordAbbr {
    Map<String, Set<String>> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();

        if (dictionary == null || dictionary.length == 0) {
            return;
        }

        for (String s: dictionary) {
            String abbr = getAbbreviation(s);

            if (!map.containsKey(abbr)) {
                map.put(abbr, new HashSet<>());
            }

            map.get(abbr).add(s);
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = getAbbreviation(word);

        if (!map.containsKey(abbr)) {
            return true;
        }

        Set<String> set = map.get(abbr);

        return set.size() == 1 && set.contains(word);
    }

    private String getAbbreviation(String s) {
        return s.length() < 3 ? s:s.substring(0, 1) + (s.length() - 2) + s.substring(s.length() - 1);
    }
}
