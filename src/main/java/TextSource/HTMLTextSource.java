package TextSource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HTMLTextSource implements TextSource {
    private final String url;

    public HTMLTextSource(@Value(value = "@{url}") String url) {
        this.url = url;
    }

    @Override
    public String getText() {
        return getText(this.url);
    }

    private Document downloadDocument(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
           throw new IllegalArgumentException(e);
        }
        return document;
    }

    private String getText(String url) {
        Document document = downloadDocument(url);
        StringBuilder textBuilder = new StringBuilder();
        Elements tags = document.select("*");
        for (Element tag : tags) {
            for (TextNode textNode : tag.textNodes()) {
                String text = textNode.text().trim();
                if (text.length() > 0) {
                    textBuilder.append(text).append(" ");
                }
            }
        }
        return textBuilder.toString();
    }


}
