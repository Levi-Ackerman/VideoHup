package controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by lee on 17-4-3.
 */

public class AotuController extends Controller{
    int cur = 0;
    public static final String NETEASY_BASE_URL = "http://www.aotu9.com";
    public static final String RECENT = "http://www.aotu9.com/recent/";
    public Result spider() {

        try {
            Document document = Jsoup.connect(RECENT+"2").get();
            Elements elements = document.select(".videos").select("a[href]");
            StringBuilder sb = new StringBuilder();
            for (Element link : elements) {
                String url = NETEASY_BASE_URL + link.attr("href");
                Document videoDoc = Jsoup.connect(url).get();
                String videoUrl = videoDoc.getElementsByTag("source").get(0).attr("src");
                sb.append(videoUrl).append('\n');
            }
            return ok(sb.toString());
        }catch(Exception exceptions){
            exceptions.printStackTrace();
            return notFound(exceptions.toString());
        }
    }
}
