/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stuff;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Random;

/**
 *
 * @author Alex
 */
public class CreateData {

    private static String[] fName = {"alex", "marco", "david", "hans", "lisa", "cecilie", "martin", "ida"};
    private static String[] lName = {"hansen", "jensen", "blum", "christiansen", "rasmusen", "alexsen", "larsen", "Niggar"};
    private static String[] city = {"københavn", "amsterdam", "ushuia", "niggerton", "Detroit", "the ghetto", "georgetown", "City"};
    private static String[] street = {"murderavenue 69", "roskildevej 12", "Thevej 42", "NoStreet 1337", "drivebybulavard 9001", "cancerally 30", "aidsstreet 4", "MahStreet 6"};

    public static JsonArray getData(int num, String prop) {

        boolean[] props2 = new boolean[4];
        JsonArray ja = new JsonArray();

        String[] props;
        Random ran = new Random();
        if (prop.indexOf(",") != -1) {
            props = prop.split(",");
        } else {
            props = new String[1];
            props[0] = prop;
        }

        for (String p : props) {
            if (p.equals("fname")) {
                props2[0] = true;
            }
            if (p.equals("lname")) {
                props2[1] = true;
            }
            if (p.equals("street")) {
                props2[2] = true;
            }
            if (p.equals("city")) {
                props2[3] = true;
            }
        }

        for (int i = 0; i < num; i++) {
            JsonObject jo = new JsonObject();
            if (props2[0]) {
                jo.addProperty("fname", fName[ran.nextInt(8)]);
            }
            if (props2[1]) {
                jo.addProperty("lname", lName[ran.nextInt(8)]);
            }
            if (props2[2]) {
                jo.addProperty("street", street[ran.nextInt(8)]);
            }
            if (props2[3]) {
                jo.addProperty("city", city[ran.nextInt(8)]);
            }
            ja.add(jo);
        }
        return ja;
    }

    public static void main(String[] args) {
        System.out.println(getData(30, "fname,lname,street,city").toString());
    }
}
