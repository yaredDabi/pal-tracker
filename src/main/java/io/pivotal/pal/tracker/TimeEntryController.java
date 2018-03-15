package io.pivotal.pal.tracker;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;
    private ResponseEntity responseEntity;

    public TimeEntryController() {
    }

    public TimeEntryController(TimeEntryRepository timeEntriesRepo) {
        this.timeEntryRepository = timeEntriesRepo;
    }

    @PostMapping(value = "time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        TimeEntry timeEntry1 = timeEntryRepository.create(timeEntry);
        /*HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity responseEntity = new ResponseEntity<>(timeEntry1,responseHeaders, HttpStatus.CREATED);*/

        return new ResponseEntity<>(timeEntry1, HttpStatus.CREATED);
    }

    @GetMapping(value = "/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        if(timeEntryRepository.contains(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        TimeEntry timeEntry  = timeEntryRepository.find(id);
        return new ResponseEntity<>(timeEntry,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntryList = timeEntryRepository.list();
        return new ResponseEntity<List<TimeEntry>>(timeEntryList, HttpStatus.OK);
    }

    @PutMapping(value = "/time-entries/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry expected) {
        TimeEntry timeEntry = timeEntryRepository.update(id,expected);
        if(timeEntry == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //TimeEntry timeEntry = timeEntryRepository.update(id,expected);
        return new ResponseEntity<>(timeEntry,HttpStatus.OK);
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {
        timeEntryRepository.delete(id);
        if(timeEntryRepository.contains(id)==false)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(timeEntryRepository.find(id),HttpStatus.OK);
    }
}
