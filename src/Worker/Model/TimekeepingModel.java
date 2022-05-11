package Worker.Model;

import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;

public class TimekeepingModel {
    public TimekeepingModel () {

    }

    public boolean checkWorkerIn(String id) {
        return true;
    }
    public boolean checkWorkerOut(String id) {
        return true;
    }
    public boolean checkWorkerID(String id) {
        return true;
    }

    public ArrayList<String> getWorkerIDList() {
        return null;
    }

    public ArrayList<Pair<String, Boolean>> getTimekeepingData() {
        return null;
    }

    public void updateTimekeepingData(){

    }
}
