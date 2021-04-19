package com.example.radio_foreground_service.model;

import android.media.Image;

import com.example.radio_foreground_service.R;

public class RadioStation {
    private String streamLink;
    private String radioName;

    public String getRadioImageLink() {
        return radioImageLink;
    }

    private String radioImageLink;
    public RadioStation(){
        this.streamLink="http://stream.whus.org:8000/whusfm";
        this.radioName="Chill";
        this.radioImageLink="https://whus.org/wp-content/uploads/2015/01/whusheader.png";


    }
    public RadioStation(String streamLink, String radioName, String radioImageLink){
        this.streamLink= streamLink;
        this.radioName= radioName;
        this.radioImageLink= radioImageLink;
    }

    public String getStreamLink() {
        return streamLink;
    }

    public String getRadioName() {
        return radioName;
    }

}
