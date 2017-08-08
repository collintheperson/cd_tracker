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

        get("/form", (request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/posts/add", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String albumName = request.queryParams("albumName");
            Tracker newTracker = new Tracker(albumName);
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/success", (request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
