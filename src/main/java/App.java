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
            Map<String,Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/success", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String formInput = request.queryParams("formInput");
            Tracker newTracker = new Tracker(formInput);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/add", (request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get ("/view", (request, response) -> {
            Map<String,Object>model = new HashMap<>();
            ArrayList<Tracker> trackers = Tracker.getAll();
            model.put("instances",trackers);

            return new ModelAndView(model, "view.hbs");
        },   new HandlebarsTemplateEngine());
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
