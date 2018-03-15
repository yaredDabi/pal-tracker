package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry timeEntry);
    public void delete(long id);
    public TimeEntry find(long id);
    public TimeEntry update(long id, TimeEntry timeEntry);
    public List<TimeEntry> list();
    public boolean contains(long id);
}
