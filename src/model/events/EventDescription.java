package model.events;

import java.time.LocalDate;

public class EventDescription {
    private String description;
    private LocalDate eventDate;
    private LocalDate applicationsDeadline;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalDate getApplicationsDeadline() {
        return applicationsDeadline;
    }

    public void setApplicationsDeadline(LocalDate applicationsDeadline) {
        this.applicationsDeadline = applicationsDeadline;
    }
}
