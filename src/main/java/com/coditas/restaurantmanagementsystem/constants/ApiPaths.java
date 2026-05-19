package com.coditas.restaurantmanagementsystem.constants;

public interface ApiPaths {

    String BASE_API = "/api/v1";

    interface Common{
        String INVITATIONS = "/invitations";
        String REGISTER = "/register";
    }

    interface Auth{
        String BASE = BASE_API + "/auth";

        String LOGIN = "/login";
    }

    interface Admin{
        String BASE = BASE_API + "/admin";

        String INVITATIONS = Common.INVITATIONS;
    }

    interface RestaurantOwner{
        String BASE = BASE_API + "/restaurant-owner";

        String REGISTER = Common.REGISTER;

        String INVITATIONS = Common.INVITATIONS;
    }

    interface RestaurantManager{
        String BASE = BASE_API + "/restaurant-manager";

        String REGISTER = Common.REGISTER;

        String INVITATIONS = Common.INVITATIONS;
    }

    public interface BranchManager {
        String BASE = BASE_API + "/branch-manager";

        String REGISTER = Common.REGISTER;
    }
}
