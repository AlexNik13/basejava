package main.mapper;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonPrintMapper {

    private GsonPrintMapper() {
    }

    public static String toGson (Object o){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson (o);
    }



}
