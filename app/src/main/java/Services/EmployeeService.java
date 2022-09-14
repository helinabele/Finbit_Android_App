package Services;

import retrofit2.*;
import retrofit2.converter.gson.*;

public class EmployeeService {

    String getEmployeeList(){
        final String BASE_URL = "https://bikerental.pythonanywhere.com/employees/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return "";
    }
}
