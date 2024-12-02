package it.infocert.demoportal.service.util;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import java.util.Map;

import it.infocert.demoportal.beans.MobileCaptureBody;
import it.infocert.demoportal.beans.MobileCaptureConfirm;
import it.infocert.demoportal.beans.MobileCaptureRes;

import java.util.HashMap;

@Path("/photofrommobile")
public class PhotofromMobileService {
    
    private static Map<String,MobileCaptureBody> b64Content = new HashMap<>();
    MobileCaptureRes res;

    @GET
    public MobileCaptureRes status(@QueryParam("idMobileSession") String idMobileSession) {
      MobileCaptureRes res = new MobileCaptureRes();
        if (idMobileSession == null) {
          res.setStatus("err - idMobileSession is null");
        } else {
          if (b64Content.containsKey(idMobileSession)){
              res.setStatus("completed");
              res.setB64Content(b64Content.get(idMobileSession).getBase64Content());
              res.setMimeType(b64Content.get(idMobileSession).getMimeType());
              b64Content.remove(idMobileSession);            
          } 
        }
        return res;
    }

    @POST
    public MobileCaptureConfirm postImage(@QueryParam("idMobileSession") String idMobileSession, MobileCaptureBody body) {
        b64Content.put(idMobileSession, body);
        return new MobileCaptureConfirm(idMobileSession, "recived");
    }
}
