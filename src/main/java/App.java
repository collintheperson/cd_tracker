import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Tracker;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

/**
 * Created by Guest on 8/8/17.
 */
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            System.out.println("hello");
            Map<String,Object> model = new HashMap<String, Object>();
            ArrayList<Tracker> trackers = Tracker.getAll();

            model.put("albumInfo",trackers);

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/success", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String albumInfo = request.queryParams("album"); //""
            System.out.println();
            Tracker newTracker = new Tracker(albumInfo);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/add", (request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

//        get ("/view", (request, response) -> {
//            Map<String,Object>model = new HashMap<String, Object>();
//
//            return new ModelAndView(model, "index.hbs");
//        },   new HandlebarsTemplateEngine());

//        post("/success", (request, response) -> {
//            Map<String,Object> model = new HashMap<String, Object>();
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/delete", (request, response) -> {
//            Map<String,Object> model = new HashMap<String, Object>();
//            return new ModelAndView(model, "delete.hbs");
//        }, new HandlebarsTemplateEngine());




    }
}
