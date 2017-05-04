
package com.blibli.future.model;

import com.blibli.future.model.primaryKey.AttendanceKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Attendance {
	@EmbeddedId
    private AttendanceKey attendanceKey;
	private LocalTime tapIn;
	private LocalTime tapOut;

    public Attendance() {}

    //TODO: IMPLEMENT TAP TIME LOGIC
    public Attendance(String nik, LocalDate date, LocalTime tap) {
        this(nik, date, tap, null);
    }

    public Attendance(String nik, LocalDate date, LocalTime tapIn, LocalTime tapOut) {
        this.attendanceKey = new AttendanceKey(nik, date);
        this.tapIn = tapIn;
        this.tapOut = tapOut;
    }

    public void assign(LocalTime tapTime) {
        if(this.getTapOut() == null) {
            if(tapTime.isBefore(this.tapIn)) {
                this.tapOut = tapIn;
                this.tapIn = tapTime;
            } else {
                this.tapOut = tapTime;
            }
        } else {
            if(tapTime.isBefore(tapIn)) {
                this.tapIn = tapTime;
            } else if(tapTime.isAfter(tapOut)) {
                this.tapOut = tapTime;
            }
        }
    }

    public String getNik() {
        return this.attendanceKey.getNik();
    }

    public LocalDate getDate() {
        return this.attendanceKey.getDate();
    }

    public LocalTime getTapIn() {
        return tapIn;
    }

    public void setTapIn(LocalTime tapIn) {
        this.tapIn = tapIn;
    }

    public LocalTime getTapOut() {
        return tapOut;
    }

    public void setTapOut(LocalTime tapOut) {
        this.tapOut = tapOut;
    }
}
