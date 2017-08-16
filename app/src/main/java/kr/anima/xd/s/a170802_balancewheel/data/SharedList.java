package kr.anima.xd.s.a170802_balancewheel.data;

/**
 * Created by alfo6-10 on 8/7/2017.
 */

public class SharedList {

    public String title;
    public String title_sub;
    public String txt;
    public Boolean hasImg=false;
    public String imgUrl;

    public SharedList(String title, String title_sub, String txt, Boolean hasImg, String imgUrl) {
        this.title = title;
        this.title_sub = title_sub;
        this.txt = txt;
        this.hasImg = hasImg;
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_sub() {
        return title_sub;
    }

    public void setTitle_sub(String title_sub) {
        this.title_sub = title_sub;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Boolean getHasImg() {
        return hasImg;
    }

    public void setHasImg(Boolean hasImg) {
        this.hasImg = hasImg;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
