package com.inbum.busexample;

import java.util.List;

public class SampleEvent {
    // the sampleList object being sent using the bus
    private List<Sample> sampleList;

    public SampleEvent(List<Sample> sampleList)
    {
        this.sampleList = sampleList;
    }

    /**
     * @return the sampleList
     */
    public List<Sample> getList()
    {
        return sampleList;
    }

}
