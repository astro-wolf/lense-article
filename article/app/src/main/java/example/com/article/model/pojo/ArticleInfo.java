package example.com.article.model.pojo;

import com.google.gson.annotations.SerializedName;

public class ArticleInfo {

    @SerializedName("title")
    public String title = "";
    @SerializedName("description")
    public String description = "";
    @SerializedName("urlToImage")
    public String image = "";

}
