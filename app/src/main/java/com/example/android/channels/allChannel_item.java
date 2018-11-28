package com.example.android.channels;

public class allChannel_item {

    String name_channel,
            trdd_channel,
            astqtap_tchannel,
            veritical_channel;

    public allChannel_item(String name_channel, String trdd_channel, String astqtap_tchannel, String veritical_channel) {
        this.name_channel = name_channel;
        this.trdd_channel = trdd_channel;
        this.astqtap_tchannel = astqtap_tchannel;
        this.veritical_channel = veritical_channel;
    }

    public String getName_channel() {
        return name_channel;
    }

    public void setName_channel(String name_channel) {
        this.name_channel = name_channel;
    }

    public String getTrdd_channel() {
        return trdd_channel;
    }

    public void setTrdd_channel(String trdd_channel) {
        this.trdd_channel = trdd_channel;
    }

    public String getAstqtap_tchannel() {
        return astqtap_tchannel;
    }

    public void setAstqtap_tchannel(String astqtap_tchannel) {
        this.astqtap_tchannel = astqtap_tchannel;
    }

    public String getVeritical_channel() {
        return veritical_channel;
    }

    public void setVeritical_channel(String veritical_channel) {
        this.veritical_channel = veritical_channel;
    }
}
