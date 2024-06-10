package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/tracks")
public class TrackController {
    private List<Track> trackQueue = new ArrayList<>();

    @PostMapping("/add")
    public void addTrack(@RequestBody Track track) {
        trackQueue.add(track);
        System.out.println("Track added to the queue: " + track.getTrackName());
    }

    @PostMapping("/rate")
    public void rateTrack(@RequestParam int liked) {
        // logic to handle track rating
        if (liked == 1) {
            System.out.println("Track liked by client.");
        } else if (liked == 0) {
            System.out.println("Track disliked by client.");
        }
    }

    @GetMapping("/queue")
    public List<Track> getTrackQueue() {
        return trackQueue;
    }

    @DeleteMapping("/remove")
    public void removeFirstTrack() {
        if (!trackQueue.isEmpty()) {
            Track removedTrack = trackQueue.remove(0);
            System.out.println("Removed track from the queue: " + removedTrack.getTrackName());
        } else {
            System.out.println("Track queue is already empty.");
        }
    }
}
