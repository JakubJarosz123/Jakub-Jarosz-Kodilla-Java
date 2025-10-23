package com.kodilla.exception.index;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class VideoCollector {

    public List<String> getCollection() {
        ArrayList<String> videos = new ArrayList<>();
        videos.add("Extra Movie");
        return videos;
    }
}
