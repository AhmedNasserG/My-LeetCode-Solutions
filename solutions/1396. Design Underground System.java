class UndergroundSystem {
    private HashMap<Integer, Wrapper> checkedInUsers;
    private HashMap<String, List<Integer>> trips;
    public UndergroundSystem() {
        checkedInUsers = new HashMap<>();
        trips = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkedInUsers.put(id, new Wrapper(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        String trip = checkedInUsers.get(id).getStationName() + "," + stationName;
        int duration = t - checkedInUsers.get(id).getTime();
        checkedInUsers.remove(id);
        trips.putIfAbsent(trip, new ArrayList());
        trips.get(trip).add(duration);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        List<Integer> tripDurations = trips.get(startStation + "," + endStation);
        int sum = 0;
        for (int duration : tripDurations) {
            sum += duration;
        }
        return sum * 1.0 / tripDurations.size();
    }
    
    
    private static class Wrapper{
        private String stationName;
        private int time;
        Wrapper(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
        
        String getStationName() {
            return this.stationName;
        }
        
        int getTime() {
            return this.time;
        }
    }
}
