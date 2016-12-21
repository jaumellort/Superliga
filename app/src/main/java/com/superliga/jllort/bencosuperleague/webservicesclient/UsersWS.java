package com.superliga.jllort.bencosuperleague.webservicesclient;

/**
 * Created by jllort on 12/21/2016.
 */


import com.superliga.jllort.bencosuperleague.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class UsersWS {


    public static final String GET_ALL_ACTIVE_USERS_METHOD = "getAllActiveUsers";
    public static final String NAMESPACE = "https://bencosuperleague.000webhostapp.com/webservices/server.php";
    public static final String SERVICE_URI = "https://bencosuperleague.000webhostapp.com/webservices/server.php";

    public List<User> getAllActiveUsers() {
        List<User> result = new ArrayList<User>();
        SoapObject rpc = new SoapObject(SERVICE_URI, GET_ALL_ACTIVE_USERS_METHOD);
        //rpc.addProperty("email", usr);
        //rpc.addProperty("pass", pass);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(rpc);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(SERVICE_URI);
        try {
            androidHttpTransport.debug = true;
            androidHttpTransport.call("https://bencosuperleague.000webhostapp.com/webservices/server.php/getAllActiveUsers", envelope);
            String res = envelope.getResponse().toString();
            SoapObject root = (SoapObject)  envelope.bodyIn;
            int buildings = root.getPropertyCount();

            for (int i = 0; i < buildings; i++) {
                Vector userSoapObject = (Vector) root.getProperty(i);
                User user = new User();
                user.setId(Integer.valueOf(userSoapObject.get(0).toString()).intValue());
                user.setName(userSoapObject.get(1).toString());
                user.setGamerTag(userSoapObject.get(2).toString());
               // user.setTransactionTypeString(userSoapObject.getProperty("TransactionTypeString").toString());
               // user.setBuildingTypeString(userSoapObject.getProperty("BuildingTypeString").toString());
                result.add(user);
            }
            //result.setBuildingsList(buildingsList);
           // result.setStatusCode(DtoContext.STATUS_CODE_OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //res = e.getMessage();
        }
        return result;
    }
}