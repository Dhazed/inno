package it.infocert.demoportal.beans;

public class MobileCaptureRes {

    String status;
    String b64Content;
    String mimeType;
    
    public String getMimeType() {
        return mimeType;
    }
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
    public MobileCaptureRes() {
        this.status = "waiting";
        this.b64Content = null;
        this.mimeType = null;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getB64Content() {
        return b64Content;
    }
    public void setB64Content(String b64Content) {
        this.b64Content = b64Content;
    }
    
}
