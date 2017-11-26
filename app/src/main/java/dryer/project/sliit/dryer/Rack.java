package dryer.project.sliit.dryer;


public class Rack {

    int id;
    String rack_id;
    String ratio;
    String timestamp;


    public Rack() {
    }

    public Rack(int id, String rack_id, String ratio, String timestamp) {
        this.id = id;
        this.rack_id = rack_id;
        this.ratio = ratio;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getRack_id() {
        return rack_id;
    }

    public String getRatio() {
        return ratio;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
