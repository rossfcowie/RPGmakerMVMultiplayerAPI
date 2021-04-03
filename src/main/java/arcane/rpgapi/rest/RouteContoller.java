package arcane.rpgapi.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RouteContoller {
    @GetMapping(value = "/")
    public String index() {
        return "/APITest/www/index.html";
    }

    @GetMapping(value = "/home")
    public String home() {
        return "/APITest/www/index.html";
    }
    @GetMapping(value = "/js/{file}")
    public String js(@PathVariable String file) {
        return "/APITest/www/js/" +file;
    }
    @GetMapping(value = "/js/libs/{file}")
    public String jslibs(@PathVariable String file) {
        return "/APITest/www/js/libs/" +file;
    }
    @GetMapping(value = "/js/plugins/{file}")
    public String jsplugs(@PathVariable String file) {
        return "/APITest/www/js/plugins/" +file;
    }
    @GetMapping(value = "/fonts/{file}")
    public String fonts(@PathVariable String file) {
        return "/APITest/www/fonts/" +file;
    }
    @GetMapping(value = "/data/{file}")
    public String data(@PathVariable String file) {
        return "/APITest/www/data/" +file;
    }
    @GetMapping(value = "/img/{folder}/{file}")
    public String img(@PathVariable String file,@PathVariable String folder) {
        return "/APITest/www/img/" + folder+"/" +file;
    }

    @GetMapping(value = "/audio/{folder}/{file}")
    public String audio(@PathVariable String file,@PathVariable String folder) {
        return "/APITest/www/audio/" + folder+"/" +file;
    }
}
