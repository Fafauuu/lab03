package model.events;

import java.util.Date;

public class EventDescription {
    private String description;
    private Date eventDate;
    private Date applicationsDeadline;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getApplicationsDeadline() {
        return applicationsDeadline;
    }

    public void setApplicationsDeadline(Date applicationsDeadline) {
        this.applicationsDeadline = applicationsDeadline;
    }
}
