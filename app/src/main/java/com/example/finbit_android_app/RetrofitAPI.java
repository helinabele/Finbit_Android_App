package com.example.finbit_android_app;

import retrofit2.*;
import retrofit2.http.*;

public interface RetrofitAPI {
    @GET("employees/")

        // as we are calling data from array
        // so we are calling it with json object
        // and naming that method as getCourse();
    Call<Response> getEmployees();
}
