package com.example.popatiya.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.NonNull;

@Entity
public class jobs {

    @EmbeddedId
    @NonNull
    public jobsid jobsId;

    @NonNull
    public int count;

    public jobs(jobsid jobid, int cont) {
        jobsId = jobid;
        count = cont;
    }

    public jobs() {
        super();
    }

    public jobsid getJobsId() {
        return jobsId;
    }

    public void setJobsId(jobsid jobsId) {
        this.jobsId = jobsId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
