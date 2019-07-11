package demo.endpoint;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;
import com.google.gson.Gson;
import com.googlecode.objectify.Key;
import demo.entity.Account;
import demo.util.StringUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class AccountEndpoint extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(AccountEndpoint.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Account> accountList = ofy().load().type(Account.class).list();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().print(new Gson().toJson(accountList));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = StringUtil.getContentFromInputStream(req.getInputStream());

//        Account account = new Gson().fromJson(content, Account.class);
        JSONObject jsonObject = new JSONObject(content);
        String username = jsonObject.getString("username");

        JSONArray items = jsonObject.getJSONArray("items");



//        Key<Account> key = ofy().save().entity(account).now();
//        resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
//        resp.setStatus(HttpServletResponse.SC_CREATED);
//
//        HashMap<String, Object> mapData = new HashMap<>();
//        mapData.put("username", account.getUsername());
//
//        resp.getWriter().print(new Gson().toJson(mapData));
    }
}
