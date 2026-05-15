package com.coditas.restaurantmanagementsystem.constants;

public interface ApiPaths {

    String BASE_API = "/api/v1";

    interface Admin{
        String BASE = BASE_API + "/admin";

        String INVITATIONS = "/invitations";
    }

}
