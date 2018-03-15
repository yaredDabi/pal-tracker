package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    public InMemoryTimeEntryRepository() {
    }

    Map<Long,TimeEntry> timeEntryHashMap = new HashMap<Long,TimeEntry>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(timeEntryHashMap.size()+1);
        timeEntryHashMap.put(timeEntry.getId(),timeEntry);
        return timeEntry;
    }

    @Override
    public void delete(long id) {
        timeEntryHashMap.remove(id);
    }

    @Override
    public TimeEntry find(long id) {
        if(!timeEntryHashMap.containsKey(id))
            return null;
        return timeEntryHashMap.get(id);
    }


    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        timeEntry.setId(id);
        timeEntryHashMap.put(id, timeEntry);
        return find(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(timeEntryHashMap.values());
    }

    @Override
    public boolean contains(long id) {
        return timeEntryHashMap.containsKey(id);
    }
}
