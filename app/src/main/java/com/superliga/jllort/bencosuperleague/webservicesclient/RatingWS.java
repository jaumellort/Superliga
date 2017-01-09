package com.superliga.jllort.bencosuperleague.webservicesclient;

/**
 * Created by jllort on 12/21/2016.
 */

import com.superliga.jllort.bencosuperleague.dto.LoginResponse;
import com.superliga.jllort.bencosuperleague.dto.Rating;
import com.superliga.jllort.bencosuperleague.dto.WSBasicResponse;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class RatingWS {

        public static final String METHOD = "setRating";
        public static final String NAMESPACE = "https://bencosuperleague.000webhostapp.com/webservices/server.php";
        public static final String SERVICE_URI = "https://bencosuperleague.000webhostapp.com/webservices/server.php";

        public WSBasicResponse getLogin(Rating rating) {
            SoapObject rpc = new SoapObject(SERVICE_URI, METHOD);
            rpc.addProperty("match_id", rating.getMatchId());
            rpc.addProperty("id_rater", rating.getRaterId());
            rpc.addProperty("id_rated", rating.getRatedId());
            rpc.addProperty("rating", rating.getRating());
            rpc.addProperty("comments", rating.getComments());
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(rpc);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICE_URI);
            WSBasicResponse wsResponse = new WSBasicResponse();
            String response = "false";
            try {
                androidHttpTransport.debug = true;
                androidHttpTransport.call("https://bencosuperleague.000webhostapp.com/webservices/server.php/setRating", envelope);
                wsResponse.setResultOk(Boolean.parseBoolean((String) ((SoapObject)envelope.bodyIn).getProperty(0)));
                if (!wsResponse.isResultOk()) {
                    wsResponse.setException("El usuario o la constrase\u00f1a introducida no son correctas");
                }
            } catch (Exception e) {
                wsResponse.setResultOk(false);
                wsResponse.setException("Ha ocurrido un error. Por favor intentelo m\u00e1s tarde");
            }
            return wsResponse;
        }
    }

