import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ApiHelper {
    private static String generatedText = UUID.randomUUID().toString();

    public static JsonObject createUser() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n        \"accepted_terms\": \"true\",\n        \"email\": \"" + generatedText + "@gamil.com\",\n        \"full_name\": \"mnats_avagyan1lkj\",\n        \"password\": \"253388pap\",\n        \"type\": \"public\",\n        \"username\": \"" + generatedText + "\"\n    }");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/auth/register")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        JsonParser.parseString(jsonString).getAsJsonObject();
        return JsonParser.parseString(jsonString).getAsJsonObject();
    }

    public static void main(String[] args) throws IOException {
        createUser();
    }

}
