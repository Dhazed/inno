package it.infocert.demoportal.beans;

public class MobileCaptureBody {
    String base64Content;
    String mimeType;
    
    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public MobileCaptureBody() {
    }

    public MobileCaptureBody(String base64Content) {
        this.base64Content = base64Content;
    }

    public String getBase64Content() {
        return base64Content;
    }

    public void setBase64Content(String base64Content) {
        this.base64Content = base64Content;
    }
}
