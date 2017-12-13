package rememberme.io.rememberme.Day;

import java.util.ArrayList;

/**
 * Created by JW on 2017-12-10.
 */

public class Day {

    private int seq;
    private String alias;

    private ArrayList<String> spotNames;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public ArrayList<String> getSpotNames() {
        return spotNames;
    }

    public void setSpotNames(ArrayList<String> spotNames) {
        this.spotNames = spotNames;
    }
}
