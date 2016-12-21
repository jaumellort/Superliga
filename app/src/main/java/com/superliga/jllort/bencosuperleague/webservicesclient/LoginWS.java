package com.superliga.jllort.bencosuperleague.webservicesclient;

/**
 * Created by jllort on 12/21/2016.
 */

        import com.superliga.jllort.bencosuperleague.dto.LoginResponse;

        import org.ksoap2.SoapEnvelope;
        import org.ksoap2.serialization.SoapObject;
        import org.ksoap2.serialization.SoapSerializationEnvelope;
        import org.ksoap2.transport.HttpTransportSE;

public class LoginWS {

        public static final String METHOD = "getLogin";
        public static final String NAMESPACE = "https://bencosuperleague.000webhostapp.com/webservices/server.php";
        public static final String SERVICE_URI = "https://bencosuperleague.000webhostapp.com/webservices/server.php";

        public LoginResponse getLogin(String usr, String pass) {
            SoapObject rpc = new SoapObject(SERVICE_URI, METHOD);
            rpc.addProperty("email", usr);
            rpc.addProperty("pass", pass);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(rpc);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICE_URI);
            LoginResponse loginResponse = new LoginResponse();
            String response = "false";
            try {
                androidHttpTransport.debug = true;
                androidHttpTransport.call("https://bencosuperleague.000webhostapp.com/webservices/server.php/getLogin", envelope);
                loginResponse.setLoginOK(Boolean.parseBoolean((String) ((SoapObject)envelope.bodyIn).getProperty(0)));
                if (!loginResponse.isLoginOK()) {
                    loginResponse.setException("El usuario o la constrase\u00f1a introducida no son correctas");
                }
            } catch (Exception e) {
                loginResponse.setLoginOK(false);
                loginResponse.setException("Ha ocurrido un error. Por favor intentelo m\u00e1s tarde");
            }
            return loginResponse;
        }
    }

